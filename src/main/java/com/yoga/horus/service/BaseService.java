package com.yoga.horus.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<Entity,DTO> {

    List<DTO> getAll();
    DTO getOne (UUID id);

    DTO create (Entity object);

    DTO update (UUID id, Entity object);

    void  delete (UUID id);
}
