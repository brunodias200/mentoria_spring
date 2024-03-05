package com.treinamentospring.treinamentospring.service.profile;

import com.treinamentospring.treinamentospring.model.ProfileModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponse {
    private Long id;
    private String name;
    private boolean enabled;

    public ProfileResponse(ProfileModel profile){
        this.id = profile.getId();
        this.name = profile.getName();
        this.enabled = profile.isEnabled();
    }
}
