package com.jpa1.controller;

import com.jpa1.entity.Category;
import com.jpa1.entity.Department;
import com.jpa1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("categoreies")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping("category/{id}")
    public Category category(@PathVariable("id") int id) {
        // return departmentRepository.findById(id).get();
        // return departmentRepository.findById(id).orElse(null);
        return categoryRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당유저가 없습니다. " + id); });
        // return departmentRepository.findById(id).orElseThrow(
        // EntityNotFoundException::new);
    }

    @PostMapping("category")
    public boolean insert(@RequestBody Category category) {
        categoryRepository.save(category);
        return true;
    }

    @PutMapping("category")
    public boolean update(@RequestBody Category category) {
        categoryRepository.save(category);
        return true;
    }



    @DeleteMapping("category/{id}")

    public boolean delete(@PathVariable("id") int id) {

        categoryRepository.deleteById(id);

        return true;

    }

    @RequestMapping("category/list1")

    public String list1(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());

        return "category/list1";

    }



    @RequestMapping("category/list2")

    public String list2(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());

        return "category/list2";

    }

}
