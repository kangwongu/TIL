package com.sparta.week04.models;

import lombok.Getter;

// 관심 상품 등록시 사용되는 Dto
@Getter
public class ProductRequestDto {
//    title, link, image, lprice
    private String title;
    private String link;
    private String image;
    private int lprice;

}
