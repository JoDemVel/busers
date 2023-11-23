package com.jdve.busers.services.mapper;

import com.jdve.busers.domain.entities.Permission;
import com.jdve.busers.domain.entities.Rol;
import com.jdve.busers.domain.entities.RolPermission;
import com.jdve.busers.dto.RolPermissionDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RolPermissionMapper implements CustomMapper<RolPermissionDTO, RolPermission>{
    @Override
    public RolPermissionDTO toDto(RolPermission rolPermission) {
        return RolPermissionDTO.builder()
                .id(rolPermission.getId())
                .rolId(
                    rolPermission.getRol() != null ? rolPermission.getRol().getId() : null
                )
                .rolName(
                    rolPermission.getRol() != null ? rolPermission.getRol().getName() : null
                )
                .permissionId(
                    rolPermission.getPermission() != null ? rolPermission.getPermission().getId() : null
                )
                .permissionName(
                    rolPermission.getPermission() != null ? rolPermission.getPermission().getName() : null
                )
                .build();
    }

    @Override
    public RolPermission toEntity(RolPermissionDTO rolPermissionDTO) {
        return RolPermission.builder()
                .id(rolPermissionDTO.getId())
                .rol(
                    Rol.builder()
                        .id(rolPermissionDTO.getRolId())
                        .name(rolPermissionDTO.getRolName())
                        .build()
                )
                .permission(
                    rolPermissionDTO.getPermissionId() == null ? null :
                    Permission.builder()
                        .id(rolPermissionDTO.getPermissionId())
                        .name(rolPermissionDTO.getPermissionName())
                        .build()
                )
                .createdAt(LocalDateTime.now())
                .build();
    }
}
