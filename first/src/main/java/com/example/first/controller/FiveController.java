package com.example.first.controller;

import com.example.first.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class FiveController {

    @GetMapping("five/test1")
    public List<Student> test1(Model model) {
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student(1,"200001010", "이순신", "admin@daum.net");
        Student s2 = new Student(2,"200001011", "강감찬", "bdmin@daum.net");
        Student s3 = new Student(3,"200001012", "이방원", "cdmin@daum.net");
        Student s4 = new Student(4,"200001013", "원균", "ddmin@daum.net");
        Student s5 = new Student(5,"200001014", "장동건", "edmin@daum.net");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);


        model.addAttribute("studentList", studentList);
        return studentList;
    }
}
