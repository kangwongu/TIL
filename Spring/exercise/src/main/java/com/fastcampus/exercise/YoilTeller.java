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
		String str = "잘못된 요청입니다.";
		return str;
	}
	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. 작업 처리
		Calendar cal = Calendar.getInstance();
		
		cal.set(yyyy, mm-1, dd);						// 날짜 지정
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// 날짜에 해당하는 요일 번호
		char yoil = " 일월화수목금토".charAt(dayOfWeek);	// 요일번호에 해당하는 요일 획득
		
		
		// 3. 출력
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>"+year+"년 "+month+"월 "+day+"일은 "+yoil+"요일 입니다!"+"</h1>");
		out.print("</body>");
		out.print("</html>");
		
		
	}
}
