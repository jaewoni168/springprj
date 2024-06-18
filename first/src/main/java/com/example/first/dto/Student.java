package com.example.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Student {
    int id;
    String studentNumber;
    String studentName;
    String email;
}
