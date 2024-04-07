package com.horus.yoga.entity;

import com.horus.yoga.config.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role extends Auditable {

    private UUID id;

    private com.horus.yoga.enums.Role name;

    public Role(){

    }
    public Role(com.horus.yoga.enums.Role name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public com.horus.yoga.enums.Role getName() {
        return name;
    }

    public void setName(com.horus.yoga.enums.Role name) {
        this.name = name;
    }
}
