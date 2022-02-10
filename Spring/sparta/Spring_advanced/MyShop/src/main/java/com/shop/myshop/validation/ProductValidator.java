package com.shop.myshop.validation;

import com.shop.myshop.dto.ProductRequestDto;

public class ProductValidator {

    public static void validateProduct(ProductRequestDto productRequestDto) {
        if(productRequestDto.getTitle() == null || productRequestDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 상품명입니다.");
        }

        if(!URLValidation.isValidURL(productRequestDto.getImage())) {
            throw new IllegalArgumentException("유효하지 않은 이미지 URL 입니다.");
        }

        if(!URLValidation.isValidURL(productRequestDto.getLink())) {
            throw new IllegalArgumentException("유효하지 않은 상품 최저가 URL 입니다.");
        }

        if(productRequestDto.getLprice() <= 0) {
            throw new IllegalArgumentException("상품 최저가가 0 이하입니다.");
        }
    }
}
