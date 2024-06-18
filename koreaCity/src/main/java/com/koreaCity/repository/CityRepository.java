package com.koreaCity.repository;

import com.koreaCity.entity.City;
import com.koreaCity.entity.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    City findByName(String name);

    Page<City> findByNameStartsWith(
            String name, Pageable pageable);

    Page<City> findByNameStartsWithOrDistrictDistrictNameStartsWith(
            String name, String district, Pageable pageable);
}
