package com.fastcampus.exercise;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC2 {
	// ����ó�� �޼ҵ�, ��Ʈ�ѷ����� �߻��Ǵ� ��� ���ܸ� ó��
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
	// 1. �Է�
	// �Է��� �и�, �Ű������� �־������ν� �Է������� ����ȭ ���� 
	public String main(@RequestParam(required=true) int year,
				@RequestParam(required=true) int month,
				@RequestParam(required=true) int day, Model model) throws IOException {
	
		// ��ȿ�� �˻�
		if(!isValid(year, month, day)) 
			return "yoilError";
		
		// 2. �۾� ó��
		char yoil = getYoil(year, month, day);
		
		// �۾� ó�� ����� Model�� �����ϰ� �� ����� ����� View�� ����(yoil.jsp)
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		
		// 3. ���
		// ��µ� �и��� ����!
		// Model ��ü�� �����͸� �����ϰ� ��ºκп��� ���
		// ����� �ش� ���ڿ��� jsp������ �����ִ� ������ �и�
		return "yoil";
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(year, month-1, day);						// ��¥ ����
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// ��¥�� �ش��ϴ� ���� ��ȣ
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);	// ���Ϲ�ȣ�� �ش��ϴ� ���� ȹ��
		return yoil;
	}
}
