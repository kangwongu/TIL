package com.fastcampus.exercise;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	// GET, POST 둘 다 허용하게 할 수도 있음
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm";	// registerForm.jsp를 출력
	}
	
	// GET방식으로 회원가입 불가
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping(value="/register/save")	// 위와 동일
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			// 컨트롤러에서 직접 URL을 만들면, 직접 URL인코딩을 해줘야 함
			// 뷰(registerForm.jsp)에서 디코딩도 해줘야 한다
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			// Model에 담아서 출력에 전송
			m.addAttribute("msg", msg);
			return "redirect:/register/add";	// URL재작성(rewrite), GET방식으로 붙임
//			return "redirect:/register/add?msg="+msg;	// URL재작성(rewrite), GET방식으로 붙임
		}
		
		// 2. DB에 신규회원 정보 저장
		
		return "registerInfo";	// registerInfo.jsp를 출력
	}

	private boolean isValid(User user) {
		return true;
	}
}
