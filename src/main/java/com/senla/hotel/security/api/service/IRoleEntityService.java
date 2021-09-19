package com.senla.hotel.security.api.service;

import com.senla.hotel.security.entity.RoleEntity;

public interface IRoleEntityService {

    RoleEntity findByName(String name);
}
