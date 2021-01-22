package com.example.board.service;

import com.example.board.dto.UserDto;

public interface UserService {
    Long save(UserDto infoDto);
    Boolean checkEmailDuplicated(String email);
}
