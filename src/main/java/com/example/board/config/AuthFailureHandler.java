package com.example.board.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Getter
@Setter
public class AuthFailureHandler implements AuthenticationFailureHandler {

    private String loginEmail;
    private String loginPassword;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String email = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("loginEmail", email);
        request.setAttribute("loginPassword", password);
        request.setAttribute("checkMsg", "Incorrect username or password.");

        request.getRequestDispatcher("/login").forward(request, response);

    }

}
