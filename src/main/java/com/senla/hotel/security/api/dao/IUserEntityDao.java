package com.senla.hotel.security.api.dao;

import com.senla.hotel.security.entity.UserEntity;

public interface IUserEntityDao {

    UserEntity findByLogin(String login);

    UserEntity save(UserEntity entity);
}
