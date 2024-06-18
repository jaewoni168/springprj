package com.mybatis5.controller;

import com.mybatis5.dto.Book;
import com.mybatis5.model.Pagination;
import com.mybatis5.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("book/list")
    public String list(Model model, Pagination pagination, HttpServletRequest request) {

        log.info("get URL {}", request.getRequestURL().toString());

        pagination.setUrl(request.getRequestURI().toString());
        List<Book> books = bookService.findAll(pagination);
        model.addAttribute("books", books);
        return "book/list";
    }

}
