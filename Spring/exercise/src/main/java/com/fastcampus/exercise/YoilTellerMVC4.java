package com.fastcampus.exercise;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC4 {
	// ����ó�� �޼ҵ�, ��Ʈ�ѷ����� �߻��Ǵ� ��� ���ܸ� ó��
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC4")
	// 1. �Է�
	// �Է��� �и�, �Ű������� �־������ν� �Է������� ����ȭ ���� 
	// �Ű������� �ʹ� ���� ����, ���ο� Ŭ������ �����ؼ� �Ű����� ���� ���� �� ����
	public String main(MyDate date, Model model) throws IOException {
	
		// ��ȿ�� �˻�
		if(!isValid(date)) 
			return "yoilError";
		
		// 2. �۾� ó��
		char yoil = getYoil(date);
		
		// �۾� ó�� ����� Model�� �����ϰ� �� ����� ����� View�� ����(yoil.jsp)
		model.addAttribute("myDate", date);

		model.addAttribute("yoil", yoil);
		
		
		// 3. ���
		// ��µ� �и��� ����!
		// Model ��ü�� �����͸� �����ϰ� ��ºκп��� ���
		// ����� �ش� ���ڿ��� jsp������ �����ִ� ������ �и�
		return "yoil2";
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
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
