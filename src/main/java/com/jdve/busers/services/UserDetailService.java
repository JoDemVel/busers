package com.jdve.busers.services;

import com.jdve.busers.dto.UserDetailDTO;

import java.util.List;

public interface UserDetailService {
    List<UserDetailDTO> listUserDetails();
    UserDetailDTO getUserDetailById(Long id);
    UserDetailDTO save(UserDetailDTO userDetailDTO);
    UserDetailDTO edit(Long id, UserDetailDTO userDetailDTO);
    UserDetailDTO delete(Long id);
}
