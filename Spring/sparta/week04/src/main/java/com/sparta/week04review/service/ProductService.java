package com.sparta.week04review.service;

import com.sparta.week04review.models.ItemDto;
import com.sparta.week04review.models.Product;
import com.sparta.week04review.models.ProductMypriceRequestDto;
import com.sparta.week04review.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service // 서비스임을 선언합니다.
public class ProductService {

    private final ProductRepository productRepository;

    // update 메소드
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
// 사용자가 설정한 최저가 가격 업데이트 (업데이트할 데이터의 id, 업데이트할 정보 (가격))
    public Long update(Long id, ProductMypriceRequestDto requestDto) {
        // 1. 업데이트할 데이터를 DB에서 찾는다.
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        // 2. DB에서 찾은 데이터를 업데이트한다. (최저가 가격 설정)
        product.update(requestDto);
        return id;
    }

    // 매일 새벽 1시에 상품 가격을 업데이트
    @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        product.updateByItemDto(itemDto);
        return id;
    }
}
