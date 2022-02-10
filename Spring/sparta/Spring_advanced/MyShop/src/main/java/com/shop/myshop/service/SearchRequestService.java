package com.shop.myshop.service;

import com.shop.myshop.dto.ItemDto;
import com.shop.myshop.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchRequestService {

    private final NaverShopSearch naverShopSearch;

    public List<ItemDto> getItems(String query) {
        String result = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(result);
    }
}
