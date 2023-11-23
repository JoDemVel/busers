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
public class RolPermissionDTO implements Serializable {
    private Integer id;

    private Integer rolId;
    private String rolName;

    private Integer permissionId;
    private String permissionName;

    private LocalDateTime createdAt;
}
