package com.treinamentospring.treinamentospring.service.profile.impl;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import com.treinamentospring.treinamentospring.repository.ProfileRepository;
import com.treinamentospring.treinamentospring.service.profile.ProfileResponse;
import com.treinamentospring.treinamentospring.service.profile.ProfileService;
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
    public Page<ProfileResponse> findByNameContainsIgnoreCase(String name, Pageable pageable) {
        var profiles = repository.findByNameContainsIgnoreCase(name, pageable);
        return profiles.map(ProfileResponse::new);
    }

    @Override
    public Page<ProfileResponse> findAll(Pageable pageable) {
        var profiles = repository.findAll(pageable);
        return profiles.map(ProfileResponse::new);
    }

    @Override
    public Optional<ProfileModel> findById(Long id) {
        return repository.findById(id);
    }
}
