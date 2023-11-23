package com.jdve.busers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreateDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;

    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;
}
