package com.fastcampus.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoTeller {
	@ExceptionHandler(Exception.class)
	public String catcher() {
		String str = "잘못된 요청입니다.";
		return str;
	}
	
	@RequestMapping("/getInfo")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력
		String name = request.getParameter("name");
						
		// 2. 작업 처리
		// 1.에서 입력받은 name에 따라 team을 지정해서 출력해줌
		String team="";
		if(name.equals("박지성")) {
			team = "Manchester United";
		} else if(name.equals("손흥민")) {
			team = "Tottenham Hotsper";
		} else {
			team = "몰라";
		}
		
		
		
		// 3. 출력
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>이름은 "+name+", 소속팀은 "+team+"입니다.</h1>");
		out.print("</body>");
		out.print("</html>");
		
		
	}
}
