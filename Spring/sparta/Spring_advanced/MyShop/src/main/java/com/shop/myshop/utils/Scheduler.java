package com.shop.myshop.utils;

import com.shop.myshop.dto.ItemDto;
import com.shop.myshop.model.Product;
import com.shop.myshop.repository.ProductRepository;
import com.shop.myshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final NaverShopSearch naverShopSearch;

    // 초, 분, 시, 일, 월, 주
    @Scheduled(cron = "0 0 1 * * *")    // 매일 새벽 1시에 업데이트
    public void updatePrice() throws InterruptedException {
        System.out.println("가격 업데이트 실행");

        // 저장된 모든 관심 상품 조회
        List<Product> productList = productRepository.findAll();
        for(int i=0; i<productList.size(); i++) {
            TimeUnit.SECONDS.sleep(1);  // 1초마다 조회
            // i번째 관심 상품을 꺼냄
            Product p = productList.get(i);
            // i번째 관심 상품의 제목으로 검색 실행
            String title = p.getTitle();
            String resultString = naverShopSearch.search(title);
            // i번째 관심 상품의 검색 결과 목록에서 첫 번째 결과를 꺼낸다
            List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(resultString);
            ItemDto itemDto = itemDtoList.get(0);
            // i번째 관심 상품 정보를 업데이트
            Long id = p.getId();
            productService.updateBySearch(id, itemDto);
        }

    }
}
