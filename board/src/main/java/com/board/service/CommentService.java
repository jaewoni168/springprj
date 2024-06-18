package com.board.service;

import com.board.repository.CommentRepository;
import com.board.dto.CommentDto;
import com.board.entity.Article;
import com.board.entity.Comment;
import com.board.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {

       // 조회: 댓글 목록
       List<Comment> comments = commentRepository.findByArticleId(articleId);

       // 변환: 엔티티 -> DTO
        List<CommentDto> dtos = comments.stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());

        return dtos;
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        log.info("입력값 => {}", articleId);
        log.info("입력값 => {}", dto);

        // 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId).orElseThrow(()
                -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));

        // 댓글 앤티티 생성
        Comment comment = Comment.createComment(dto, article);
        // 댓글 엔티티를 DB로 저장
        Comment created = commentRepository.save(comment);

        // DTO로 변경하여 반환
        CommentDto createDto = CommentDto.createCommentDto(created);

        log.info("반환값 => {}", createDto);
        return createDto;
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));

        // 댓글 수정
        target.patch(dto);  // 수정 -> 더티체킹

        // DB로 갱신
        // Comment updated = commentRepository.save(target);  // 안해도 된다.
        // 엔티티에 변화가 있으면 알아서 save를 실행한다.

        // 댓글 엔티티를 DTO로 변환 및 반환
        return CommentDto.createCommentDto(target);
    }

    public CommentDto delete(Long id) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("댓글 삭제 실패! 대상 댓글이 없습니다."));

        // 댓글 삭제
        commentRepository.delete(target);

        // 삭제 댓글을 DTO로 변환
        return CommentDto.createCommentDto(target);
    }

    public List<Comment> nickNameComments(String nickname) {
        List<Comment> comments = commentRepository.findByNickname(nickname);
        return comments;
    }

    // api
    public List<CommentDto> apiNickNameComments(String nickname) {
        List<Comment> comments = commentRepository.findByNickname(nickname);
        List<CommentDto> dtos = comments.stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
        return dtos;
    }
}
