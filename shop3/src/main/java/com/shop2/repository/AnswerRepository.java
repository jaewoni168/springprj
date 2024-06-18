package com.shop2.repository;

import com.shop2.entity.Answer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select a "
            + "from Answer a "
            + "join Member u on a.author=u "
            + "where u.email = :email "
            + "order by a.createDate desc ")
    List<Answer> findCurrentAnswer(@Param("email") String email, Pageable pageable);
}
