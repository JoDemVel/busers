package com.jdve.busers.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RolDTO implements Serializable {
    private Integer id;
    private String name;
}
