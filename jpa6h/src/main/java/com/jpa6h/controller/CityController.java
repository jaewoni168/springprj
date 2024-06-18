package com.jpa6h.controller;

import com.jpa6h.entity.City;
import com.jpa6h.entity.District;
import com.jpa6h.model.CityEdit;
import com.jpa6h.model.Pagination;
import com.jpa6h.service.CityService;
import com.jpa6h.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {
 @Autowired
 CityService cityService;

 @Autowired
 DistrictService districtService;

 @GetMapping("list")
 public String list(Model model, Pagination pagination) {
  List<City> citys = cityService.findAll(pagination);
  model.addAttribute("citys", citys);
  model.addAttribute("orders", cityService.getOrders());
  return "city/list";
 }


 @GetMapping("create")
 public String create(Model model, Pagination pagination) {

  CityEdit cityEdit = new CityEdit();
  List<District> districts = districtService.findAll();


  model.addAttribute("cityEdit", cityEdit);
  model.addAttribute("districts", districts);
  return "city/edit";
 }


} //
