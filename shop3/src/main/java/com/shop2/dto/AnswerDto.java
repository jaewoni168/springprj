package com.shop2.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AnswerDto {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
