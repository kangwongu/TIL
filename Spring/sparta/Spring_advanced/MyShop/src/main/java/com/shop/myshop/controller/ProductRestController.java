package com.shop.myshop.controller;

import com.shop.myshop.dto.ProductRequestDto;
import com.shop.myshop.model.Product;
import com.shop.myshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController // JSON 응답
public class ProductRestController {

    private final ProductService productService;

    // 의존성 주입, @RequiredArgsConstructor으로 생략가능
//    @Autowired
//    public ProductRestController(ProductService productService) {
//        this.productService = productService;
//    }

    // 관심 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.createProduct(productRequestDto);
        return product;
    }

    // 관심 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProduct() {
        return productService.getProduct();
    }
}