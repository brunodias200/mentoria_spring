package com.treinamentospring.treinamentospring.service.permission.impl;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import com.treinamentospring.treinamentospring.repository.PermissionRepository;
import com.treinamentospring.treinamentospring.service.permission.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    @Override
    public Page<PermissionModel> findByNameContainsIgnoreCase(String name, Pageable pageable) {
        return repository.findByNameContainsIgnoreCase(name, pageable);
    }
}
