package com.shop.myshop.dto;

import lombok.Getter;
import org.json.JSONObject;

// 검색 결과를 담을 Dto
@Getter
public class ItemDto {
    private String title;
    private String image;
    private String link;
    private int lprice;

    // 검색 결과 JSON에서 title, image, link, lprice값만 추출해 저장
    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.image = itemJson.getString("image");
        this.link = itemJson.getString("link");
        this.lprice = itemJson.getInt("lprice");
    }
}
