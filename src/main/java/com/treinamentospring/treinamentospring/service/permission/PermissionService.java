package com.treinamentospring.treinamentospring.service.permission;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import com.treinamentospring.treinamentospring.service.permission.response.PermissionResponse;
import com.treinamentospring.treinamentospring.service.permission.response.PermissionsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PermissionService {
     Page<PermissionsResponse> findByNameContainsIgnoreCase(String name, Pageable pageable);
     Page<PermissionsResponse> findAll(Pageable pageable);
     PermissionResponse findById(Long id);
}
