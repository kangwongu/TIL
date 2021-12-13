package com.fastcampus.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

	@RequestMapping("/hello")
	public void main(HttpServletResponse response) throws IOException {
		System.out.println("Hello");
		
		
		// 출력 위해 준비해야 할 것들
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("Hello");
	}
	
}
