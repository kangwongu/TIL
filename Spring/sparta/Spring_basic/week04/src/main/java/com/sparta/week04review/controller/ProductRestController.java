package com.sparta.week04review.controller;

import com.sparta.week04review.models.Product;
import com.sparta.week04review.models.ProductMypriceRequestDto;
import com.sparta.week04review.models.ProductRepository;
import com.sparta.week04review.models.ProductRequestDto;
import com.sparta.week04review.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 관심상품 컨트롤러
@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    // 관심상품 조회
    @GetMapping("/api/products")
    public List<Product> readProducts() {
        // 1. DB에서 관심상품 데이터를 모두 가져온다.
        return productRepository.findAll();
    }

    // 관심상품 등록
    @PostMapping("/api/products")
    public Product createProducts(@RequestBody ProductRequestDto requestDto) {
        // 1. 매개변수로 받은 데이터를 DB에 저장하기 위해 Product객체로 만든다.
        Product product = new Product(requestDto);
        // 2. DB에 넣는다.
        return productRepository.save(product);
    }

    // 관심상품의 최저가 가격 설정(변경)
    @PutMapping("/api/products/{id}")
    public Long updateProducts(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }
}
