package com.thymeleaf.controller;

import com.thymeleaf.dto.ItemDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/thyme")
public class ThymeEx01 {

    @GetMapping(value="ex01")
    public String thymeEx01(Model model){
        model.addAttribute("data","타임리프 예제입니다.");
        return "thyme/ex01" ;
    }

    @GetMapping(value="ex02")
    public String thymeEx02(Model model){
        ItemDto itemDto = new ItemDto();

        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(2000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto",itemDto);
        return "thyme/ex02" ;
    }

    @GetMapping(value = "ex03")
    public String thymeEx03(Model model){

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1;i<=10;i++){
            ItemDto itemDto = new ItemDto();

            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(2000*i);
            itemDto.setRegTime(LocalDateTime.now());
            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thyme/Ex03";
    }

    @GetMapping(value = "ex04")
    public String thymeEx04(Model model){

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1;i<=10;i++){

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(2000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thyme/Ex04";
    }

    @GetMapping(value = "ex05")
    public String thymeEx05(){
        return "thyme/Ex05";
    }

    @GetMapping(value = "ex06")
    public String thymeEx06(String param1, String param2, Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thyme/Ex06";
    }

    @GetMapping(value = "ex07")
    public String thymeEx07(Model model){
        model.addAttribute("msg","welcome to my world");
        return "thyme/Ex07";
    }
}
