package com.fastcampus.exercise;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yoil")
public class YoilController {
	
	@GetMapping("/get")
	public String main() {
		return "yoil3";
	}
	
	@GetMapping("/result")
	public String showResult(int year, int month, int day, Model m) {
		
		char yoil = getYoil(year, month, day);
		
		m.addAttribute("year", year);
		m.addAttribute("month", month);
		m.addAttribute("day", day);
		m.addAttribute("yoil", yoil);
		
		return "yoil";
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		
		// 요일 구하기
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		return yoil;
	}

}
