package com.board.repository;

import com.board.entity.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Override
    ArrayList<Article> findAll();
    ArrayList<Article> findAll(Sort sort);

}
