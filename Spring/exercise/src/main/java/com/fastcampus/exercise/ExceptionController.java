package com.fastcampus.exercise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	// 이 컨트롤러에서 발생하는 예외를 처리하는 메소드
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex) {
		return "error";
	}

	@RequestMapping("/ex")
	public String main() throws Exception {		
		throw new Exception("예외 발생");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws NullPointerException {
		throw new NullPointerException("예외 발생");
	}
}
