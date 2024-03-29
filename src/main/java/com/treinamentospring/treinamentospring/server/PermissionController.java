package com.treinamentospring.treinamentospring.server;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import com.treinamentospring.treinamentospring.service.permission.request.PermissionRequest;
import com.treinamentospring.treinamentospring.service.permission.response.PermissionResponse;
import com.treinamentospring.treinamentospring.service.permission.response.PermissionsResponse;
import com.treinamentospring.treinamentospring.service.permission.PermissionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor

@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionService service;

    @GetMapping("/")
    public ResponseEntity<Page<PermissionsResponse>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<PermissionsResponse>> findByName(@PathVariable String name, Pageable pageable){
        return ResponseEntity.ok(service.findByNameContainsIgnoreCase(name, pageable));
    }

    @PostMapping
    public ResponseEntity<PermissionResponse> save(@Valid @RequestBody PermissionRequest request){
        return ResponseEntity.ok(service.save(request));
    }
}
