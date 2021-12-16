package com.fastcampus.exercise;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		// ���� ����
		HttpSession session = request.getSession();
		session.invalidate();
		// Ȩ���� �̵�
		return "redirect:/";
		
	}
	
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1. id, pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			// 1-1. �α��� �����ϸ� �ٽ� �α��� ȭ������
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		// 2. �α��� �����ϸ� Ȩ���� �̵�
		// ���ǿ� id ����
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
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
		// ���ǿ� toURL�ּҰ� ������ �ش� �ּҷ� �̵�
		Object toURL = session.getAttribute("toURL");
		toURL = session.getAttribute("toURL")==null || session.getAttribute("toURL").equals("") ? "/" : toURL;
//		if(session.getAttribute("toURL")==null || session.getAttribute("toURL").equals(""))
//			return "redirect:/";
//		else
//			return "redirect:"+session.getAttribute("toURL");
		
		// 3. Ȩ���� �̵�
		return "redirect:"+toURL;	// redirect�ϱ� ������ GETMAPPING���� ����
	}

	private boolean loginCheck(String id, String pwd) {
		return "MO11".equals(id) && "arsenal".equals(pwd);
	}
}
