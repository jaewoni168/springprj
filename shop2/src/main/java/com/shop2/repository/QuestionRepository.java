package com.shop2.repository;

import com.shop2.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);

    Page<Question> findAll(Specification<Question> spec, Pageable pageable);

    @Query("select "
            + "distinct q "
            + "from Question q "
            + "left outer join Member u1 on q.author=u1 "
            + "left outer join Answer a on a.question=q "
            + "left outer join Member u2 on a.author=u2 "
            + "where "
            + "   q.subject like %:kw% "
            + "   or q.content like %:kw% "
            + "   or u1.name like %:kw% "
            + "   or a.content like %:kw% "
            + "   or u2.name like %:kw% ")
    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);

    // 프로필
    @Query("select q "
            + "from Question q "
            + "join Member u on q.author=u "
            + "where u.email = :email "
            + "order by q.createDate desc ")
    List<Question> findCurrentQuestion(@Param("email") String email,
                                       Pageable pageable);
}
