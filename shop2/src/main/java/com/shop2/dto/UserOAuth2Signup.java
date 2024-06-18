//package com.shop2.dto;
//
//import com.shop2.constant.Role;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//
//@Data
//public class UserOAuth2Signup {
//
//    @NotEmpty(message="이름을 입력하세요")
//    @Size(min=2, max=30)
//    String name;
//
//    @NotEmpty(message="이메일 주소를 입력하세요")
//    @Email(message="이메일 주소가 올바르지 않습니다")
//    String email;
//
//    @NotEmpty(message="사용자 유형을 선택하세요")
//    @Pattern(regexp="관리자|일반", message="가입 가능한 회원유형은 관리자, 일반 입니다")
//    Role role;
//
//
//}
