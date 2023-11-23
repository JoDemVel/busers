package com.jdve.busers.services;

import com.jdve.busers.dto.PermissionDTO;

import java.util.List;

public interface PermissionService {
    List<PermissionDTO> listPermissions();
    PermissionDTO getPermissionById(Integer id);
    PermissionDTO save(PermissionDTO permissionDTO);
    PermissionDTO edit(Integer id, PermissionDTO permissionDTO);
    PermissionDTO delete(Integer id);
}
