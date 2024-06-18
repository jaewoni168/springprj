package com.koreaCity.service;


import com.koreaCity.entity.District;

import com.koreaCity.repository.DistrictRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class DistrictService {

    @Autowired
    public DistrictRepository districtRepository;

    public List<District> findAll(){
        return districtRepository.findAll();
    }
}
