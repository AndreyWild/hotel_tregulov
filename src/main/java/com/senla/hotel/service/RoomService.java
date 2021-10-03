package com.senla.hotel.service;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.api.service.IRoomService;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService implements IRoomService {

    private final IRoomDao roomDao;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto save(RoomDto entity) {
        Room room = roomDao.save(modelMapper.map(entity, Room.class));
        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public RoomDto getById(Long id) {
        Room room = roomDao.getById(id);

        if (room == null) {
            throw new NoSuchEntityException("There is no Room with ID = " + id + " in Database");
        }

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAll() {
        return roomDao.getAll().stream().map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
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
    public void update(RoomDto entity) {
        roomDao.update(modelMapper.map(entity, Room.class));
    }

    @Override
    public List<RoomDto> getSortedListByField(String fieldName) {
        return roomDao.getSortedListByField(fieldName).stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }
}
