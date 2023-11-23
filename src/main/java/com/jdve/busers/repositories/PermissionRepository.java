package com.jdve.busers.repositories;

import com.jdve.busers.domain.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
