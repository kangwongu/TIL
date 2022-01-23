package com.sparta.week04review.models;

import lombok.Getter;
import org.json.JSONObject;

// 검색 시에 주고받을 데이터들을 담아 놓는 클래스
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
