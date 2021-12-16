package com.fastcampus.exercise;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 이 클래스의 예외처리 메소드들이 모든 컨트롤러에서 발생되는 예외를 처리 함 ( 예외처리 클래스? ) 
@ControllerAdvice("com.fastcampus.exercise")	// 지정된 패키지에서 발생한 예외만 처리
//@ControllerAdvice								// 모든 패키지에 적용
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);	// 예외들을 뷰로 전달
		return "error";
	}
}
