package com.fastcampus.exercise;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoTellerMVC4 {
	// 예외 처리 메소드, 컨트롤러에서 발생하는 모든 예외를 처리
		@ExceptionHandler
		public String catcher(Exception e) {
			e.printStackTrace();
			return "infoError";
		}
		
	// 입력 간소화 하기
	@RequestMapping("/getInfoMVC4")
	public String main(@RequestParam(required=true) String name, Model model) throws IOException {

		// 유효성 검사
		if(!isValid(name)) {
			return "infoError";
		}
		
		// 2. 작업 처리
		// 1.에서 입력받은 name에 따라 team을 지정해서 출력해줌
		String team = getTeam(name);
		
		if(team.equals("error")) {
			return "infoErrorTeam";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("team", team);
		
		
		// 3. 출력  
		return "info";
		
	}

	private boolean isValid(String name) {
		return true;
	}

	private String getTeam(String name) {
		String team="";
		if(name.equals("박지성")) {
			team = "Manchester United";
		} else if(name.equals("손흥민")) {
			team = "Tottenham Hotsper";
		} else {
			team = "error";
		}
		return team;
	}
}
