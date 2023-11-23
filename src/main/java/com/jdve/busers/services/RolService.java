package com.jdve.busers.services;

import com.jdve.busers.dto.RolDTO;

import java.util.List;

public interface RolService {
    List<RolDTO> listRoles();
    RolDTO getRolById(Integer id);
    RolDTO save(RolDTO rolDTO);
    RolDTO edit(Integer id, RolDTO rolDTO);
    RolDTO delete(Integer id);
}
