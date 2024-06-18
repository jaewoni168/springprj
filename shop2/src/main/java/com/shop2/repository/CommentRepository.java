package com.shop2.repository;

import com.shop2.entity.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select c "
            + "from Comment c "
            + "join Member u on c.author=u "
            + "where u.email = :email "
            + "order by c.createDate desc ")
    List<Comment> findCurrentComment(@Param("email") String email,
                                       Pageable pageable);

}
