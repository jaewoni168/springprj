package com.board.service;

import com.board.dto.ArticleForm;
import com.board.entity.Article;
import com.board.repository.ArticleRepository;
import com.board.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 서비스에서는 dto 를 entity 로 변환하고 repository 에서 저장한 결과를 컨트롤러에 보내준다.
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> index() {
        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();

        if(dto.getId() == article.getId()) return null;
        Article saved = articleRepository.save(article);
        return saved;
    }

    public Article update(Long id, ArticleForm dto) {
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        Article updated;

        if (target == null || !id.equals(article.getId())) {
            return null;
        }else{
            target.patch(article);
            updated = articleRepository.save(target);
            return updated;
        }
    }


    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null){
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {

        // dto 묶음을 entity 묶음으로 변환
//        List<Article> articleList = dtos.stream()
//                .map(dto -> dto.toEntity())
//                .collect(Collectors.toList());
        // for 문으로
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i< dtos.size(); i++){
            ArticleForm dto = dtos.get(i);
            Article entity = dto.toEntity();
            articleList.add(entity);
        }


        // entity 묶음을 DB로 저장
        // articleList.stream().forEach(article -> articleRepository.save(article));

        // for 문으로
        for (int i = 0; i< articleList.size(); i++){
            Article article = articleList.get(i);
            articleRepository.save(article);
        }


        // 강제 예외 발생 (강제 예외가 발생하면 저장이 안된다.)
        //articleRepository.findById(-1L).orElseThrow(()-> new IllegalArgumentException("결제 실패!"));

        return articleList;
    }

//    @Transactional
//    public void deleteById(int Id) {
//        CommentRepository.deleteById(ArticleId);
//        ArticleRepository.delteByArticleId(Id);
//    }
}
