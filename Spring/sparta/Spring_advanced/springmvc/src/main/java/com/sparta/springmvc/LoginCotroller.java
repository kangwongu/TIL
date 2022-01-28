package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCotroller {

    // 로그인 페이지 띄우기, login-form.html 리다이렉트
    @GetMapping("/login")
    public String getPages() {
        return "redirect:/login-form.html"; // 정적 웹페이지
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password
                            , Model model) {
        // 로그인 성공 시, 모델에 저장 (id==password)
        if(id.equals(password)) {
            model.addAttribute("loginId", id);
        }
        // 뷰와 모델을 전달
        return "login-result";  // 동적 웹페이지
    }
}
