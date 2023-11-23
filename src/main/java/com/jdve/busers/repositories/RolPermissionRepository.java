package com.jdve.busers.repositories;

import com.jdve.busers.domain.entities.RolPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolPermissionRepository extends JpaRepository<RolPermission, Integer> {
    List<RolPermission> findAllByRol_Id(Integer rolId);
}
