package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form1Controller {
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("form1/text1")
	public String text1(Model model) {   // model은 인터페이스
		return"form1/text1"; // form1 밑에 text1.jsp
	}
	
	@PostMapping("form1/text1")
	public String text1(Model model, String param1, String param2) {
		System.out.println(param1);
		System.out.println(param2);
		return "form1/text1";
	}
	
	@GetMapping("form1/text2")
    public String text2(Model model) {
        model.addAttribute("param1", "hello");
        model.addAttribute("param2", "world");
        model.addAttribute("now", new Date());
        
        return "form1/text1";
    }

    @PostMapping("form1/text2")
    public String text2(Model model, String param1, String param2) {
        
    	 System.out.println(param1);
         System.out.println(param2);
         System.out.println(new Date());
    	
        model.addAttribute("param1", "hello");
        model.addAttribute("param2", "word");
        model.addAttribute("now", new Date());

        return "form1/text1";

    }

}
