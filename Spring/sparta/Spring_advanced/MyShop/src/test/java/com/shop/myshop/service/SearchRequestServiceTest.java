package com.shop.myshop.service;

import com.shop.myshop.utils.NaverShopSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) // Mockito 프레임워크 사용
class SearchRequestServiceTest {

    @Mock   // 가짜 객체를 생성
    NaverShopSearch naverShopSearch;

    private String query;

    @Test
    @DisplayName("정상적인 검색어")
    void enableQuery() {
        // given
        query = "아이맥";

        // when
        String result = naverShopSearch.search(query);
        naverShopSearch.fromJSONtoItems(result);

        // then

    }
}