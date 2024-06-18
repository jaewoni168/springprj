package com.jpa6h.service;

import com.jpa6h.entity.District;
import com.jpa6h.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

 @Autowired
 public DistrictRepository districtRepository;

 public List<District> findAll(){
  return districtRepository.findAll();
 }

}
