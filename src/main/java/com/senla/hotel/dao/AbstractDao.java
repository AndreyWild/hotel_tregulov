package com.senla.hotel.dao;

import com.senla.hotel.api.dao.IGenericDao;
import com.senla.hotel.model.entities.AEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDao<T extends AEntity> implements IGenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T save(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public T getById(Long id) {
        return getCurrentSession().get(getGenericClass(), id);
    }

    @Override
    public List<T> getAll() {
        return getCurrentSession().createQuery("from " + getGenericClass().getSimpleName(), getGenericClass()).list();
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createCriteria(getGenericClass()).list();
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().createQuery("DELETE " + getGenericClass()).executeUpdate();
    }

    @Override
    public void deleteById(Long id) {
        getCurrentSession().delete(getById(id));
    }

    @Override
    public void deleteAll() {
        getCurrentSession().createQuery("DELETE " + getGenericClass()).executeUpdate();
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    abstract Class<T> getGenericClass();
}

