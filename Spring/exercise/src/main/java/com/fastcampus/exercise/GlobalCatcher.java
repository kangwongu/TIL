package com.fastcampus.exercise;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// �� Ŭ������ ����ó�� �޼ҵ���� ��� ��Ʈ�ѷ����� �߻��Ǵ� ���ܸ� ó�� �� ( ����ó�� Ŭ����? ) 
@ControllerAdvice("com.fastcampus.exercise")	// ������ ��Ű������ �߻��� ���ܸ� ó��
//@ControllerAdvice								// ��� ��Ű���� ����
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);	// ���ܵ��� ��� ����
		return "error";
	}
}
