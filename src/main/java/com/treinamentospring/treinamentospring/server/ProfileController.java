package com.treinamentospring.treinamentospring.server;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import com.treinamentospring.treinamentospring.service.profile.request.ProfileRequest;
import com.treinamentospring.treinamentospring.service.profile.response.ProfileResponse;
import com.treinamentospring.treinamentospring.service.profile.response.ProfilesResponse;
import com.treinamentospring.treinamentospring.service.profile.ProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService service;

    @GetMapping("/")
    public  ResponseEntity<Page<ProfilesResponse>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Page<ProfilesResponse>> findByName(@PathVariable String name, Pageable pageable){
        return ResponseEntity.ok(service.findByNameContainsIgnoreCase(name, pageable));
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> save(@Valid @RequestBody ProfileRequest request){
        return ResponseEntity.ok(service.save(request));
    }
}
