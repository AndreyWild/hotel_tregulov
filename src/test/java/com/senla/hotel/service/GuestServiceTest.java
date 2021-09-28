package com.senla.hotel.service;

import com.senla.hotel.api.service.IGuestService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.entities.Guest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GuestServiceTest {

    private IGuestService guestService= Mockito.mock(GuestService.class);
    private static final Long GUEST_ID = 1L;
    private GuestDto guestDtoGeneral;

    @Before
    public void getUp() {
        MockitoAnnotations.initMocks(this);
        this.guestDtoGeneral = new GuestDto();
        guestDtoGeneral.setName("Test");
        guestDtoGeneral.setAge(50);

    }

    @Test
    public void whenSaveGuestShouldReturnUser() {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("Test Name");
        when(guestService.save(ArgumentMatchers.any(GuestDto.class))).thenReturn(guestDto);
        GuestDto created = guestService.save(guestDto);
        assertThat(created.getName()).isSameAs(guestDto.getName());
        verify(guestService).save(guestDto);
    }

    @Test
    public void getByIdShouldReturnTrue() {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("Test");
        guestDto.setAge(50);
        given(guestService.getById(GUEST_ID)).willReturn(guestDto);
        GuestDto argument = guestService.getById(GUEST_ID);
        assertThat(argument).isEqualTo(guestDto);
    }

    @Test(expected = RuntimeException.class)
    public void getByIdShouldReturnNull() {
        given(guestService.getById(anyLong())).willThrow(RuntimeException.class);
        guestService.getById(anyLong());
    }

    @Test
    public void shouldReturnAllGuestFirst() {
        List<GuestDto> usersDto = new ArrayList();
        usersDto.add(new GuestDto());
        given(guestService.getAll()).willReturn(usersDto);
        List<GuestDto> expected = guestService.getAll();
        assertEquals(expected, usersDto);
        verify(guestService).getAll();
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnExceptInsteadGuests() {
        given(guestService.getAll()).willThrow(RuntimeException.class);
        guestService.getAll();
    }

    @Test
    public void shouldReturnAllGuestSecond() {
        List<Guest> guests = new ArrayList();
        guests.add(new Guest());
        given(guestService.findAll()).willReturn(guests);
        List<Guest> expected = guestService.findAll();
        assertEquals(expected, guests);
        verify(guestService).findAll();
    }

    @Test
    public void whenGivenGuestShouldDeleteGuestIfFound() {
        Guest guest = new Guest();
        guest.setName("Test Name");
        guest.setId(GUEST_ID);
        when(guestService.getById(guest.getId())).thenReturn(guestDtoGeneral);
        guestService.delete(guest);
        verify(guestService).delete(guest);
    }

    @Test
    public void whenGivenIdShouldDeleteGuestIfFound() {
        Guest guest = new Guest();
        guest.setName("Test Name");
        guest.setId(GUEST_ID);
        when(guestService.getById(guest.getId())).thenReturn(guestDtoGeneral);
        guestService.deleteById(guest.getId());
        verify(guestService).deleteById(guest.getId());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenUserDoesntExist() {
        given(guestService.getById(GUEST_ID)).willThrow(RuntimeException.class);
        guestService.deleteById(GUEST_ID);
    }

    @Test
    public void update() {
        GuestDto newUser = new GuestDto();
        guestService.update(newUser);
        verify(guestService).update(newUser);
    }

}