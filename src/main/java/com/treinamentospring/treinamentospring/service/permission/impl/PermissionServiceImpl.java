package com.treinamentospring.treinamentospring.service.permission.impl;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import com.treinamentospring.treinamentospring.repository.PermissionRepository;
import com.treinamentospring.treinamentospring.service.permission.request.PermissionRequest;
import com.treinamentospring.treinamentospring.service.permission.response.PermissionResponse;
import com.treinamentospring.treinamentospring.service.permission.response.PermissionsResponse;
import com.treinamentospring.treinamentospring.service.permission.PermissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;
    private final ModelMapper mapper;

    @Override
    public Page<PermissionsResponse> findByNameContainsIgnoreCase(String name, Pageable pageable) {
        var permissions = repository.findByNameContainsIgnoreCase(name, pageable);
        return permissions.map(PermissionsResponse::new);
    }

    @Override
    public Page<PermissionsResponse> findAll(Pageable pageable) {
        var permissions = repository.findAll(pageable);
        return permissions.map(PermissionsResponse::new);
    }

    @Override
    public PermissionResponse findById(Long id) {
        var permission = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.map(permission, PermissionResponse.class);
    }

    @Override
    public PermissionResponse save(PermissionRequest request) {
        var permission = mapper.map(request, PermissionModel.class);
        permission = repository.save(permission);

        return mapper.map(permission, PermissionResponse.class);
    }


}
