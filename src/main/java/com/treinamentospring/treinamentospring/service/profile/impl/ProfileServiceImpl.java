package com.treinamentospring.treinamentospring.service.profile.impl;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import com.treinamentospring.treinamentospring.repository.ProfileRepository;
import com.treinamentospring.treinamentospring.service.profile.response.ProfileResponse;
import com.treinamentospring.treinamentospring.service.profile.response.ProfilesResponse;
import com.treinamentospring.treinamentospring.service.profile.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final ModelMapper mapper;

    @Override
    public Page<ProfilesResponse> findByNameContainsIgnoreCase(String name, Pageable pageable) {
        var profiles = repository.findByNameContainsIgnoreCase(name, pageable);
        return profiles.map(ProfilesResponse::new);
    }

    @Override
    public Page<ProfilesResponse> findAll(Pageable pageable) {
        var profiles = repository.findAll(pageable);
        return profiles.map(ProfilesResponse::new);
    }

    @Override
    public ProfileResponse findById(Long id) {
        var profile = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.map(profile, ProfileResponse.class);
    }
}
