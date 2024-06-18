package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// http:/localhost:8088/index
	@RequestMapping("index")
	public String index1(Model model) {
		model.addAttribute("user","강감찬");
		model.addAttribute("message","안녕하세요");
		model.addAttribute("now", new Date());
		return "index";  // index.jsp
		// /WEB-INF/views/ 폴더에서 찾는다.
	}
	
	// http://localhost:8088/
	@RequestMapping({"" , "/"})
	public String index2(Model model) {
		model.addAttribute("user","강감찬");
		model.addAttribute("message","환영합니다.");
		model.addAttribute("now", new Date());
		return "index2";  // index.jsp
		// /WEB-INF/views/ 폴더에서 찾는다.
	}
	
	// http:/localhost:8088/hello
	@GetMapping("hello")
	public String hello() {
		return "hello"; // hello.jsp
	}
	
	@GetMapping("date1")
	public String date1() {
		return "date1";
	}
	
	@GetMapping("loop1")
	public String loop1() {
		return "loop1";
	}
	
	@GetMapping("loop2")
	public String loop2() {
		return "loop2";
	}
	
	@GetMapping("loop3")
	public String loop3() {
		return "loop3";
	}
	
	@GetMapping("if1")
	public String if1() {
		return "if1";
	}
	
	@GetMapping("if2")
	public String if2() {
		return "if2";
	}
}
