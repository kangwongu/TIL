package com.fastcampus.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC {
	@ExceptionHandler(Exception.class)
	public String catcher() {
		String str = "잘못된 요청입니다.";
		return str;
	}
	
	@RequestMapping("/getYoilMVC")
	// 1. 입력
	// 입력을 분리, 매개변수로 넣어줌으로써 입력행위를 간소화 가능 
	public String main(int year, int month, int day, Model model) throws IOException {
	
		// 유효성 검사
		if(!isValid(year, month, day)) 
			return "yoilError";
		
		// 2. 작업 처리
		char yoil = getYoil(year, month, day);
		
		// 작업 처리 결과를 Model에 저장하고 이 저장된 결과를 View로 전달(yoil.jsp)
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		
		// 3. 출력
		// 출력도 분리가 가능!
		// Model 객체에 데이터를 저장하고 출력부분에서 사용
		// 출력을 해당 문자열의 jsp파일을 보여주는 것으로 분리
		return "yoil";
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(year, month-1, day);						// 날짜 지정
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// 날짜에 해당하는 요일 번호
		char yoil = " 일월화수목금토".charAt(dayOfWeek);	// 요일번호에 해당하는 요일 획득
		return yoil;
	}
}
