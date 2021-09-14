package com.senla.hotel.service;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.api.service.IRoomService;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService implements IRoomService {

    private final IRoomDao roomDao;
    private final ModelMapper modelMapper;

    @Override
    public Room save(Room entity) {
        return roomDao.save(entity);
    }

    @Override
    public RoomDto getById(Long id) {
        Room room = roomDao.getById(id);

        if(room == null){
            throw  new NoSuchEntityException("There is no Room with ID = " + id + " in Database");
        }

        return modelMapper.map(room, RoomDto.class);
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
        Room room = roomDao.getById(id);
        if (room == null) {
            throw new NoSuchEntityException("There is no room with ID = "
                    + id + " in Database");
        }

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
