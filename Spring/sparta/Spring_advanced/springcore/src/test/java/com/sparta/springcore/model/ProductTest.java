package com.sparta.springcore.model;

import com.sparta.springcore.dto.ProductRequestDto;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Nested
    @DisplayName("회원이 요청한 관심상품 객체 생성")
    class CreateUserProduct {

        private Long userId;
        private String title;
        private String image;
        private String link;
        private int lprice;

        @BeforeEach // 테스트 수행하기전에 수행
        void setup() {
            userId = 100L;
            title = "오리온 꼬북칩 초코츄러스맛 160g";
            image = "https://shopping-phinf.pstatic.net/main_2416122/24161228524.20200915151118.jpg";
            link = "https://search.shopping.naver.com/gate.nhn?id=24161228524";
            lprice = 2350;
        }

        @Test   // JUnit으로 테스트하겠다는 것을 의미, 테스트할 함수 위에 @Test 어노테이션 붙임
        @DisplayName("정상 케이스")  // 함수 이름대신 어노테이션 값을 표시
        void createProduct_Normal() {
            // 테스트 코드는 given, when, then으로 구성하는 것이 좋음
            // given, 샘플값
            ProductRequestDto requestDto = new ProductRequestDto(
                    title,
                    image,
                    link,
                    lprice
            );

            // when, 테스트할 부분
            Product product = new Product(requestDto, userId);

            // then, 검증
            assertNull(product.getId());    // 널이어야 한다
            assertEquals(userId, product.getUserId());  // 두 값이 같아야 한다
            assertEquals(title, product.getTitle());
            assertEquals(image, product.getImage());
            assertEquals(link, product.getLink());
            assertEquals(lprice, product.getLprice());
            assertEquals(0, product.getMyprice());

            // assert - 사실임을 강하게 주장하다

        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCases {
            @Nested
            @DisplayName("회원 Id")
            class userId {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given, 샘플값, userId가 null이면
                    userId = null;

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when, 테스트할 부분, 예외가 발생해야함(IllegalArgumentException)
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> { // 예외가 발생해야 한다
                        new Product(requestDto, userId);
                    });

                    // then, 검증, 발생한 예외의 메시지는 '회원 Id 가 유효하지 않습니다.'로 출력되어야 함
                    assertEquals("회원 Id 가 유효하지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("마이너스")
                void fail2() {
                    // given
                    userId = -100L;

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("회원 Id 가 유효하지 않습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("상품명")
            class Title {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    title = null;

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("저장할 수 있는 상품명이 없습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("빈 문자열")
                void fail2() {
                    // given
                    String title = "";

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("저장할 수 있는 상품명이 없습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("상품 이미지 URL")
            class Image {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    image = null;

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("상품 이미지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("URL 포맷 형태가 맞지 않음")
                void fail2() {
                    // given
                    image = "shopping-phinf.pstatic.net/main_2416122/24161228524.20200915151118.jpg";

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("상품 이미지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("상품 최저가 페이지 URL")
            class Link {
                @Test
                @DisplayName("null")
                void fail1() {
                    // given
                    link = "https";

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("상품 최저가 페이지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("URL 포맷 형태가 맞지 않음")
                void fail2() {
                    // given
                    link = "https";

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("상품 최저가 페이지 URL 포맷이 맞지 않습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("상품 최저가")
            class LowPrice {
                @Test
                @DisplayName("0")
                void fail1() {
                    // given
                    lprice = 0;

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("상품 최저가가 0 이하입니다.", exception.getMessage());
                }

                @Test
                @DisplayName("음수")
                void fail2() {
                    // given
                    lprice = -1500;

                    ProductRequestDto requestDto = new ProductRequestDto(
                            title,
                            image,
                            link,
                            lprice
                    );

                    // when
                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new Product(requestDto, userId);
                    });

                    // then
                    assertEquals("상품 최저가가 0 이하입니다.", exception.getMessage());
                }
            }
        }
    }
}