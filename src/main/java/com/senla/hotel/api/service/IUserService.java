package com.senla.hotel.api.service;

import com.senla.hotel.model.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    void save(User user);

    User getByLogin(String login);

    User getById(Long id);
}
