package com.treinamentospring.treinamentospring.service.permission;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProfileService {
     Page<ProfileModel> findByNameContainsIgnoreCase(String name, Pageable pageable);
     Page<ProfileModel> findAll(Pageable pageable);
     Optional<ProfileModel> findById(Long id);
}
