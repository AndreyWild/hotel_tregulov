package com.senla.hotel.controller;

import com.senla.hotel.api.controller.IGenericController;
import com.senla.hotel.model.entities.AEntity;

import java.util.List;

public class AbstractController<T extends AEntity> implements IGenericController<T> {

    @Override
    public T save(AEntity entity) {
        return null;
    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }
}
