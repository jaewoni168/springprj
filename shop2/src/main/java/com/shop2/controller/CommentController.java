package com.shop2.controller;

import com.shop2.dto.CommentDto;
import com.shop2.entity.Comment;
import com.shop2.entity.Member;
import com.shop2.entity.Question;
import com.shop2.service.CommentService;
import com.shop2.service.MemberService;
import com.shop2.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private MemberService memberService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/create/question/{id}")
    public String createQuestionComment(CommentDto commentForm) {
        return "board/comment_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/create/question/{id}")
    public String createQuestionComment(@PathVariable("id") Integer id, @Valid CommentDto commentDto,
                                        BindingResult bindingResult, Principal principal) {
        Optional<Question> question = Optional.ofNullable(this.questionService.getQuestion(id));
        Optional<Member> member = Optional.ofNullable(this.memberService.getUser(principal.getName()));
        if (question.isPresent() && member.isPresent()) {
            if (bindingResult.hasErrors()) {
                return "board/comment_form";
            }
            Comment c = this.commentService.create(question.get(), member.get(), commentDto.getContent());
            return String.format("redirect:/question/detail/%s", c.getQuestionId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String modifyComment(CommentDto commentDto, @PathVariable("id") Integer id, Principal principal) {
        Optional<Comment> comment = this.commentService.getComment(id);
        if (comment.isPresent()) {
            Comment c = comment.get();
            if (!c.getAuthor().getEmail().equals(principal.getName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
            }
            commentDto.setContent(c.getContent());
        }
        return "board/comment_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String modifyComment(@Valid CommentDto commentDto, BindingResult bindingResult, Principal principal,
                                @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "board/comment_form";
        }
        Optional<Comment> comment = this.commentService.getComment(id);
        if (comment.isPresent()) {
            Comment c = comment.get();
            if (!c.getAuthor().getEmail().equals(principal.getName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
            }
            c = this.commentService.modify(c, commentDto.getContent());
            return String.format("redirect:/question/detail/%s", c.getQuestionId());

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String deleteComment(Principal principal, @PathVariable("id") Integer id) {
        Optional<Comment> comment = this.commentService.getComment(id);
        if (comment.isPresent()) {
            Comment c = comment.get();
            if (!c.getAuthor().getEmail().equals(principal.getName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
            }
            this.commentService.delete(c);
            return String.format("redirect:/question/detail/%s", c.getQuestionId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }
}
