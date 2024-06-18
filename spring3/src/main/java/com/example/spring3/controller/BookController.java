package com.example.spring3.controller;

import com.example.spring3.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookMapper bookMapper;

    @RequestMapping("book/list")
    public String list(Model model) {
        model.addAttribute("books", bookMapper.findAll());
        return "book/list";

    }

}
