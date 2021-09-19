package com.senla.hotel.security.dao;

import com.senla.hotel.security.entity.UserEntity;
import com.senla.hotel.security.api.dao.IUserEntityDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityDao implements IUserEntityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserEntity findByLogin(String login) {
        return getCurrentSession().get(UserEntity.class, login);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
