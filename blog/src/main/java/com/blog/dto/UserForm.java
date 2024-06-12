package com.blog.dto;

import com.blog.model.User;
import lombok.*;

@AllArgsConstructor
@Data
public class UserForm {
    private String username;
    private String password;
    private String email;
    private String role;

}
