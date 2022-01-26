package com.sparta.week03review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week03reviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week03reviewApplication.class, args);
    }

}
