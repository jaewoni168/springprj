package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@GetMapping("form6/edit")
	public String edit(Model model) {
		return "form6/edit";
	}
	
	@PostMapping("form6/edit")
	public String edit(Model model, HttpSession session, Student student)
	{
		String errorMsg = null;
		if (student.studentNo == null || student.studentNo.length() == 0)
			errorMsg = "학번을 입력하시오";
		else if (student.name == null || student.name.length()==0)
			errorMsg = "이름을 입력하시오";
		else if (student.email == null || student.email.length()==0)
			errorMsg = "이메일을 입력하시오";
		else if (student.departmentId==0)
			errorMsg = "전공을 선택하시오";
		else {
			session.setAttribute("student", student);
			return "redirect:edit_success";
		}
		
		model.addAttribute("student", student);
		model.addAttribute("errorMsg", errorMsg);
		return "form6/edit";
		
		}
	@RequestMapping("form6/edit_success")
	public String edit_success(Model model){
		return "form6/edit_success";
	}

}
