package com.fastcampus.exercise;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception {
		// rememberId�� � ������ �Ѿ������ Ȯ��
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		
		// 1. id, pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			// 1-1. �α��� �����ϸ� �ٽ� �α��� ȭ������
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		// 2. �α��� �����ϸ� Ȩ���� �̵�
		//	  1. ��Ű ����
		//	  2. ���信 ����
		//	  3. Ȩ���� �̵�
		if(rememberId) {
			// ���̵� ����� üũ�ߴٸ�
			// 1. ��Ű ����
			Cookie cookie = new Cookie("id", id);
			// 2. ���信 ����
			response.addCookie(cookie);
		} else {
			// ���̵� ����� üũ���� �ʾҴٸ�
			// 1. ��Ű ����, ����
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			// 2. ���信 ����
			response.addCookie(cookie);
		}
		
		// 3. Ȩ���� �̵�
		return "redirect:/";	// redirect�ϱ� ������ GETMAPPING���� ����
	}

	private boolean loginCheck(String id, String pwd) {
		return "MO11".equals(id) && "arsenal".equals(pwd);
	}
}
