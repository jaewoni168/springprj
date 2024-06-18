package com.jpa5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;
    int year;
    String semester;
    String room;

}
