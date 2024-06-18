package com.example.spring3.controller;

import com.example.spring3.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("department/list")
    public String list(Model model) {
        model.addAttribute("departments", departmentMapper.findAll());
        return "department/list";
    }

}
