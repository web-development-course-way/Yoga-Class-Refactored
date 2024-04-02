package com.yoga.horus.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<Entity,DTO> {

    List<DTO> getAll();
    DTO getOne (UUID id);

    void create (Entity object);

    void update (UUID id, Entity object);

    void  delete (UUID id);
}
