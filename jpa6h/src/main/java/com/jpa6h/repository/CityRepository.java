package com.jpa6h.repository;

import com.jpa6h.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {

 City findByName(String name);

 Page<City> findByNameOrDistrictStartsWith(
    String name, String district, Pageable pageable);
}
