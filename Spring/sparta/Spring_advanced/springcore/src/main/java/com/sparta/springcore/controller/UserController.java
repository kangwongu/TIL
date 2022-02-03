package com.sparta.springcore.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.springcore.dto.SignupRequestDto;
import com.sparta.springcore.service.KakaoUserService;
import com.sparta.springcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;

    // 의존성 주입
    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        // 1. 회원가입 하기 위해 넘어온 정보를 DB에 저장한다.
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    // 카카오 로그인
    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        // 1. Service(Kakao)에게 카카오 로그인 처리를 하도록 함
        kakaoUserService.kakaoLogin(code);
        // 2. 로그인 처리 성공 시, 홈으로 이동
        return "redirect:/";
    }
}
