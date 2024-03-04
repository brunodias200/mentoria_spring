package com.treinamentospring.treinamentospring.server;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import com.treinamentospring.treinamentospring.service.permission.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PermissionController {
    private final PermissionService service;
    public ResponseEntity<Page<PermissionModel>> findByName(String name, Pageable pageable){
        return ResponseEntity.ok(service.findByNameContainsIgnoreCase(name, pageable));
    }
}
