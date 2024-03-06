package com.treinamentospring.treinamentospring.service.permission.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@JsonPropertyOrder({"id", "name", "createdAt", "modifiedAt", "enabled"})
public class PermissionResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean enabled;
    private String name;
}
