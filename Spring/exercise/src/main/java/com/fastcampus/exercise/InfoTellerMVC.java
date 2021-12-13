package com.fastcampus.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoTellerMVC {
	
	// �Է� ����ȭ �ϱ�
	@RequestMapping("/getInfoMVC")
	public String main(String name, Model model) throws IOException {

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
