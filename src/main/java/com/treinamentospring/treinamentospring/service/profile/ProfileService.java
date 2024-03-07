package com.treinamentospring.treinamentospring.service.profile;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import com.treinamentospring.treinamentospring.service.profile.request.ProfileRequest;
import com.treinamentospring.treinamentospring.service.profile.response.ProfileResponse;
import com.treinamentospring.treinamentospring.service.profile.response.ProfilesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProfileService {
     Page<ProfilesResponse> findByNameContainsIgnoreCase(String name, Pageable pageable);
     Page<ProfilesResponse> findAll(Pageable pageable);
     ProfileResponse findById(Long id);

     ProfileResponse save(ProfileRequest request);

    void deleteById(Long id);
}
