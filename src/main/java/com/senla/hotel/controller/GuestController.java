package com.senla.hotel.controller;

import com.senla.hotel.api.service.IGuestService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    IGuestService guestService;

    @GetMapping("/guests")
    public List<GuestDto> getAll(){
        return guestService.getAll().stream().map(GuestDto::new).collect(Collectors.toList());
    }

    @GetMapping("/guests/{id}")
    public GuestDto getById(@PathVariable Long id){
        Guest guest = guestService.getById(id);

        if(guest == null){
            throw  new NoSuchEntityException("There is no Guest with ID = " + id + " in Database");
        }

        return new GuestDto(guest);
    }

    @PostMapping("/guests")
    public GuestDto save(@RequestBody GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setName(guestDto.getName());
        guest.setAge(guestDto.getAge());
        return new GuestDto(guestService.save(guest));
    }

    @PutMapping("/guests")
    public GuestDto update(@RequestBody GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setName(guestDto.getName());
        guest.setAge(guestDto.getAge());
        guestService.update(guest);
        return guestDto;
    }

    @DeleteMapping("/guests/{id}")
    public String delete(@PathVariable Long id) {
        Guest guest = guestService.getById(id);
        if (guest == null) {
            throw new NoSuchEntityException("There is no guest with ID = "
                    + id + " in Database");
        }

        guestService.deleteById(id);
        return "Guest with ID = " + id + " was deleted";
    }




}
