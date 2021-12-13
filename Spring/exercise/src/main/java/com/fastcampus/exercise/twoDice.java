package com.fastcampus.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ���� �޴´�
// 2. ���� ���� �´� �׸��� �������� ����Ѵ�

@Controller
public class twoDice {
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		// 1. ���� ���� �޴´�.
		int idx = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		// 2. ���� ���� �´� �׸��� �������� ����Ѵ�
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
