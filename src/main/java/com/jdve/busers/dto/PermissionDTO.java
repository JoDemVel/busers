package com.jdve.busers.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PermissionDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
