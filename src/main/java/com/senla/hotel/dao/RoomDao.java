package com.senla.hotel.dao;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.model.entities.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao extends AbstractDao<Room> implements IRoomDao {

    @Override
    Class<Room> getGenericClass() {
        return Room.class;
    }
}
