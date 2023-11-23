package com.jdve.busers.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_detail")
@EqualsAndHashCode(of = {"id", "firstName", "lastName"})
public class UserDetail {
    @Id
    @SequenceGenerator(name = "user_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_detail_sequence")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Column(name = "birth_day")
    private LocalDate birthDay;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
