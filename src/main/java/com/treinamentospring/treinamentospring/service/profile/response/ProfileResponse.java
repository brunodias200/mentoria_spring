package com.treinamentospring.treinamentospring.service.profile.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean enabled;
    private String name;
}
