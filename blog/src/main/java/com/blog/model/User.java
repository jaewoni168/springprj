package com.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false, length =100, unique = true)
    private String username;

    @Column(nullable=false, length =100)
    private String password;

    @Column(nullable=false, length =100)
    private String email;

    //@ColumnDefault("'user'")
    //private String role;
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp  // 시간 자동 입력
    private Timestamp createDate;

    @OneToMany(mappedBy="user",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"user"})
    @OrderBy("id desc")
    @ToString.Exclude
    private List<Board> boards;
}
