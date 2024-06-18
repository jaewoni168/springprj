package com.board.dto;

import com.board.entity.User;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserForm {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private Timestamp createDate;

    public User toEntity() {
        return new User(id, username, password, email, role, createDate);
    }

}
