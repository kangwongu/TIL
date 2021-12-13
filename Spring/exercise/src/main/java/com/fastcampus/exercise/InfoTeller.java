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
		String str = "�߸��� ��û�Դϴ�.";
		return str;
	}
	
	@RequestMapping("/getInfo")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. �Է�
		String name = request.getParameter("name");
						
		// 2. �۾� ó��
		// 1.���� �Է¹��� name�� ���� team�� �����ؼ� �������
		String team="";
		if(name.equals("������")) {
			team = "Manchester United";
		} else if(name.equals("�����")) {
			team = "Tottenham Hotsper";
		} else {
			team = "����";
		}
		
		
		
		// 3. ���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>�̸��� "+name+", �Ҽ����� "+team+"�Դϴ�.</h1>");
		out.print("</body>");
		out.print("</html>");
		
		
	}
}
