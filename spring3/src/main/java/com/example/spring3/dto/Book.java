package com.example.spring3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    int id;
    String title;
    String author;
    int categoryId;
    int price;
    String publisher;
    String categoryName;
}
