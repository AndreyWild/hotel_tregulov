package com.senla.hotel.security.service;

import com.senla.hotel.security.api.dao.IRoleEntityDao;
import com.senla.hotel.security.api.service.IRoleEntityService;
import com.senla.hotel.security.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleEntityService implements IRoleEntityService {

    @Autowired
    private IRoleEntityDao roleEntityDao;

    @Override
    public RoleEntity findByName(String name) {
        return roleEntityDao.findByName(name);
    }
}
