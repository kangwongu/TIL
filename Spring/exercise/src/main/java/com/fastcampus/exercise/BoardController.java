package com.fastcampus.exercise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/list")		// boardList.jsp�� ����ϴ� �޼ҵ�
	public String list(HttpServletRequest request) {	// ���ǰ� ��� ���� �Ű������� �־���
		// 1. �α����� �Ǿ��ִ��� üũ
		if(!loginCheck(request)) {
			// �ȵǾ��ִٸ� �α���â���� redirect
			// ������ �ּҸ� redirect�� ���Խ��Ѽ� ����
			HttpSession session = request.getSession();
			session.setAttribute("toURL", request.getRequestURL());
			return "redirect:/login/login";
			
		}
		// �Ǿ��ִٸ� boardList�� �̵�
		return "boardList";
	}

	private boolean loginCheck(HttpServletRequest request) {
		// ������ id�� üũ�� ���� ������ true, ������ false
		// 1. ���ǿ��� id�� ��������
		HttpSession session = request.getSession();
		// ������ id�� ������ ����, ������ ��
		if(session.getAttribute("id")==null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	
}
