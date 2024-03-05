package com.treinamentospring.treinamentospring.service.profile;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProfileService {
     Page<ProfileResponse> findByNameContainsIgnoreCase(String name, Pageable pageable);
     Page<ProfileResponse> findAll(Pageable pageable);
     Optional<ProfileModel> findById(Long id);
}
