package com.finnova.backend.repository;

import com.finnova.backend.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolEntity, String> {
}