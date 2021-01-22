package com.example.board.service.Impl;


import com.example.board.dto.UserDto;
import com.example.board.entity.User;
import com.example.board.repository.UserRepository;
import com.example.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Long save(UserDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(User.builder()
                .email(infoDto.getEmail())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword())
                .createdDate(LocalDateTime.now())
                .build()).getId();
    }

    public Boolean checkEmailDuplicated(String email) {
        if (userRepository.findByEmail(email).orElse(null) == null) {
            return true;
        } else {
            return false;
        }
    }
}
