package com.jdve.busers.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@ToString
@EqualsAndHashCode(of = {"userId", "rolId"})
public class UserRolId implements Serializable {
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "rol_id")
    private Integer rolId;
}
