package com.shop.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

// 관심상품 등록시 사용하는 Dto
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String title;
    private String link;
    private String image;
    private int lprice;     // 최저가
}
