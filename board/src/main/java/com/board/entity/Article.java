package com.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor  // 기본 생성자(필수)
@Data
@SequenceGenerator(name = "ID_SEQ_GENERATOR", sequenceName = "article_seq", initialValue = 1, allocationSize = 1)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ_GENERATOR")
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if(article.content != null)
            this.content = article.content;
    }
}
