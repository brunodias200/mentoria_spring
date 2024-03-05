package com.treinamentospring.treinamentospring.service.permission.impl;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import com.treinamentospring.treinamentospring.repository.PermissionRepository;
import com.treinamentospring.treinamentospring.service.permission.PermissionResponse;
import com.treinamentospring.treinamentospring.service.permission.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    @Override
    public Page<PermissionResponse> findByNameContainsIgnoreCase(String name, Pageable pageable) {
        var permissions = repository.findByNameContainsIgnoreCase(name, pageable);
        return permissions.map(PermissionResponse::new);
    }

    @Override
    public Page<PermissionResponse> findAll(Pageable pageable) {
        var permissions = repository.findAll(pageable);
        return permissions.map(PermissionResponse::new);
    }

    @Override
    public Optional<PermissionModel> findById(Long id) {
        return repository.findById(id);
    }
}
