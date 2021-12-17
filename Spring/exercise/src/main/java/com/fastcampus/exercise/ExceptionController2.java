package com.fastcampus.exercise;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


// ����� ���� ����
@ResponseStatus(HttpStatus.BAD_REQUEST)	// 500 -> 400
class MyException extends RuntimeException{
	MyException(String msg) { super(msg); } 
	MyException() { super(""); }
}


@Controller
public class ExceptionController2 {

	@RequestMapping("/ex3")
	public String main() throws Exception {		
		throw new MyException("���� �߻�");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws NullPointerException {
		throw new NullPointerException("���� �߻�");
	}
}
