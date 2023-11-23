package com.jdve.busers.services;

import com.jdve.busers.dto.UserCreateDTO;
import com.jdve.busers.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> listUsers();
    List<UserDTO> listUsersDetailed();
    UserDTO getUserById(Long id);
    UserDTO save(UserCreateDTO userCreateDTO);
    UserDTO edit(Long id, UserCreateDTO userCreateDTO);
    UserDTO delete(Long id);
}
