package com.jdve.busers.services.mapper;

import com.jdve.busers.domain.entities.User;
import com.jdve.busers.dto.UserCreateDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserCreateMapper implements CustomMapper<UserCreateDTO, User>{
    @Override
    public UserCreateDTO toDto(User user) {
        return UserCreateDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    @Override
    public User toEntity(UserCreateDTO userCreateDTO) {
        return User.builder()
                .id(userCreateDTO.getId())
                .username(userCreateDTO.getUsername())
                .email(userCreateDTO.getEmail())
                .password(userCreateDTO.getPassword())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
