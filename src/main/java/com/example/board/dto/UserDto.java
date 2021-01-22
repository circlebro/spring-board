package com.example.board.dto;

import com.example.board.dto.common.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String password;

    private String auth;
    private LocalDateTime createdDate;

    @NoArgsConstructor
    public static class UserCustomRes<T> extends ApiResponse<T>{
        public UserCustomRes(int status, String error, T data) {
            super(status, error, data);
        }
    }
}
