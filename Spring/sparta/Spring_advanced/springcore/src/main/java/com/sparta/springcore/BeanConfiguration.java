//package com.sparta.springcore;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//// JPA가 대신 처리
//@Configuration  // 스프링이 동작할 때 이 부분을 읽음
//public class BeanConfiguration {
//
//    @Bean   // Bean등록, return값을 Bean등록함
//    public ProductRepository productRepository() {
//        String dbUrl = "jdbc:h2:mem:springcoredb";
//        String dbId = "sa";
//        String dbPassword = "";
//
//        return new ProductRepository(dbUrl, dbId, dbPassword);
//    }
//}