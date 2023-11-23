package com.jdve.busers.services.mapper;

import com.jdve.busers.domain.entities.Permission;
import com.jdve.busers.dto.PermissionDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PermissionMapper implements CustomMapper<PermissionDTO, Permission>{
    @Override
    public PermissionDTO toDto(Permission permission) {
        return PermissionDTO.builder()
                .id(permission.getId())
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }

    @Override
    public Permission toEntity(PermissionDTO permissionDTO) {
        return Permission.builder()
                .id(permissionDTO.getId())
                .name(permissionDTO.getName())
                .description(permissionDTO.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
