package com.horus.yoga.controller;

import com.horus.yoga.util.APIResponse;
import java.util.List;
import java.util.UUID;

public interface BaseController<Entity, DTO> {
    APIResponse<DTO> getById(UUID id);

    APIResponse<List<DTO>> getAll();


    APIResponse<DTO> update(UUID id, Entity object);

    APIResponse<String> delete(UUID id);
}
