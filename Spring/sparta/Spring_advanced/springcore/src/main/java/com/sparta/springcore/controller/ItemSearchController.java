package com.sparta.springcore.controller;

import com.sparta.springcore.dto.ItemDto;
import com.sparta.springcore.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ItemSearchController {

    private final ItemSearchService itemSearchService;

    @Autowired  // 의존성 주입
    public ItemSearchController(ItemSearchService itemSearchService) {
        this.itemSearchService = itemSearchService;
    }
    // Controller 가 자동으로 해주는 일
    // 1. API Request 의 파라미터 값에서 검색어 추출 -> query 변수
    // 5. API Response 보내기
    // 5.1) response 의 header 설정
    // 5.2) response 의 body 설정
    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) throws IOException {

        List<ItemDto> itemDtoList = itemSearchService.getItems(query);

        return itemDtoList;
    }
}
