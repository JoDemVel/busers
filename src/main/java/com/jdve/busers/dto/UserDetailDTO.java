package com.jdve.busers.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetailDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;

    private Long userId;
}
