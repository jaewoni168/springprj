package com.mybatis5.mapper;

import com.mybatis5.dto.Book;
import com.mybatis5.model.Pagination;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("""
                SELECT b.*, c.name bookCategory
                FROM book b JOIN category c ON b.categoryId = c.id
                ORDER BY b.id
                LIMIT #{firstRecordIndex}, #{sz}
                """)
    List<Book> findAll(Pagination pagination);

    @Select("SELECT COUNT(id) FROM book")
    int getCount();
}

