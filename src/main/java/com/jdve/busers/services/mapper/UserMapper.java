package com.jdve.busers.services.mapper;

import com.jdve.busers.domain.entities.User;
import com.jdve.busers.domain.entities.UserDetail;
import com.jdve.busers.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper implements CustomMapper<UserDTO, User> {

    public UserDTO toDtoDetailed(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(
                    user.getUserDetail() != null ? user.getUserDetail().getFirstName() : null
                )
                .lastName(
                    user.getUserDetail() != null ? user.getUserDetail().getLastName() : null
                )
                .age(
                    user.getUserDetail() != null ? user.getUserDetail().getAge() : null
                )
                .birthDate(
                    user.getUserDetail() != null ? user.getUserDetail().getBirthDay() : null
                )
                .build();
    }

    @Override
    public UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
