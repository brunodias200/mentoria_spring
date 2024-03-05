package com.treinamentospring.treinamentospring.service.permission;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PermissionService {
     Page<PermissionResponse> findByNameContainsIgnoreCase(String name, Pageable pageable);
     Page<PermissionResponse> findAll(Pageable pageable);
     Optional<PermissionModel> findById(Long id);
}
