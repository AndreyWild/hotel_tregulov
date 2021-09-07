package com.senla.hotel.service;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.api.service.IRoomService;
import com.senla.hotel.model.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomService implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    @Autowired
    public RoomService(IRoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public Room save(Room entity) {
        return roomDao.save(entity);
    }

    @Override
    public Room getById(Long id) {
        return roomDao.getById(id);
    }

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public List<Room> findAll() {
        return findAll();
    }

    @Override
    public void delete(Room entity) {
        roomDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        roomDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        roomDao.deleteAll();
    }

    @Override
    public void update(Room entity) {
        roomDao.update(entity);
    }
}
