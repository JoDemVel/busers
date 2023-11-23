package com.jdve.busers.services;

import com.jdve.busers.dto.RolPermissionDTO;

import java.util.List;

public interface RolPermissionService {
    List<RolPermissionDTO> getRolPermissionsByRolId(Integer rolId);
    RolPermissionDTO getRolPermissionById(Integer id);

    List<RolPermissionDTO> getAllRolPermission();
    RolPermissionDTO save(RolPermissionDTO rolPermissionDTO);
    RolPermissionDTO edit(Integer id, RolPermissionDTO rolPermissionDTO);
    RolPermissionDTO delete(Integer id);
}
