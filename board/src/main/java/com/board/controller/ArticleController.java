package com.board.controller;

import com.board.service.CommentService;
import com.board.dto.ArticleForm;
import com.board.dto.CommentDto;
import com.board.entity.Article;
import com.board.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;


    @GetMapping("/articles")
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "perPageNum", defaultValue = "5") int perPageNum,
                        Model model) {

        int totalCount= (int) articleRepository.findAll().stream().count();
        int totalPages = (int) Math.ceil((double) totalCount / perPageNum);

        int start = (pageNum - 1) * perPageNum;
        int end=start+5;

        start= start< 0 ? start=0 : (pageNum - 1) * perPageNum ;
        end= end >=totalCount ? end=totalCount : start+5;

        boolean preStatus;
        boolean nextStatus;

        int[] pageNums = new int[totalPages];
        for(int i=0;i<totalPages;i++){
            pageNums[i]=(i+1);
        }

        int preVious=pageNum-1;
        int next=pageNum+1;
        if(start<=0){
            preStatus=false;
        }else{
            preStatus=true;
        }

        if(end>=totalCount){
            nextStatus=false;
        }else{
            nextStatus=true;
        }

        // List<Article> articleEntityList =articleRepository.findAll().subList(start,end);

        // 내림차순 정렬
        Sort descendingSort = Sort.by(Sort.Direction.DESC, "id");
        List<Article> articleEntityList =articleRepository.findAll(descendingSort).subList(start,end);


        model.addAttribute("articleList", articleEntityList);

        model.addAttribute("pageNums", pageNums);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        model.addAttribute("preVious", preVious);
        model.addAttribute("next", next);
        model.addAttribute("preStatus",preStatus);
        model.addAttribute("nextStatus",nextStatus);
        model.addAttribute("pageNum",pageNum);

        log.info("pre {}, next {}", preStatus, nextStatus);
        log.info("start {}, end {}, totalCount {}", start, end, totalCount);

        return"articles/index";
    }

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm){
        System.out.println(articleForm.toString());

        // 1. dto 를 Entity 로 변환
        Article article = articleForm.toEntity();

        // 2. repository 에게 entity 를 DB에 저장하게 한다.
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        // 콘솔창에 Hibernate: insert 가 들어가고 Article 에 내용이 들어가면 성공

        return "redirect:/articles";

        // 특정 상세 페이지를 가고 싶으면
        // return "redirect:/articles" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        // id로 데이터를 가져온다.
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentsDtos = commentService.comments(id);
//        Article articleEntity = articleRepository.findById(id).orElseThrow(()-> {
//            return new IllegalArgumentException("해당 유저는 없습니다. id:" + id);
//        });
        // 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentsDtos);

        // 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //Optional<Article> articleEntity = articleRepository.findById(id);

        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        // 수정 폼으로 데이터 전송
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm articleForm){

        log.info("articlesForm:"+articleForm.toString());


        // 1. dto 를 Entity 로 변환
        Article articleEntity = articleForm.toEntity();

        // DB 에 기존 데이터를 가져온다.
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2. repository 에게 entity 를 DB에 저장하게 한다.
        if(target != null)
            articleRepository.save(articleEntity);

        // 수정한 결과문으로 가기
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes msg) {

        Article target = articleRepository.findById(id).orElse(null);

        if (target != null) {
            articleRepository.delete(target);
            msg.addFlashAttribute("msg", "삭제가 완료되었습니다.");
            log.info("msg:" + msg.getFlashAttributes());
        }
        // 3: 결과 페이지로 리다이렉트
        return "redirect:/articles";
    }
}
