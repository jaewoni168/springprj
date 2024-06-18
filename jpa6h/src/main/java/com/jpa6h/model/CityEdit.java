package com.jpa6h.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CityEdit {
 int id;

 @NotEmpty
 @NotBlank
 @Size(min=2, max=6)
 String name;

 @NotEmpty
 String population;

 @NotEmpty
 String area;

 @Min(value=1, message="도를 선택하세요.")
 int districtId;


}
