package com.jpa4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sugang")
public class Sugang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    boolean repeated;
    boolean cancel;
    String grade;

    @ManyToOne
    @JoinColumn(name = "lectureId")
    Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "studentId")
    Student student;

}
