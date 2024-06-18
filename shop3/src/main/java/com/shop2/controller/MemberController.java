package com.shop2.controller;

import com.shop2.dto.MailDto;
import com.shop2.dto.MemberFormDto;
import com.shop2.dto.MemberUpdateDto;
import com.shop2.entity.Member;
import com.shop2.repository.MemberRepository;
import com.shop2.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
 @Autowired
 private MemberRepository memberRepository;
 @Autowired
 private MailService mailService;

 private final QuestionService questionService;
 private final AnswerService answerService;
 private final MemberService memberService;
 private final CommentService commentService;
 private final PasswordEncoder passwordEncoder;


 @GetMapping(value = "/new")
 public String memberForm(Model model){
  model.addAttribute("memberFormDto", new MemberFormDto());
  return "member/memberForm";
 }

 //일반회원가입

 @PostMapping(value = "/new")
 public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){

  if(bindingResult.hasErrors()){
   return "member/memberForm";
  }

  try {
   Member member = Member.createMember(memberFormDto, passwordEncoder);
   memberService.saveMember(member);
  } catch (IllegalStateException e){
   model.addAttribute("errorMessage", e.getMessage());
   return "member/memberForm";
  }
  return "redirect:/";
 }


 @GetMapping(value = "/newAdmin")
 public String adminMemberForm(Model model) {
  model.addAttribute("memberFormDto", new MemberFormDto());
  return "member/memberForm";
 }


 // 관리자 회원가입
 // 검증하려는 객체의 앞에 @Valid 어노테이션을 선언하고, 파라미터로 bindingResult 객체 추가
 // 검사 후 결과는 bindingResult에 담아줌.
 @PostMapping(value = "/newAdmin")
 public String newAdminMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
  if(bindingResult.hasErrors()) {         // 에러가 있다면 회원 가입 페이지로 이동
   return "member/memberForm";
  }

  try {
   Member member = Member.createAdminMember(memberFormDto, passwordEncoder);
   memberService.saveMember(member);
  } catch (IllegalStateException e) {
   model.addAttribute("errorMessage", e.getMessage());

   // 회원 가입 시 중복 회원 가입 예외가 발생하면 에러 메시지를 뷰로 전달
   return "member/memberForm";
  }
  return "redirect:/";
 }

 @GetMapping(value = "/login")
 public String loginMember(){
  return "/member/memberLoginForm";
 }

 @GetMapping(value = "/login/error")
 public String loginError(Model model){
  model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
  return "/member/memberLoginForm";
 }

 // 마이페이지
 @GetMapping("/loginInfo")
 public String memberInfo(Principal principal, ModelMap modelMap){
  String loginId = principal.getName();
  Member member = memberRepository.findByEmail(loginId);
  modelMap.addAttribute("member", member);

  return "myPage/myInfo";
 }

 // 회원 비밀번호 찾기
 @GetMapping(value = "/findMember")
 public String findMember(Model model) {
  return "/member/findMemberForm";
 }

 // 비밀번호 찾기시, 임시 비밀번호 담긴 이메일 보내기
 @Transactional
 @PostMapping("/sendEmail")
 public String sendEmail(@RequestParam("memberEmail") String memberEmail){
  MailDto dto = mailService.createMailAndChangePassword(memberEmail);
  mailService.mailSend(dto);

  return "/member/memberLoginForm";
 }

 // 회원 아이디 찾기

 @RequestMapping(value = "/findId", method = RequestMethod.POST)
 @ResponseBody
 public String findId(@RequestParam("memberEmail") String memberEmail) {
  String email = String.valueOf(memberRepository.findByEmail(memberEmail));
  System.out.println("회원 이메일 = " + email);
  if (email == null) {
   return null;
  } else {
   return email;
  }
 }

 /* 회원 수정하기 전 비밀번호 확인 */

 @GetMapping("/checkPwdForm")
 public String checkPwdView() {
  return "member/passwordCheckForm";
 }

 @GetMapping("/checkPwd")
 @ResponseBody
 public boolean checkPassword(Principal principal, Member member, @RequestParam String checkPassword, Model model){

  String loginId = principal.getName();
  Member memberId = memberRepository.findByEmail(loginId);

  // memberRepository에서 이메일을 찾는다.
  return memberService.checkPassword(memberId, checkPassword);
 }

 // 회원 정보 변경 폼 (GET)
 @GetMapping(value = "/updateForm")
 public String updateMemberForm(Principal principal, Model model) {
  String loginId = principal.getName();
  Member memberId = memberRepository.findByEmail(loginId);
  model.addAttribute("member", memberId);

  return "/settings/memberUpdateForm";
 }

 @PostMapping(value = "/updateForm")
 public String updateMember(MemberUpdateDto memberUpdateDto, Model model) {
  model.addAttribute("member", memberUpdateDto);
  memberService.updateMember(memberUpdateDto);
  return "redirect:/members/loginInfo";
 }

 @PreAuthorize("isAuthenticated()")
 @GetMapping(value= "/profile")
 public String profile(Model model, Principal principal) {
  String email = principal.getName();

  model.addAttribute("name", email);

  model.addAttribute("questionList",
          questionService.getCurrentListByUser(email, 5));

  model.addAttribute("answerList",
          answerService.getCurrentListByUser(email, 5));

  model.addAttribute("commentList",
          commentService.getCurrentListByUser(email, 5));

  return "board/profile";
 }

}  //end