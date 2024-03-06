package com.treinamentospring.treinamentospring.service.permission.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class PermissionResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean enabled;
    private String name;
}
