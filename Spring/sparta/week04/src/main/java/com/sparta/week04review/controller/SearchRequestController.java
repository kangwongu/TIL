package com.sparta.week04review.controller;

import com.sparta.week04review.models.ItemDto;
import com.sparta.week04review.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {

    // 네이버 검색 API를 사용하기 위해 필요
    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
//                      (/api/search?query=검색어)의 query임을 매핑
    public List<ItemDto> getItems(@RequestParam String query) {
        // 1. 네이버 검색 API를 사용해 매개변수로 받은 검색어로 검색한다.
        String resultString = naverShopSearch.search(query);
        // 2. 검색한 결과를 Dto로 담고 반환한다.
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}
