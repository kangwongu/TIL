package com.fastcampus.exercise;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	// GET, POST �� �� ����ϰ� �� ���� ����
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm";	// registerForm.jsp�� ���
	}
	
	// GET������� ȸ������ �Ұ�
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping(value="/register/save")	// ���� ����
	public String save(User user, Model m) throws Exception {
		// 1. ��ȿ�� �˻�
		if(!isValid(user)) {
			// ��Ʈ�ѷ����� ���� URL�� �����, ���� URL���ڵ��� ����� ��
			// ��(registerForm.jsp)���� ���ڵ��� ����� �Ѵ�
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			// Model�� ��Ƽ� ��¿� ����
			m.addAttribute("msg", msg);
			return "redirect:/register/add";	// URL���ۼ�(rewrite), GET������� ����
//			return "redirect:/register/add?msg="+msg;	// URL���ۼ�(rewrite), GET������� ����
		}
		
		// 2. DB�� �ű�ȸ�� ���� ����
		
		return "registerInfo";	// registerInfo.jsp�� ���
	}

	private boolean isValid(User user) {
		return true;
	}
}
