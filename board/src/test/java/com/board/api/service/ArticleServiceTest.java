package com.board.api.service;

import com.board.dto.ArticleForm;
import com.board.entity.Article;
import com.board.service.ArticleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();

        // 검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show성공() {
        Long id = 4L;  // id 가 4라는 의미
        Article expected = new Article(id, "이순신","장군");

        // 실제
        Article article = articleService.show(id);

        // 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show실패() {
        Long id = 6L;
        Article expected = new Article(id, "이순신", "장군");

        // 실제
        Article article = articleService.show(id);

        // 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void create성공() {
        String title = "라라라라2";
        String content = "5555";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(38L, title, content);

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void create실패() {
        String title = "라라라라2";
        String content = "5555";
        ArticleForm dto = new ArticleForm(38L, title, content);
        Article expected = null;

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected, article);
    }


    @Test
    void update성공() {
        Long id = 1L;
        String title = "이사";
        String content = "장난";

        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(6L,title, content);

        Article article = articleService.update(id, dto);
        Assertions.assertEquals(expected.toString(), article.toString());
    }

    @Test
    void update실패() {
        Long id = 116L;
        String title = "사이";
        String content = "난장";

        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        Article article = articleService.update(id, dto);
        Assertions.assertEquals(expected, article);
    }

    @Test
    void delete성공() {
        Long id = 6L;
        ArticleForm dto = new ArticleForm(id, null, null);
        Article expected = new Article(id, "이정", "장군");

        Article article = articleService.delete(id);

        assertEquals(expected.toString(), article.toString());


    }

    @Test
    void delete실패() {
        Long id = 66L;
        ArticleForm dto = new ArticleForm(id, null, null);
        Article expected = null;

        Article article = articleService.delete(id);

        assertEquals(expected, article);
    }
}