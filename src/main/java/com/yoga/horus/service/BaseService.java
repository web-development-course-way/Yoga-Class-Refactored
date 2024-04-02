package com.yoga.horus.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    List<T> getAll();
    T getOne (UUID id);

    void create (T object);

    T update (UUID id, T object);

    void  delete (UUID id);
}
