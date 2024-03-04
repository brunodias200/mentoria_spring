package com.treinamentospring.treinamentospring.repository;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import com.treinamentospring.treinamentospring.model.ProfileModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileModel, Long> {
    Page<ProfileModel> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
