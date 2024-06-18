package com.koreaCity.controller;

import com.koreaCity.entity.City;
import com.koreaCity.entity.District;
import com.koreaCity.model.CityEdit;
import com.koreaCity.model.Pagination;

import com.koreaCity.service.CityService;
import com.koreaCity.service.DistrictService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    DistrictService districtService;

    @GetMapping("list")
    public String list(Model model, Pagination pagination) {
        List<City> cities = cityService.findAll(pagination);
        model.addAttribute("cities", cities);
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

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
                         @Valid CityEdit cityEdit, BindingResult bindingResult) {
        try {
            cityService.insert(cityEdit, bindingResult, pagination);
            return "redirect:list?" + pagination.getQueryString();
        }
        catch (Exception e) {
            model.addAttribute("districts", districtService.findAll());
            bindingResult.rejectValue("", null, "등록할 수 없습니다.");
            return "city/edit";
        }
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        CityEdit cityEdit = cityService.findOne(id);
        List<District> districts = districtService.findAll();
        model.addAttribute("cityEdit", cityEdit);
        model.addAttribute("districts", districts);
        return "city/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Pagination pagination,
                       @Valid CityEdit cityEdit, BindingResult bindingResult) {
        try {
            cityService.update(cityEdit, bindingResult);
            return "redirect:list?" + pagination.getQueryString();
        }
        catch (Exception e) {
            model.addAttribute("districts", districtService.findAll());
            bindingResult.rejectValue("", null, "수정할 수 없습니다.");
            return "city/edit";
        }
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, Pagination pagination,
                         CityEdit cityEdit, BindingResult bindingResult) {
        try {
            cityService.delete(cityEdit.getId());
            return "redirect:list?" + pagination.getQueryString();
        }
        catch (Exception e) {
            model.addAttribute("districts", districtService.findAll());
            bindingResult.rejectValue("", null, "삭제할 수 없습니다.");
            return "city/edit";
        }
    }
}
