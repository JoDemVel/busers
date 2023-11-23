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
@Table(name = "rol_permission")
public class RolPermission {
    @Id
    @SequenceGenerator(name = "rol_permission_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_permission_sequence")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
