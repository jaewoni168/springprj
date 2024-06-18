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
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    DepartmentMapper departmentMapper;


    @RequestMapping("list")
    public String list(Model model) {
        List<Student> students = studentMapper.findAll();
        for (Student student : students) {
            Department department = departmentMapper.findOne(student.getDepartmentId());
            student.setDepartment(department);
        }
        model.addAttribute("students", students);
        return "student/list";
    }
}
