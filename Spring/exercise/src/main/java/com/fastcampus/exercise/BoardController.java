package com.fastcampus.exercise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/list")		// boardList.jsp를 출력하는 메소드
	public String list(HttpServletRequest request) {	// 세션값 얻기 위해 매개변수로 넣어줌
		// 1. 로그인이 되어있는지 체크
		if(!loginCheck(request)) {
			// 안되어있다면 로그인창으로 redirect
			// 현재의 주소를 redirect에 포함시켜서 보냄
			HttpSession session = request.getSession();
			session.setAttribute("toURL", request.getRequestURL());
			return "redirect:/login/login";
			
		}
		// 되어있다면 boardList로 이동
		return "boardList";
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 세션의 id를 체크해 값이 있으면 true, 없으면 false
		// 1. 세션에서 id값 가져오기
		HttpSession session = request.getSession();
		// 세션의 id가 없으면 거짓, 있으면 참
		if(session.getAttribute("id")==null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	
}
