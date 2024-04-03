package com.yoga.horus.controller;

import com.yoga.horus.util.APIResponse;
import java.util.List;
import java.util.UUID;

public interface BaseController<T> {
    APIResponse<T> getById(UUID id);

    APIResponse<List<T>> getAll();

    APIResponse<T> create(T object);

    APIResponse<T> update(UUID id, T object);

    APIResponse<String> delete(UUID id);
}
