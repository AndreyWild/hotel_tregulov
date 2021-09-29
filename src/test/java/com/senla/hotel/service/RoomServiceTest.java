package com.senla.hotel.service;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.api.service.IRoomService;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    private IRoomService roomService;
    @Mock
    private IRoomDao roomDao;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private Room room;
    @Mock
    private RoomDto roomDto;

    private static final Long ID = 1L;

    @BeforeEach
    void setUp() {

        roomService = new RoomService(roomDao, modelMapper);
        room.setId(ID);
        room.setNumber(111);
        room.setPrice(555.00);
        roomDto.setId(ID);
        roomDto.setNumber(111);
        roomDto.setPrice(555.00);
    }

    @Test
    public void whenSaveRoomShouldReturnRoomDto() {
        when(roomDao.save(ArgumentMatchers.any(Room.class))).thenReturn(room);
        when(modelMapper.map(roomDto, Room.class)).thenReturn(room);
        when(modelMapper.map(room, RoomDto.class)).thenReturn(roomDto);
        RoomDto result = roomService.save(roomDto);
        assertEquals(result, roomDto);
        verify(roomDao).save(room);
    }

    @Test
    void getByIdShouldReturnRoomDto() {
        when(roomDao.getById(anyLong())).thenReturn(room);
        when(modelMapper.map(room, RoomDto.class)).thenReturn(roomDto);
        RoomDto result = roomService.getById(anyLong());
        assertEquals(result, roomDto);
        verify(roomDao).getById(anyLong());
    }

    @Test
    void getByIdShouldReturnNull() {
        when(roomDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            roomService.getById(anyLong());
        });
        verify(roomDao).getById(anyLong());
    }

    @Test
    public void shouldReturnAllRoomFirst() {
        List<Room> users = new ArrayList();
        users.add(room);
        List<RoomDto> roomDtos = new ArrayList<>();
        roomDtos.add(roomDto);
        when(modelMapper.map(room, RoomDto.class)).thenReturn(roomDto);
        when(roomDao.getAll()).thenReturn(users);
        List<RoomDto> expected = roomService.getAll();
        assertEquals(expected, roomDtos);
        verify(roomDao).getAll();
    }

    @Test
    public void shouldReturnExceptInsteadRooms() {
        given(roomDao.getAll()).willThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {
            roomService.getAll();
        });
        verify(roomDao).getAll();
    }

    @Test
    public void shouldReturnAllRoomSecond() {
        List<Room> rooms = new ArrayList();
        rooms.add(room);
        given(roomDao.findAll()).willReturn(rooms);
        List<Room> expected = roomDao.findAll();
        assertEquals(expected, rooms);
        verify(roomDao).findAll();
    }


    @Test
    public void whenGivenRoomShouldDeleteRoomIfFound() {
        roomService.delete(room);
        verify(roomDao).delete(room);
    }

    @Test
    public void whenGivenIdShouldDeleteRoomIfFound() {
        when(roomDao.getById(room.getId())).thenReturn(room);
        roomService.deleteById(room.getId());
        verify(roomDao).deleteById(room.getId());
    }

    @Test
    void shouldThrowExceptionWhenRoomDoesntExist() {
        when(roomDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            roomService.getById(anyLong());
        });
    }

    @Test
    public void update() {
        when(modelMapper.map(roomDto, Room.class)).thenReturn(room);
        roomService.update(roomDto);
        verify(roomDao).update(room);
    }
}