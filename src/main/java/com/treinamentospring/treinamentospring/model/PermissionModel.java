package com.treinamentospring.treinamentospring.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="permission")
@Getter
@Setter
public class PermissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean enabled;
    private String name;

}
