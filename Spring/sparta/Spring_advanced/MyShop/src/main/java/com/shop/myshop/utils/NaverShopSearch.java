package com.shop.myshop.utils;

import com.shop.myshop.dto.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// 네이버 검색 API
@Component  // 빈에 등록
public class NaverShopSearch {
    public String search(String query) {
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

        return response;
        // 응답받은 JSON의 items배열에 검색결과가 내려옴옴
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i=0; i<items.length(); i++) {
            JSONObject itemJson = (JSONObject) items.get(i);
            ItemDto itemDto = new ItemDto(itemJson);

            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }
}
