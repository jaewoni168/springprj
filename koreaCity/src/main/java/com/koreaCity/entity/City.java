package com.koreaCity.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45) // nullable = false,
    private String name;

    @Column
    private int population;

    @Column
    private int area;

    @ManyToOne
    @JoinColumn(name = "districtId")
    District district;
}
