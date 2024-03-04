package com.treinamentospring.treinamentospring.repository;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionModel, Long> {
    Page<PermissionModel> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
