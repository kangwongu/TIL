package com.shop.myshop.model;

import com.shop.myshop.dto.ProductRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProductTest {

    @Nested
    @DisplayName("관심상품 생성")
    class CreateProduct {

        private String title;
        private String link;
        private String image;
        private int lprice;

        // 테스트전에 수행함 (초기화)
        @BeforeEach
        void setup() {
            title = "Apple <b>아이맥</b> 27형 2020년형 (MXWU2KH/A)";
            link = "https://search.shopping.naver.com/gate.nhn?id=23995303524";
            image = "https://shopping-phinf.pstatic.net/main_2399530/23995303524.20201013141558.jpg";
            lprice = 2559790;
        }

        @Test
        @DisplayName("정상 케이스")
        void createProduct_Normal() {
            // given, 샘플값
            ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

            // when, 테스트할 부분
            Product product = new Product(requestDto);

            // then, 확인
            assertNull(product.getId());
            assertEquals(title, product.getTitle());
            assertEquals(link, product.getLink());
            assertEquals(image, product.getImage());
            assertEquals(lprice, product.getLprice());
            assertEquals(0, product.getMyprice());
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCases {
            @Nested
            @DisplayName("상품명")
            class Title {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    title = null;

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                                new Product(requestDto);
                            });

                    // then
                    assertEquals("유효하지 않은 상품명입니다.", exception.getMessage());

                }
                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    title = "";

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto);
                    });

                    // then
                    assertEquals("유효하지 않은 상품명입니다.", exception.getMessage());

                }
            }

            @Nested
            @DisplayName("상품 이미지")
            class Image {
                @Test
                @DisplayName("null")
                void fail3() {
                    // given
                    image = null;

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto);
                    });

                    // then
                    assertEquals("유효하지 않은 이미지 URL 입니다.", exception.getMessage());

                }
                @Test
                @DisplayName("URL이 아님")
                void fail4() {
                    // given
                    image = "naver.com";

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto);
                    });

                    // then
                    assertEquals("유효하지 않은 이미지 URL 입니다.", exception.getMessage());

                }
            }

            @Nested
            @DisplayName("상품 최저가 페이지")
            class Link {
                @Test
                @DisplayName("null")
                void fail5() {
                    // given
                    link = null;

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto);
                    });

                    // then
                    assertEquals("유효하지 않은 상품 최저가 URL 입니다.", exception.getMessage());

                }
                @Test
                @DisplayName("URL이 아님")
                void fail6() {
                    // given
                    link = "SIBAL.COM";

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto);
                    });

                    // then
                    assertEquals("유효하지 않은 상품 최저가 URL 입니다.", exception.getMessage());

                }

            }

            @Nested
            @DisplayName("상품 최저가")
            class Lprice {
                @Test
                @DisplayName("0")
                void fail7() {
                    // given
                    lprice = 0;

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto);
                    });

                    // then
                    assertEquals("상품 최저가가 0 이하입니다.", exception.getMessage());

                }
                @Test
                @DisplayName("음수")
                void fail8() {
                    // given
                    lprice = -5000;

                    ProductRequestDto requestDto = new ProductRequestDto(title, link, image, lprice);

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto);
                    });

                    // then
                    assertEquals("상품 최저가가 0 이하입니다.", exception.getMessage());

                }
            }
        }
    }
}