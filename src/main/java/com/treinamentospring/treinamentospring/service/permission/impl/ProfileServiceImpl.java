package com.treinamentospring.treinamentospring.service.permission.impl;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import com.treinamentospring.treinamentospring.repository.ProfileRepository;
import com.treinamentospring.treinamentospring.service.permission.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    @Override
    public Page<ProfileModel> findByNameContainsIgnoreCase(String name, Pageable pageable) {
        return repository.findByNameContainsIgnoreCase(name, pageable);
    }

    @Override
    public Page<ProfileModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<ProfileModel> findById(Long id) {
        return repository.findById(id);
    }
}
