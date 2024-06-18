package com.koreaCity.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String districtName;

    @Column
    private int population;

    @Column
    private int area;
}
