package com.resultMap1.dto;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    int id;
    String departmentName;
    String shortName;
    String phone;

    List<Student> students;
}