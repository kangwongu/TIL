package com.fastcampus.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 랜덤 수를 받는다
// 2. 랜덤 수에 맞는 그림을 브라우저에 출력한다

@Controller
public class twoDice {
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		// 1. 랜덤 수를 받는다.
		int idx = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		// 2. 랜덤 수에 맞는 그림을 브라우저에 출력한다
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice"+idx+".jpg'>");
		out.println("<img src='resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
