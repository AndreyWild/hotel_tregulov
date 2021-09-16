package com.senla.hotel.api.controller;

import com.senla.hotel.model.entities.AEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IGenericController<T extends AEntity> {


    List<T> getAll();

    T getById(@PathVariable Long id);

    T save(@RequestBody T entity);

    T update(@RequestBody T entity);

    String delete(@PathVariable Long id);

}
