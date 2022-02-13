package com.shop.myshop.utils;

import com.shop.myshop.dto.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Mockito 프레임워크 사용
class NaverShopSearchTest {

    private String query;

    private RestTemplate rest;
    private HttpHeaders headers;
    private String body;
    private HttpEntity<String> requestEntity;
    private ResponseEntity<String> responseEntity;
    private HttpStatus httpStatus;

    private JSONObject rjson;
    private JSONArray items;
    private JSONObject itemJson;
    private List<ItemDto> itemDtoList;

    @Mock
    NaverShopSearch naverShopSearch;

    @BeforeEach
    void setUp() {
        rest = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id","KYLAUEXJ4BCUErigMPMS");
        headers.add("X-Naver-Client-Secret","rJATsm5fGM");
        body = "";
        requestEntity = new HttpEntity<String>(body, headers);


    }

    // naver API 를 호출하는 부분은 단위테스트로 진행하기 어렵기 때문에
    // rest.exchange(..) 부분을 mock 해서 테스트 코드 작성해 보시면 될꺼 같습니다.
    @Test
    @DisplayName("네이버 검색 API로 검색하기")
    void search() {
        // 1. query로 네이버 검색 api로 검색
        // 검색부분을 샘플데이터로 미리 설정
        // search()를 하면 샘플데이터가 나오도록 설정
        // 검증

       // given
        query = "아이맥";

        responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class); // 샘플 데이터
        httpStatus = responseEntity.getStatusCode();
        String response = responseEntity.getBody();

        // 네이버 검색을 하면 샘플 데이터가 나오도록
        when(naverShopSearch.search(query))
                .thenReturn(response);

        // when
        String result = naverShopSearch.search("아이맥");

        // then
        // 샘플 데이터와 네이버 검색결과 비교
        assertEquals(response, result);
    }

    // input (String result) 으로 사용할 샘플 데이터가 필요하실테니,
    // naver api 를 호출하여 샘플데이터를 얻으시고, 그 샘플데이터를 기준으로
    // 단위테스트를 작성해 보세요.
    @Test
    @DisplayName("검색결과를 item으로 만들기")
    void JSONtoItems() {
        // 1. 검색결과를 받아온다.
        // 2. 받아온 검색결과를 JSON -> ItemDto -> ItemDtoList

        // given
        query = "아이맥";

        // 1.
        responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class); // 샘플 데이터
        httpStatus = responseEntity.getStatusCode();
        String response = responseEntity.getBody();

        // 2.
        rjson = new JSONObject(response);
        items = rjson.getJSONArray("items");
        itemDtoList = new ArrayList<>();
        for(int i=0; i<items.length(); i++) {
            itemJson = (JSONObject) items.get(i);
            ItemDto itemDto = new ItemDto(itemJson);

            itemDtoList.add(itemDto);
        }

        // 사용케이스 추가 ( 검색결과를 바탕으로 fromJSONtoItems()를 수행하면, itemDtoList반환
        when(naverShopSearch.fromJSONtoItems(response))
                .thenReturn(itemDtoList);

        // when
        List<ItemDto> resultList = naverShopSearch.fromJSONtoItems(response);

        // then
        assertEquals(itemDtoList, resultList);

    }
}