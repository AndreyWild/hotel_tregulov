package com.senla.hotel.api.service;

import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.entities.AEntity;

import java.util.List;

public interface IGenericService<T, Y extends AEntity> {

    Y save(Y entity);

    Y getById(Long id);

    List<Y> getAll();

    public List<T> findAll();

    void delete(T entity);

    void deleteById(Long id);

    void deleteAll();

    void update(Y entity);

    List<Y> getSortedListByField(String fieldName);
}
