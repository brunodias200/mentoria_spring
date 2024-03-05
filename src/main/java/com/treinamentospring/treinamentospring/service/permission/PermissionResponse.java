package com.treinamentospring.treinamentospring.service.permission;

import com.treinamentospring.treinamentospring.model.PermissionModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionResponse {
    private Long id;
    private String name;
    private boolean enabled;

    public PermissionResponse(PermissionModel permission){
        this.enabled=permission.isEnabled();
        this.name=permission.getName();
        this.id=permission.getId();

    }
}
