package com.fastcampus.exercise;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


// 사용자 정의 예외
@ResponseStatus(HttpStatus.BAD_REQUEST)	// 500 -> 400
class MyException extends RuntimeException{
	MyException(String msg) { super(msg); } 
	MyException() { super(""); }
}


@Controller
public class ExceptionController2 {

	@RequestMapping("/ex3")
	public String main() throws Exception {		
		throw new MyException("예외 발생");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws NullPointerException {
		throw new NullPointerException("예외 발생");
	}
}
