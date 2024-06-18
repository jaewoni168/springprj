package com.mybatis5.service;


import com.mybatis5.dto.Book;
import com.mybatis5.mapper.BookMapper;
import com.mybatis5.model.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

        public List<Book> findAll (Pagination pagination){

            pagination.setRecordCount(bookMapper.getCount());

            return bookMapper.findAll(pagination);

        }
    }
