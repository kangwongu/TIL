package com.example.springcore_review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 관심상품 가격 변경 시
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductMypriceRequestDto {
    private int myprice;
}
