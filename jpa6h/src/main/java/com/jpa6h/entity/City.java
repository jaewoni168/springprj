package com.jpa6h.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.query.named.ModelPartResultMementoEntity;

@Data
@Entity
public class City {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 int id;

 String name;
 //String districtId;
 String population;
 String area;

 @ManyToOne
 @JoinColumn(name = "districtId")
 District district;

}
