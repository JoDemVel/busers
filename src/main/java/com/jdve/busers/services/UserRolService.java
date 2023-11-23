package com.jdve.busers.services;

import com.jdve.busers.domain.entities.UserRolId;
import com.jdve.busers.dto.RolDTO;
import com.jdve.busers.dto.UserRolDTO;

import java.util.List;

public interface UserRolService {
    List<UserRolDTO> listUserRoles();
    List<UserRolDTO> listUsersByRol(Integer rolId);
    UserRolDTO getUserRolById(UserRolId id);
    UserRolDTO save(UserRolDTO userRolDTO);
    UserRolDTO edit(UserRolId id, UserRolDTO userRolDTO);
    UserRolDTO delete(UserRolId id);
}
