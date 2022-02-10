package com.shop.myshop.controller;

import com.shop.myshop.dto.ItemDto;
import com.shop.myshop.service.SearchRequestService;
import com.shop.myshop.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {

    private final SearchRequestService searchRequestService;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) {
        return searchRequestService.getItems(query);
    }
}