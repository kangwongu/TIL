package com.sparta.week04review.models;


import lombok.Getter;

// 내가 설정한 최저가 값을 바꿀 때 주고받을 데이터들을 담아놓을 클래스
@Getter
public class ProductMypriceRequestDto {
    private int myprice;
}
