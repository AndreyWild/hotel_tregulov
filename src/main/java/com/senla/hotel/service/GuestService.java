package com.senla.hotel.service;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.api.service.IGuestService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Guest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GuestService implements IGuestService {

    private final IGuestDao guestDao;
    private final ModelMapper modelMapper;

    @Override
    public Guest save(Guest entity) {
        return guestDao.save(entity);
    }

    @Override
    public GuestDto getById(Long id) {
        Guest guest = guestDao.getById(id);
        if(guest == null){
            throw  new NoSuchEntityException("There is no Guest with ID = " + id + " in Database");
        }
        return modelMapper.map(guest, GuestDto.class);
    }

    @Override
    public List<Guest> getAll() {
        return guestDao.getAll();
    }

    @Override
    public List<Guest> findAll() {
        return guestDao.findAll();
    }

    @Override
    public void delete(Guest entity) {
        guestDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        Guest guest = guestDao.getById(id);

        if (guest == null) {
            throw new NoSuchEntityException("There is no Guest with ID = "
                    + id + " in Database");
        }

        guestDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        guestDao.deleteAll();
    }

    @Override
    public void update(Guest entity) {
        guestDao.update(entity);
    }
}
