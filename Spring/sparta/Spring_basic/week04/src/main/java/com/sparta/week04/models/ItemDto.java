package com.sparta.week04.models;

import lombok.Getter;
import org.json.JSONObject;

// 검색 결과를 사용자에게 반환할 때 쓰는 Dto
@Getter
public class ItemDto {
    private String title;
    private String link;
    private String image;
    private int lprice;

    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}
