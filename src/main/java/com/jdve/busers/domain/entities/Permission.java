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
@Table(name = "permission")
public class Permission {
    @Id
    @SequenceGenerator(name = "permission_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_sequence")
    private Integer id;
    private String name;
    private String description;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
