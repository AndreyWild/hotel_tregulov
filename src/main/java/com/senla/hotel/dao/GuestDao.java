package com.senla.hotel.dao;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.model.entities.Guest;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDao extends AbstractDao<Guest> implements IGuestDao {

    @Override
    Class<Guest> getGenericClass() {
        return Guest.class;
    }
}
