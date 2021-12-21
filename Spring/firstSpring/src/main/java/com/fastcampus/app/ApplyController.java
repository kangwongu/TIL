package com.fastcampus.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplyController {

	@GetMapping("/apply")
	public String apply() {
		return "apply";
	}
	
	@PostMapping("/apply")
	public String applyForm(HttpServletRequest request, Model m) {
		
		// ·Î±×Âï±â
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String phoneNumber = request.getParameter("phoneNumber");
		String check = request.getParameter("check");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(phoneNumber);
		System.out.println(check);
		
		m.addAttribute("name", name);
		m.addAttribute("id", id);
		m.addAttribute("phoneNumber", phoneNumber);
		m.addAttribute("check", check);
		
		return "result";
	}
}
