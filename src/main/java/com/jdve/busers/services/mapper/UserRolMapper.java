package com.jdve.busers.services.mapper;

import com.jdve.busers.domain.entities.Rol;
import com.jdve.busers.domain.entities.User;
import com.jdve.busers.domain.entities.UserRol;
import com.jdve.busers.domain.entities.UserRolId;
import com.jdve.busers.dto.UserRolDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol> {
    @Override
    public UserRolDTO toDto(UserRol userRol) {
        return UserRolDTO.builder()
                .userId(userRol.getId().getUserId())
                .rolId(userRol.getId().getRolId())
                .username(userRol.getUser().getUsername())
                .email(userRol.getUser().getEmail())
                .rolName(userRol.getRol().getName())
                .active(userRol.getActive())
                .build();
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        return UserRol.builder()
                .id(
                    UserRolId.builder()
                        .userId(userRolDTO.getUserId())
                        .rolId(userRolDTO.getRolId())
                        .build()
                )
                .user(
                    User.builder()
                        .id(userRolDTO.getUserId())
                        .username(userRolDTO.getUsername())
                        .email(userRolDTO.getEmail())
                        .build()
                )
                .rol(
                    Rol.builder()
                        .id(userRolDTO.getRolId())
                        .name(userRolDTO.getRolName())
                        .build()
                )
                .active(userRolDTO.getActive())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
