package com.jpa1.controller;

import com.jpa1.entity.Book;
import com.jpa1.entity.Category;
import com.jpa1.entity.Department;
import com.jpa1.repository.BookRepository;
import com.jpa1.repository.CategoryRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("list")
    public String list(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Book book = new Book();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        return "book/edit";
    }

    @PostMapping("create")
    public String create(Model model, Book book) {
        bookRepository.save(book);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id){
        Book book = bookRepository.findById(id).get();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        return "book/edit";
    }
    @PostMapping(value="edit", params="cmd=save")

    public String edit(Model model, Book book) {

        bookRepository.save(book);

        return "redirect:list";

    }

    @PostMapping(value="edit", params="cmd=delete")

    public String delete(Model model, @RequestParam("id") int id) {

        bookRepository.deleteById(id);

        return "redirect:list";

    }

    @RequestMapping("book/list2")

    public String list2(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return bookRepository.findAll().toString();

    }
}
