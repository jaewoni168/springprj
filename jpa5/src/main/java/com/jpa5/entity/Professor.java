package com.jpa5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String phone;
    String email;
    String office;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department department;
}
