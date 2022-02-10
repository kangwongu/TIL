package com.shop.myshop.service;

import com.shop.myshop.dto.ProductRequestDto;
import com.shop.myshop.model.Product;
import com.shop.myshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Proc;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // 관심상품 등록
    public Product createProduct(ProductRequestDto productRequestDto) {
        // 1. dto값으로 Product객체 생성
        Product product = new Product(productRequestDto);

        // 2. 생성한 객체를 DB에 저장
        return productRepository.save(product);
    }
}