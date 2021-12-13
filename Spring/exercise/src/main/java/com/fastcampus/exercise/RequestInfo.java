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
	
	// ���������� URL�� ��û�� �ϸ�, ��Ĺ�� �޾Ƽ� HttpServletRequest��ü�� ����� �ű⿡ �����͵��� ���� ��,
	// main�޼ҵ忡 ����
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// ��Ĺ�� ���� ��û����
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		out.print("<p>");
		out.print("request.getCharacterEncoding()="+request.getCharacterEncoding()); // ��û ������ ���ڵ�
        out.print("request.getContentLength()="+request.getContentLength());  // ��û ������ ����. �˼� ���� ���� -1
        out.print("request.getContentType()="+request.getContentType()); // ��û ������ Ÿ��. �� �� ���� ���� null
        
        out.print("request.getMethod()="+request.getMethod());      // ��û ���
        out.print("request.getProtocol()="+request.getProtocol());  // ���������� ������ ���� HTTP/1.1
        out.print("request.getScheme()="+request.getScheme());      // ��������

        out.print("request.getServerName()="+request.getServerName()); // ���� �̸� �Ǵ� ip�ּ�
        out.print("request.getServerPort()="+request.getServerPort()); // ���� ��Ʈ
        out.print("request.getRequestURL()="+request.getRequestURL()); // ��û URL
        out.print("request.getRequestURI()="+request.getRequestURI()); // ��û URI

        out.print("request.getContextPath()="+request.getContextPath()); // context path
        out.print("request.getServletPath()="+request.getServletPath()); // servlet path
        out.print("request.getQueryString()="+request.getQueryString()); // ���� ��Ʈ��

        out.print("request.getLocalName()="+request.getLocalName()); // ���� �̸�
        out.print("request.getLocalPort()="+request.getLocalPort()); // ���� ��Ʈ

        out.print("request.getRemoteAddr()="+request.getRemoteAddr()); // ���� ip�ּ�
        out.print("request.getRemoteHost()="+request.getRemoteHost()); // ���� ȣ��Ʈ �Ǵ� ip�ּ�
        out.print("request.getRemotePort()="+request.getRemotePort()); // ���� ��Ʈ
        out.print("</p>");
	}
}
