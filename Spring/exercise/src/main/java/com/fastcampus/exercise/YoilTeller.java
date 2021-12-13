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
public class YoilTeller {
	@ExceptionHandler(Exception.class)
	public String catcher() {
		String str = "�߸��� ��û�Դϴ�.";
		return str;
	}
	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. �Է�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. �۾� ó��
		Calendar cal = Calendar.getInstance();
		
		cal.set(yyyy, mm-1, dd);						// ��¥ ����
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// ��¥�� �ش��ϴ� ���� ��ȣ
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);	// ���Ϲ�ȣ�� �ش��ϴ� ���� ȹ��
		
		
		// 3. ���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>"+year+"�� "+month+"�� "+day+"���� "+yoil+"���� �Դϴ�!"+"</h1>");
		out.print("</body>");
		out.print("</html>");
		
		
	}
}
