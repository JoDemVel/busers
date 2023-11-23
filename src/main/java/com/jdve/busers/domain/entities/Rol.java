package com.jdve.busers.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "rol")
@EqualsAndHashCode(of = {"id", "name"})
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sequence")
    private Integer id;
    private String name;
}
