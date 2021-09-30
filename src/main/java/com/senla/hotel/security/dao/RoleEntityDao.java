package com.senla.hotel.security.dao;

import com.senla.hotel.security.entity.RoleEntity;
import com.senla.hotel.security.api.dao.IRoleEntityDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleEntityDao implements IRoleEntityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public RoleEntity findByName(String name) {
        return getCurrentSession().get(RoleEntity.class, name);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
