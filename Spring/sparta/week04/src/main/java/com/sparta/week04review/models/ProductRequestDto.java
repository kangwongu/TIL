package com.sparta.week04review.models;

import lombok.Getter;

// 관심 상품 등록 시 주고받을 데이터들을 담아놓는 클래스
@Getter
public class ProductRequestDto {

    private String title;
    private String image;
    private String link;
    private int lprice; // 최저가
}
