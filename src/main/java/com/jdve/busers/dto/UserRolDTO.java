package com.jdve.busers.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRolDTO implements Serializable {
    private Long userId;
    private Integer rolId;

    private String username;
    private String email;

    private String rolName;

    private Boolean active;

    private LocalDateTime createdAt;
}
