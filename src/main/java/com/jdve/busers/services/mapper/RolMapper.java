package com.jdve.busers.services.mapper;

import com.jdve.busers.domain.entities.Rol;
import com.jdve.busers.dto.RolDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{
    @Override
    public RolDTO toDto(Rol rol) {
        return RolDTO.builder()
                .id(rol.getId())
                .name(rol.getName())
                .build();
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        return Rol.builder()
                .id(rolDTO.getId())
                .name(rolDTO.getName())
                .build();
    }
}
