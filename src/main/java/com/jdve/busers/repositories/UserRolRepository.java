package com.jdve.busers.repositories;

import com.jdve.busers.domain.entities.UserRol;
import com.jdve.busers.domain.entities.UserRolId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, UserRolId> {
    List<UserRol> findByRolId(Integer rolId);
}
