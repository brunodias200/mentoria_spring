package com.treinamentospring.treinamentospring.server;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import com.treinamentospring.treinamentospring.service.profile.ProfileResponse;
import com.treinamentospring.treinamentospring.service.profile.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService service;

    @GetMapping("/")
    public  ResponseEntity<Page<ProfileResponse>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProfileModel>> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Page<ProfileResponse>> findByName(@PathVariable String name, Pageable pageable){
        return ResponseEntity.ok(service.findByNameContainsIgnoreCase(name, pageable));
    }
}
