package com.sparta.springcore.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

// 에러메시지를 json으로 내려보내기 위해 정의
@Getter
@Setter
public class RestApiException {
    private String errorMessage;
    private HttpStatus httpStatus;
}
