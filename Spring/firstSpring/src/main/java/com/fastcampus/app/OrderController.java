package com.fastcampus.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
	
	@GetMapping("/order")
	public String main() {
		return "order";
	}
	
	@PostMapping("/order")
	public String order(Order order) {
		
		
		return "orderResult";
	}

}
