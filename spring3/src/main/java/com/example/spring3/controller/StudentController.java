package com.example.spring3.controller;

import com.example.spring3.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired // 안내자 -> mapper
    StudentMapper studentMapper;  // DI  (의존성 주입)

    @RequestMapping("student/list")
    public String list(Model model) {
        model.addAttribute("students", studentMapper.findAll());
        return "student/list";
    }

    @RequestMapping("student/list1")
    public String list1(Model model, String srchText) {
        if (srchText == null) srchText = "";
        model.addAttribute("students", studentMapper.findByName(srchText + "%"));
        model.addAttribute("srchText", srchText);
        return "student/list1";
    }

    @RequestMapping("student/detail/{id}")

    public String detail(Model model, @PathVariable Integer id) {
        if (id == null) id = 4;
        model.addAttribute("student", studentMapper.findById(id));
        return "student/detail";
    }
}
