package com.jdve.busers.services.mapper;

import com.jdve.busers.domain.entities.User;
import com.jdve.busers.domain.entities.UserDetail;
import com.jdve.busers.dto.UserDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDetailDTO, UserDetail> {
    @Override
    public UserDetailDTO toDto(UserDetail userDetail) {
        return UserDetailDTO.builder()
                .id(userDetail.getId())
                .firstName(userDetail.getFirstName())
                .lastName(userDetail.getLastName())
                .age(userDetail.getAge())
                .birthDate(userDetail.getBirthDay())
                .userId(userDetail.getUser().getId())
                .build();
    }

    @Override
    public UserDetail toEntity(UserDetailDTO userDetailDTO) {
        return UserDetail.builder()
                .id(userDetailDTO.getId())
                .firstName(userDetailDTO.getFirstName())
                .lastName(userDetailDTO.getLastName())
                .age(userDetailDTO.getAge())
                .birthDay(userDetailDTO.getBirthDate())
                .user(User.builder().id(userDetailDTO.getUserId()).build())
                .build();
    }
}
