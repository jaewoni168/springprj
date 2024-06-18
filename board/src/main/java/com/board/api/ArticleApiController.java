package com.board.api;

import com.board.service.ArticleService;
import com.board.dto.ArticleForm;
import com.board.entity.Article;
import com.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
// 컨트롤에서는 서비스에서 처리한 데이터와 응답신호 만 보내준다.
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;
    // 필드주입
    // @Autowired
    // private ArticleService articleService;

    // 생성자 주입(DI)
    private final ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> index(){
        List<Article> articleList = articleService.index();
        return articleList;
    }

    // 상세조회
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }

    // POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
            return (created != null )?
                    ResponseEntity.status(HttpStatus.OK).body(created):
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,  @RequestBody ArticleForm dto) {
        Article updated = articleService.update(id,dto);

        return (updated != null)?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        // 상태코드와 응답본문을 클라이언트에게 전달
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<String> update(@PathVariable Long id){
        Article deleted = articleService.delete(id);

        return (deleted !=null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        //return ResponseEntity.status(HttpStatus.OK).build();
        // 200 OK 응답신호를 생성하고 본문을 갖지않는 경우에 build 만 붙여준다.
        //return ResponseEntity.status(HttpStatus.OK).body("삭제완료");
        //return ResponseEntity.status(HttpStatus.OK).header("X-MyHeader","welcome").build();

    }

    // 트랜잭션 -> 실패 -> 롤백!
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){

        List<Article> createdList = articleService.createArticles(dtos);
        return (createdList != null)?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
