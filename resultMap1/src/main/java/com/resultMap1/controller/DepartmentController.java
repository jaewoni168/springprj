package com.resultMap1.controller;

import com.resultMap1.dto.Department;
import com.resultMap1.dto.Student;
import com.resultMap1.mapper.DepartmentMapper;
import com.resultMap1.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("department")

public class DepartmentController {


    @Autowired
    StudentMapper studentMapper;

    @Autowired
    DepartmentMapper departmentMapper;


    @RequestMapping("list")
    public String list(Model model) {
        List<Department> departments = departmentMapper.findAll();
        for (Department department : departments) {
            List<Student> students = studentMapper.findByDepartmentId(department.getId());
            department.setStudents(students);
        }
        model.addAttribute("departments", departments);
        return "department/list";

    }
}