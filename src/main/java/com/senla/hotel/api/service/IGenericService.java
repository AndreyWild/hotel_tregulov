package com.senla.hotel.api.service;

import com.senla.hotel.model.entities.AEntity;

import java.util.List;

public interface IGenericService<T extends AEntity> {

    T save(T entity);

    T getById(Long id);

    List<T> getAll();

    public List<T> findAll();

    void delete(T entity);

    void deleteById(Long id);

    void deleteAll();

    void update(T entity);
}
