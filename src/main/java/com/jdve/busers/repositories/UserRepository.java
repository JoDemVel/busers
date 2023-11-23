package com.jdve.busers.repositories;

import com.jdve.busers.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
