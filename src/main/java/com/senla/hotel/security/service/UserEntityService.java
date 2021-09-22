package com.senla.hotel.security.service;

import com.senla.hotel.security.api.service.IRoleEntityService;
import com.senla.hotel.security.api.service.IUserEntityService;
import com.senla.hotel.security.entity.RoleEntity;
import com.senla.hotel.security.entity.UserEntity;
import com.senla.hotel.security.api.dao.IUserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserEntityService implements IUserEntityService {

    @Autowired
    private IUserEntityDao userEntityDao;
    @Autowired
    private IRoleEntityService roleEntityService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity save(UserEntity userEntity) {
        RoleEntity roleEntity = roleEntityService.findByName("ROLE_USER");
        userEntity.setRoleEntity(roleEntity);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityDao.save(userEntity);
    }

    @Override
    public UserEntity findByLogin(String login) {
        return userEntityDao.findByLogin(login);
    }

    @Override
    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
