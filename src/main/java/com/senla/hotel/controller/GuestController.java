package com.senla.hotel.controller;

import com.senla.hotel.api.service.IGuestService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.entities.Guest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j
@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController {

    /* Mapping through ModelMapper */

    private final IGuestService guestService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<GuestDto> getAll(/*@RequestParam(value = "sort", defaultValue = "name", required=false) String name*/){
        log.info("Received request (GET): /guests");
        return guestService.getAll().stream().map(guest -> modelMapper.map(guest, GuestDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GuestDto getById(@PathVariable Long id){
        log.info("Received request (GET): /guests/" + id);
        return guestService.getById(id);
    }

    @PostMapping
    public GuestDto save(@RequestBody GuestDto guestDto) {
        log.info("Received request (POST): /guests");
        Guest guest = guestService.save(modelMapper.map(guestDto, Guest.class));
        return modelMapper.map(guest, GuestDto.class);
    }

    @PutMapping
    public GuestDto update(@RequestBody GuestDto guestDto) {
        log.info("Received request (PUT): /guests");
        guestService.update(modelMapper.map(guestDto, Guest.class));
        return guestDto;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        log.info("Received request (DELETE): /guests/" + id);
        guestService.deleteById(id);
        return "Guest with ID = " + id + " was deleted";
    }
}
