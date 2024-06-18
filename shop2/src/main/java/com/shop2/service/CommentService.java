package com.shop2.service;

import com.shop2.entity.Answer;
import com.shop2.entity.Comment;
import com.shop2.entity.Member;
import com.shop2.entity.Question;
import com.shop2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment create(Question question, Member author, String content) {
        Comment c = new Comment();
        c.setContent(content);
        c.setCreateDate(LocalDateTime.now());
        c.setQuestion(question);
        c.setAuthor(author);
        c = this.commentRepository.save(c);
        return c;
    }

    public Optional<Comment> getComment(Integer id) {
        return this.commentRepository.findById(id);
    }

    public Comment modify(Comment c, String content) {
        c.setContent(content);
        c.setModifyDate(LocalDateTime.now());
        c = this.commentRepository.save(c);
        return c;
    }

    public void delete(Comment c) {
        this.commentRepository.delete(c);
    }




    public List<Comment> getCurrentListByUser(String email, int num) {
        Pageable pageable = PageRequest.of(0, num);
        return commentRepository.findCurrentComment(email, pageable);
    }
}
