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
		// 세션 삭제
		HttpSession session = request.getSession();
		session.invalidate();
		// 홈으로 이동
		return "redirect:/";
		
	}
	
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1. id, pwd를 확인
		if(!loginCheck(id, pwd)) {
			// 1-1. 로그인 실패하면 다시 로그인 화면으로
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		// 2. 로그인 성공하면 홈으로 이동
		// 세션에 id 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
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
		// 세션에 toURL주소가 있으면 해당 주소로 이동
		Object toURL = session.getAttribute("toURL");
		toURL = session.getAttribute("toURL")==null || session.getAttribute("toURL").equals("") ? "/" : toURL;
//		if(session.getAttribute("toURL")==null || session.getAttribute("toURL").equals(""))
//			return "redirect:/";
//		else
//			return "redirect:"+session.getAttribute("toURL");
		
		// 3. 홈으로 이동
		return "redirect:"+toURL;	// redirect하기 때문에 GETMAPPING에서 받음
	}

	private boolean loginCheck(String id, String pwd) {
		return "MO11".equals(id) && "arsenal".equals(pwd);
	}
}
