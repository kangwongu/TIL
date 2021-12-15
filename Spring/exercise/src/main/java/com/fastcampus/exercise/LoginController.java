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
		// rememberId가 어떤 값으로 넘어오는지 확인
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		
		// 1. id, pwd를 확인
		if(!loginCheck(id, pwd)) {
			// 1-1. 로그인 실패하면 다시 로그인 화면으로
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		// 2. 로그인 성공하면 홈으로 이동
		//	  1. 쿠키 생성
		//	  2. 응답에 저장
		//	  3. 홈으로 이동
		if(rememberId) {
			// 아이디 기억을 체크했다면
			// 1. 쿠키 생성
			Cookie cookie = new Cookie("id", id);
			// 2. 응답에 저장
			response.addCookie(cookie);
		} else {
			// 아이디 기억을 체크하지 않았다면
			// 1. 쿠키 생성, 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			// 2. 응답에 저장
			response.addCookie(cookie);
		}
		
		// 3. 홈으로 이동
		return "redirect:/";	// redirect하기 때문에 GETMAPPING에서 받음
	}

	private boolean loginCheck(String id, String pwd) {
		return "MO11".equals(id) && "arsenal".equals(pwd);
	}
}
