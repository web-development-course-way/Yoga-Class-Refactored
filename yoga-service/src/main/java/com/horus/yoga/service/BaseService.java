package com.horus.yoga.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseService<Entity,DTO> {

    List<DTO> getAll();
    Optional<DTO> getOne (UUID id);

    DTO create (Entity object);

    DTO update (UUID id, Entity object);

    void  delete (UUID id);
}
