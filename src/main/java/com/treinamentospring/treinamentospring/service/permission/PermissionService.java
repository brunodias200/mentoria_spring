package com.treinamentospring.treinamentospring.service.permission;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermissionService {
     Page<PermissionModel> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
