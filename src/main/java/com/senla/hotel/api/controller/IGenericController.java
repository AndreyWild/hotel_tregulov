package com.senla.hotel.api.controller;

import com.senla.hotel.model.entities.AEntity;

import java.util.List;

public interface IGenericController <T extends AEntity> {

    T save(T entity);

    T getById(Long id);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}
