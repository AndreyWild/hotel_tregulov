package com.senla.hotel.api.dao;

import com.senla.hotel.model.entities.AEntity;

import java.util.List;

public interface IGenericDao<T extends AEntity> {

    T save(T entity);

    T getById(Long id);

    List<T> getAll();

    List<T> findAll();

    void delete(T entity);

    void deleteById(Long id);

    void deleteAll();

    void update(T entity);
}
