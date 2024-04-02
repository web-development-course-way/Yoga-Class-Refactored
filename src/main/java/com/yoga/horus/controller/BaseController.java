package com.yoga.horus.controller;

import com.yoga.horus.util.APIResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;

public interface BaseController<T> {
    APIResponse<T> getById(UUID id);

    APIResponse<T> getAll();

    APIResponse<T> create(HttpServletRequest request);

    APIResponse<T> update(UUID id, HttpServletRequest request);

    APIResponse<T> delete(UUID id);
}
