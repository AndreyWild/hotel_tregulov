package com.senla.hotel.controller;

import com.senla.hotel.api.controller.IGenericController;
import com.senla.hotel.api.service.IGenericService;
import com.senla.hotel.model.entities.AEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
public abstract class AbstractController<T extends AEntity, Y extends IGenericService> /*implements IGenericController<T>*/ {

    @Autowired
    private Y service;

    @GetMapping
    public List<T> getAll() {
        log.info(String.format("Received request (GET): /%s", getEndPoint()));
        return service.getAll();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        log.info(String.format("Received request (GET): /%s/" + id, getEndPoint()));
        return (T) service.getById(id);
    }

    @PostMapping
    public T save(@RequestBody T entity) {
        log.info(String.format("Received request (POST): /%s", getEndPoint()));
        return (T) service.save(entity);
    }

    @PutMapping
    public T update(@RequestBody T entity) {
        log.info(String.format("Received request (PUT): /%s", getEndPoint()));
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        log.info(String.format("Received request (DELETE): /%s/" + id, getEndPoint()));
        service.deleteById(id);
        return "Entity with ID = " + id + " was deleted";
    }

    protected abstract String getEndPoint();
}
