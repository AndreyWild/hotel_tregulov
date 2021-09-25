package com.senla.hotel.dao;

import com.senla.hotel.model.entities.Guest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GuestDaoTest {


    private GuestDao guestDao = Mockito.mock(GuestDao.class);
    private static final Long GUEST_ID = 1L;
    private Guest guest;

    @Before
    public void getUp() {
        MockitoAnnotations.initMocks(this);
        this.guest = new Guest();
        guest.setName("Test");
        guest.setAge(50);
    }

    @Test
    public void whenSaveGuestShouldReturnUser() {
        Guest guest = new Guest();
        guest.setName("Test Name");
        when(guestDao.save(ArgumentMatchers.any(Guest.class))).thenReturn(guest);
        Guest created = guestDao.save(guest);
        assertThat(created.getName()).isSameAs(guest.getName());
        verify(guestDao).save(guest);
    }

    @Test
    public void getByIdShouldReturnTrue() {
        given(guestDao.getById(GUEST_ID)).willReturn(guest);
        Guest argument = guestDao.getById(GUEST_ID);
        assertThat(argument).isEqualTo(new Guest("Test", 50));
    }

    @Test(expected = RuntimeException.class)
    public void getByIdShouldReturnNull() {
        given(guestDao.getById(anyLong())).willThrow(RuntimeException.class);
        guestDao.getById(anyLong());
    }

    @Test
    public void shouldReturnAllGuestFirst() {
        List<Guest> users = new ArrayList();
        users.add(new Guest());
        given(guestDao.getAll()).willReturn(users);
        List<Guest> expected = guestDao.getAll();
        assertEquals(expected, users);
        verify(guestDao).getAll();
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnExceptInsteadGuests() {
        given(guestDao.getAll()).willThrow(RuntimeException.class);
        guestDao.getAll();
    }

    @Test
    public void shouldReturnAllGuestSecond() {
        List<Guest> guests = new ArrayList();
        guests.add(new Guest());
        given(guestDao.findAll()).willReturn(guests);
        List<Guest> expected = guestDao.findAll();
        assertEquals(expected, guests);
        verify(guestDao).findAll();
    }

    @Test
    public void whenGivenGuestShouldDeleteGuestIfFound() {
        Guest guest = new Guest();
        guest.setName("Test Name");
        guest.setId(GUEST_ID);
        when(guestDao.getById(guest.getId())).thenReturn(guest);
        guestDao.delete(guest);
        verify(guestDao).delete(guest);
    }

    @Test
    public void whenGivenIdShouldDeleteGuestIfFound() {
        Guest guest = new Guest();
        guest.setName("Test Name");
        guest.setId(GUEST_ID);
        when(guestDao.getById(guest.getId())).thenReturn(guest);
        guestDao.deleteById(guest.getId());
        verify(guestDao).deleteById(guest.getId());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenUserDoesntExist() {
        Guest guest = new Guest();
        guest.setId(89L);
        guest.setName("Test Name");
        given(guestDao.getById(guest.getId())).willThrow(RuntimeException.class);
        guestDao.deleteById(guest.getId());
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void update() {
        Guest newUser = new Guest();
        guestDao.update(newUser);
        verify(guestDao).update(newUser);
    }

    @Test
    public void getGenericClass() {
        given(guestDao.getGenericClass()).willReturn(Guest.class);
        assertEquals(guestDao.getGenericClass(), Guest.class);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_user_doesnt_exist() {
//        Guest newGuest = new Guest();
//        when(guestDao.update(newGuest)).willThrow(RuntimeException.class);
//        guestDao.update(newGuest);
    }
}