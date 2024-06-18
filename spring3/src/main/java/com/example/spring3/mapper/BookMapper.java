package com.example.spring3.mapper;

import com.example.spring3.dto.Book;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("""
            SELECT b.*, c.name categoryName
             FROM book b JOIN category c ON b.categoryId = c.id """)
    List<Book> findAll();

}
