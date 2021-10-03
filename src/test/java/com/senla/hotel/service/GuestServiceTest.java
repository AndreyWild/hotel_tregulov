package com.senla.hotel.service;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.api.service.IGuestService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class GuestServiceTest {

    private IGuestService guestService;
    @Mock
    private IGuestDao guestDao;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private Guest guest;
    @Mock
    private GuestDto guestDto;

    private static final Long ID = 1L;

    @BeforeEach
    void setUp() {

        guestService = new GuestService(guestDao, modelMapper);
        guest.setId(ID);
        guest.setName("test");
        guest.setAge(15);
        guestDto.setId(ID);
        guestDto.setName("test");
        guestDto.setAge(15);
    }

    @Test
    public void whenSaveGuestShouldReturnGuestDto() {
        when(guestDao.save(ArgumentMatchers.any(Guest.class))).thenReturn(guest);
        when(modelMapper.map(guestDto, Guest.class)).thenReturn(guest);
        when(modelMapper.map(guest, GuestDto.class)).thenReturn(guestDto);
        GuestDto result = guestService.save(guestDto);
        assertEquals(result, guestDto);
        verify(guestDao).save(guest);
    }

    @Test
    void getByIdShouldReturnGuestDto() {
        when(guestDao.getById(anyLong())).thenReturn(guest);
        when(modelMapper.map(guest, GuestDto.class)).thenReturn(guestDto);
        GuestDto result = guestService.getById(anyLong());
        assertEquals(result, guestDto);
        verify(guestDao).getById(anyLong());
    }

    @Test
    void getByIdShouldReturnNull() {
        when(guestDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            guestService.getById(anyLong());
        });
        verify(guestDao).getById(anyLong());
    }

    @Test
    public void shouldReturnAllGuestFirst() {
        List<Guest> users = new ArrayList();
        users.add(guest);
        List<GuestDto> guestDtos = new ArrayList<>();
        guestDtos.add(guestDto);
        when(modelMapper.map(guest, GuestDto.class)).thenReturn(guestDto);
        when(guestDao.getAll()).thenReturn(users);
        List<GuestDto> expected = guestService.getAll();
        assertEquals(expected, guestDtos);
        verify(guestDao).getAll();
    }

    @Test
    public void shouldReturnExceptInsteadGuests() {
        given(guestDao.getAll()).willThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {
            guestService.getAll();
        });
        verify(guestDao).getAll();
    }

    @Test
    public void shouldReturnAllGuestSecond() {
        List<Guest> guests = new ArrayList();
        guests.add(guest);
        given(guestDao.findAll()).willReturn(guests);
        List<Guest> expected = guestDao.findAll();
        assertEquals(expected, guests);
        verify(guestDao).findAll();
    }


    @Test
    public void whenGivenGuestShouldDeleteGuestIfFound() {
        guestService.delete(guest);
        verify(guestDao).delete(guest);
    }

    @Test
    public void whenGivenIdShouldDeleteGuestIfFound() {
        when(guestDao.getById(guest.getId())).thenReturn(guest);
        guestService.deleteById(guest.getId());
        verify(guestDao).deleteById(guest.getId());
    }

    @Test
    void shouldThrowExceptionWhenGuestDoesntExist() {
        when(guestDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            guestService.getById(anyLong());
        });
    }

    @Test
    public void update() {
        when(modelMapper.map(guestDto, Guest.class)).thenReturn(guest);
        guestService.update(guestDto);
        verify(guestDao).update(guest);
    }
}