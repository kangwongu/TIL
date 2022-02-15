package com.shop.myshop.utils;

import com.shop.myshop.dto.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Mockito 프레임워크 사용
class NaverShopSearchTest {

    private String query;

    // 샘플) 네이버 상품 검색 API 결과
    private String expectedSearchResult;
    // 샘플) 네이버 상품 검색 API 결과 -> ItemDto 변환 결과
    private List<ItemDto> expectedItemDtoList = new ArrayList<>();

    @Mock
    RestTemplate restTemplate;

    @InjectMocks    //  Mock 객체가 주입된 클래스를 사용하게 될 클래스를 의미
    NaverShopSearch naverShopSearch;

    @BeforeEach
    void setUp() {
        query = "아이맥";
        expectedSearchResult = "{\n" +
                "\"lastBuildDate\": \"Sun, 13 Feb 2022 15:23:21 +0900\",\n" +
                "\"total\": 60829,\n" +
                "\"start\": 1,\n" +
                "\"display\": 3,\n" +
                "\"items\": [\n" +
                "{\n" +
                "\"title\": \"Apple <b>아이맥</b> 27형 2020년형 (MXWT2KH/A)\",\n" +
                "\"link\": \"https://search.shopping.naver.com/gate.nhn?id=23996167522\",\n" +
                "\"image\": \"https://shopping-phinf.pstatic.net/main_2399616/23996167522.20200922132620.jpg\",\n" +
                "\"lprice\": \"2340600\",\n" +
                "\"hprice\": \"\",\n" +
                "\"mallName\": \"네이버\",\n" +
                "\"productId\": \"23996167522\",\n" +
                "\"productType\": \"1\",\n" +
                "\"brand\": \"Apple\",\n" +
                "\"maker\": \"Apple\",\n" +
                "\"category1\": \"디지털/가전\",\n" +
                "\"category2\": \"PC\",\n" +
                "\"category3\": \"브랜드PC\",\n" +
                "\"category4\": \"\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Apple <b>아이맥</b> 24형 2021년형 M1 8코어 CPU 및 7코어 GPU 256GB 실버 (MGTF3KH/A)\",\n" +
                "\"link\": \"https://search.shopping.naver.com/gate.nhn?id=27104851525\",\n" +
                "\"image\": \"https://shopping-phinf.pstatic.net/main_2710485/27104851525.20210513151710.jpg\",\n" +
                "\"lprice\": \"1547880\",\n" +
                "\"hprice\": \"\",\n" +
                "\"mallName\": \"네이버\",\n" +
                "\"productId\": \"27104851525\",\n" +
                "\"productType\": \"1\",\n" +
                "\"brand\": \"Apple\",\n" +
                "\"maker\": \"Apple\",\n" +
                "\"category1\": \"디지털/가전\",\n" +
                "\"category2\": \"PC\",\n" +
                "\"category3\": \"브랜드PC\",\n" +
                "\"category4\": \"\"\n" +
                "\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Apple <b>아이맥</b> 27형 2020년형 (MXWV2KH/A)\",\n" +
                "\"link\": \"https://search.shopping.naver.com/gate.nhn?id=23996143522\",\n" +
                "\"image\": \"https://shopping-phinf.pstatic.net/main_2399614/23996143522.20201127152800.jpg\",\n" +
                "\"lprice\": \"2932000\",\n" +
                "\"hprice\": \"\",\n" +
                "\"mallName\": \"네이버\",\n" +
                "\"productId\": \"23996143522\",\n" +
                "\"productType\": \"1\",\n" +
                "\"brand\": \"Apple\",\n" +
                "\"maker\": \"Apple\",\n" +
                "\"category1\": \"디지털/가전\",\n" +
                "\"category2\": \"PC\",\n" +
                "\"category3\": \"브랜드PC\",\n" +
                "\"category4\": \"\"\n" +
                "\n" +
                "}\n" +
                "]\n" +
                "}\n";

        ItemDto item1 = new ItemDto(
                "Apple <b>아이맥</b> 27형 2020년형 (MXWT2KH/A)",
                "https://search.shopping.naver.com/gate.nhn?id=23996167522",
                "https://shopping-phinf.pstatic.net/main_2399616/23996167522.20200922132620.jpg",
                2340600
        );

        ItemDto item2 = new ItemDto(
                "Apple <b>아이맥</b> 24형 2021년형 M1 8코어 CPU 및 7코어 GPU 256GB 실버 (MGTF3KH/A)",
                "https://search.shopping.naver.com/gate.nhn?id=27104851525",
                "https://shopping-phinf.pstatic.net/main_2710485/27104851525.20210513151710.jpg",
                1547880
        );

        ItemDto item3 = new ItemDto(
                "Apple <b>아이맥</b> 27형 2020년형 (MXWV2KH/A)",
                "https://search.shopping.naver.com/gate.nhn?id=23996143522",
                "https://shopping-phinf.pstatic.net/main_2399614/23996143522.20201127152800.jpg",
                2932000
        );
        expectedItemDtoList.add(item1);
        expectedItemDtoList.add(item2);
        expectedItemDtoList.add(item3);
    }

    // naver API 를 호출하는 부분은 단위테스트로 진행하기 어렵기 때문에
    // rest.exchange(..) 부분을 mock 해서 테스트 코드 작성해 보시면 될꺼 같습니다.
    @Test
    @DisplayName("네이버 검색 API로 검색하기")
    void search() {

       // given
        String url = "https://openapi.naver.com/v1/search/shop.json?query=" + query;
        ResponseEntity responseEntity = new ResponseEntity<>(expectedSearchResult, HttpStatus.OK);

        // 네이버 검색을 하면 샘플 데이터가 나오도록
        when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                any(),
                ArgumentMatchers.<Class<String>>any()
        ))
                .thenReturn(responseEntity);

        // when
        String actualSearchResult = naverShopSearch.search(query);

        // then
        // 샘플 데이터와 네이버 검색결과 비교
        assertEquals(expectedSearchResult, actualSearchResult);
    }

    // input (String result) 으로 사용할 샘플 데이터가 필요하실테니,
    // naver api 를 호출하여 샘플데이터를 얻으시고, 그 샘플데이터를 기준으로
    // 단위테스트를 작성해 보세요.
    @Test
    @DisplayName("검색결과를 item으로 만들기")
    void JSONtoItems() {

        // when
        List<ItemDto> resultList = naverShopSearch.fromJSONtoItems(expectedSearchResult);

        // then
        assertEquals(3, resultList.size());
        assertItemDtoEquals(expectedItemDtoList.get(0), resultList.get(0));
        assertItemDtoEquals(expectedItemDtoList.get(1), resultList.get(1));
        assertItemDtoEquals(expectedItemDtoList.get(2), resultList.get(2));

    }

    private void assertItemDtoEquals(ItemDto expected, ItemDto actual) {
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getLink(), actual.getLink());
        assertEquals(expected.getImage(), actual.getImage());
        assertEquals(expected.getLprice(), actual.getLprice());
    }
}