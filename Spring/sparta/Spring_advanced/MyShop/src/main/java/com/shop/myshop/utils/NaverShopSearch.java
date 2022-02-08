package com.shop.myshop.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

// 네이버 검색 API
public class NaverShopSearch {
    public void search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id","KYLAUEXJ4BCUErigMPMS");
        headers.add("X-Naver-Client-Secret","rJATsm5fGM");
        String body = "";

        // 네이버에 요청
        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class);

        // 응답 받음 (JSON)
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: "+status);
        System.out.println(response);

        // 응답받은 JSON의 items배열에 검색결과가 내려옴옴
    }
    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        naverShopSearch.search("아이맥");

    }
}
