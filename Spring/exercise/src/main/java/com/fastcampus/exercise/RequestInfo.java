package com.fastcampus.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestInfo {
	@RequestMapping("/requestInfo")
	
	// 브라우저에서 URL로 요청을 하면, 톰캣이 받아서 HttpServletRequest객체를 만들고 거기에 데이터들을 담은 후,
	// main메소드에 전달
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 톰캣이 받은 요청정보
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		out.print("<p>");
		out.print("request.getCharacterEncoding()="+request.getCharacterEncoding()); // 요청 내용의 인코딩
        out.print("request.getContentLength()="+request.getContentLength());  // 요청 내용의 길이. 알수 없을 때는 -1
        out.print("request.getContentType()="+request.getContentType()); // 요청 내용의 타입. 알 수 없을 때는 null
        
        out.print("request.getMethod()="+request.getMethod());      // 요청 방법
        out.print("request.getProtocol()="+request.getProtocol());  // 프로토콜의 종류와 버젼 HTTP/1.1
        out.print("request.getScheme()="+request.getScheme());      // 프로토콜

        out.print("request.getServerName()="+request.getServerName()); // 서버 이름 또는 ip주소
        out.print("request.getServerPort()="+request.getServerPort()); // 서버 포트
        out.print("request.getRequestURL()="+request.getRequestURL()); // 요청 URL
        out.print("request.getRequestURI()="+request.getRequestURI()); // 요청 URI

        out.print("request.getContextPath()="+request.getContextPath()); // context path
        out.print("request.getServletPath()="+request.getServletPath()); // servlet path
        out.print("request.getQueryString()="+request.getQueryString()); // 쿼리 스트링

        out.print("request.getLocalName()="+request.getLocalName()); // 로컬 이름
        out.print("request.getLocalPort()="+request.getLocalPort()); // 로컬 포트

        out.print("request.getRemoteAddr()="+request.getRemoteAddr()); // 원격 ip주소
        out.print("request.getRemoteHost()="+request.getRemoteHost()); // 원격 호스트 또는 ip주소
        out.print("request.getRemotePort()="+request.getRemotePort()); // 원격 포트
        out.print("</p>");
	}
}
