package com.jdve.busers.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_rol")
public class UserRol {
    @EmbeddedId
    private UserRolId id;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private Rol rol;
    private Boolean active;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
