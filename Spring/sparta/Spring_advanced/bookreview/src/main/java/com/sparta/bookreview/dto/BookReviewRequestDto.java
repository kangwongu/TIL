package com.sparta.bookreview.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookReviewRequestDto {
    private String title;
    private String author;
    private String review;
}
