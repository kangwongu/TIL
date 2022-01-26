package com.sparta.week04review.utils;

import com.sparta.week04review.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component  // 스프링에게 필요할 때 알아서 갖다쓰라고 권한을 주는 것
public class NaverShopSearch {

    // 네이버 검색API를 활용해 검색하는 메소드
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "KYLAUEXJ4BCUErigMPMS");
        headers.add("X-Naver-Client-Secret", "rJATsm5fGM");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    // 검색 결과를 Dto에 담고, Dto리스트를 반환하는 메소드
    // 검색 결과(문자열) -> JSON -> DTO -> DTO List
    public List<ItemDto> fromJSONtoItems(String result) {
        // 문자열 -> JSON
        JSONObject rjson = new JSONObject(result);
        // JSON에서 items 배열을 꺼낸다
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();  // 검색 결과를 담을 리스트
        // 꺼내온 items배열을 순회하며 값을 꺼냄
        for(int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            // items배열의 저장된 각 요소에서 필요한 데이터들을 꺼내서 dto에 담음
            ItemDto itemDto = new ItemDto(itemJson);
            // 리스트에 담음
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }
}

//관심상품 등록; POST /api/products Product
//관심상품 조회; GET /api/products  List<Product>
//관심상품 삭제; DELETE /api/products/{id}  Long
//괌싱상품 수정; PUT /api/products/{id}  Long
//검색 GET /api/search?query=  List<ItemDto>