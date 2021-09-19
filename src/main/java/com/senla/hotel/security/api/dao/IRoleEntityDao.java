package com.senla.hotel.security.api.dao;

import com.senla.hotel.security.entity.RoleEntity;

public interface IRoleEntityDao {

    RoleEntity findByName(String name);
}
