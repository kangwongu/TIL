package com.sparta.springcore.controller;

import com.sparta.springcore.model.Folder;
import com.sparta.springcore.model.UserRoleEnum;
import com.sparta.springcore.repository.FolderRepository;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final FolderService folderService;

    @Autowired
    public HomeController(FolderService folderService) {
        this.folderService = folderService;
    }

    // 로그인에 성공하면 로그인된 회원정보를 시큐리티로부터 넘겨받음
    // 로그인된 사용자의 정보가 UserDetailsImpl로 넘어온다
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 1. 로그인된 회원의 정보를 모델에 저장

        // 회원 정보 중 username을 모델에 저장
        model.addAttribute("username", userDetails.getUsername());
        // 회원 정보 중 Role이 ADMIN이면 모델에 저장 ( 클라이언트가 회원이 USER인지 ADMIN인지 확인하는 용도 )
        if(userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        List<Folder> folderList = folderService.getFolders(userDetails.getUser());
        model.addAttribute("folders", folderList);

        // 2. 템플릿엔진에 뷰와 모델을 전달 -> 뷰에 모델이 적용
        return "index";
    }
}
