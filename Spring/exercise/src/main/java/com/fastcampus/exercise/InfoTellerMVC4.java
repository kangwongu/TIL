package com.fastcampus.exercise;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoTellerMVC4 {
	// ���� ó�� �޼ҵ�, ��Ʈ�ѷ����� �߻��ϴ� ��� ���ܸ� ó��
		@ExceptionHandler
		public String catcher(Exception e) {
			e.printStackTrace();
			return "infoError";
		}
		
	// �Է� ����ȭ �ϱ�
	@RequestMapping("/getInfoMVC4")
	public String main(@RequestParam(required=true) String name, Model model) throws IOException {

		// ��ȿ�� �˻�
		if(!isValid(name)) {
			return "infoError";
		}
		
		// 2. �۾� ó��
		// 1.���� �Է¹��� name�� ���� team�� �����ؼ� �������
		String team = getTeam(name);
		
		if(team.equals("error")) {
			return "infoErrorTeam";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("team", team);
		
		
		// 3. ���  
		return "info";
		
	}

	private boolean isValid(String name) {
		return true;
	}

	private String getTeam(String name) {
		String team="";
		if(name.equals("������")) {
			team = "Manchester United";
		} else if(name.equals("�����")) {
			team = "Tottenham Hotsper";
		} else {
			team = "error";
		}
		return team;
	}
}
