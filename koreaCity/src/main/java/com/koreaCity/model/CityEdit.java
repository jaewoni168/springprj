package com.koreaCity.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CityEdit {
    private int id;

    @NotEmpty(message = "필수입력항목입니다.")
    @NotBlank(message = "공백일 수 없습니다.")
    @Size(min=2, max=20)
    private String name;

    @Min(value=1, message = "도를 선택하세요.")
    private String districtId;

    @Positive(message = "인구를 선택하세요.")
    private int population;

    @Positive(message = "면적을 선택하세요.")
    private int area;





}
