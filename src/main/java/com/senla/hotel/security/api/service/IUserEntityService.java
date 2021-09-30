package com.senla.hotel.security.api.service;

import com.senla.hotel.security.entity.UserEntity;

public interface IUserEntityService {

    UserEntity findByLogin(String login);

    UserEntity save(UserEntity entity);

    UserEntity findByLoginAndPassword(String login, String password);
}
