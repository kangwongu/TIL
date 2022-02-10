package com.shop.myshop.model;

import com.shop.myshop.dto.ProductRequestDto;
import com.shop.myshop.utils.Timestamped;
import com.shop.myshop.validation.ProductValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Entity
@Getter
@NoArgsConstructor
// 관심상품
public class Product extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int lprice;     // 최저가

    @Column(nullable = false)
    private int myprice;    // 희망가격

    public Product(ProductRequestDto productRequestDto) {
        // Edge 케이스 처리
        ProductValidator.validateProduct(productRequestDto);

        this.title = productRequestDto.getTitle();
        this.link = productRequestDto.getLink();
        this.image = productRequestDto.getImage();
        this.lprice = productRequestDto.getLprice();
        this.myprice = 0;   // 우선 희망가격을 0으로 세팅
    }


}
