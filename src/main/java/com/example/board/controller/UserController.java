package com.example.board.controller;

import com.example.board.dto.UserDto;
import com.example.board.dto.common.ApiResponse;
import com.example.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("/signup")
    public String signUpForm() {
        return "user/signup";
    }

    @ResponseBody
    @GetMapping("/email-duplicated")
    public UserDto.UserCustomRes<Boolean> checkEmailDuplicated(String email) {
        Boolean duplicated = userService.checkEmailDuplicated(email);
        return new UserDto.UserCustomRes<>(ApiResponse.OK, null, duplicated);
    }

    @PostMapping("/signup")
    public String signup(UserDto infoDto) {
        userService.save(infoDto);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

}
