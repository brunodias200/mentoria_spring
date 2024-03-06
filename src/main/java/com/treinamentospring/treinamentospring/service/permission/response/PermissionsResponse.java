package com.treinamentospring.treinamentospring.service.permission.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.treinamentospring.treinamentospring.model.PermissionModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"id", "name", "enabled"})
public class PermissionsResponse {
    private Long id;
    private String name;
    private boolean enabled;

    public PermissionsResponse(PermissionModel permission){
        this.enabled=permission.isEnabled();
        this.name=permission.getName();
        this.id=permission.getId();

    }
}
