package com.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// @DynamicInsert
public class User {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된
    private Long id; // 시퀀스 , auto_increment

    @Column(nullable = false, length = 30)
    // @Column
    private String username; // 아이디

    @Column(nullable = false, length = 100) // 123456=>해쉬(비밀번호 암호화)
    //@Column
    private String password; //

    @Column(nullable = true, length = 100)
    //@Column
    private String email;

    @ColumnDefault("'user'")
    private String role; // Enum을 쓰는게 좋다. admin, user, maneger
    //@Enumerated(EnumType.STRING)
    //private RoleType role;

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;

}
