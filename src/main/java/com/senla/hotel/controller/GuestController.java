package com.senla.hotel.controller;

import com.senla.hotel.api.controller.IGenericController;
import com.senla.hotel.api.controller.IGuestController;
import com.senla.hotel.api.service.IGuestService;
import com.senla.hotel.dto.GuestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController extends AbstractController<GuestDto, IGuestService> /*implements IGuestController*/ {

    private static final String ENDPOINT = "guests";

    @Override
    protected String getEndPoint() {
        return ENDPOINT;
    }

//    private final IGuestService guestService;
//
//    @GetMapping
//    public List<GuestDto> getAll() {
//        log.info("Received request (GET): /guests");
//        return guestService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public GuestDto getById(@PathVariable Long id) {
//        log.info("Received request (GET): /guests/" + id);
//        return guestService.getById(id);
//    }
//
//    @PostMapping
//    public GuestDto save(@RequestBody GuestDto guestDto) {
//        log.info("Received request (POST): /guests");
//        return guestService.save(guestDto);
//    }
//
//    @PutMapping
//    public GuestDto update(@RequestBody GuestDto guestDto) {
//        log.info("Received request (PUT): /guests");
//        guestService.update(guestDto);
//        return guestDto;
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Long id) {
//        log.info("Received request (DELETE): /guests/" + id);
//        guestService.deleteById(id);
//        return "Guest with ID = " + id + " was deleted";
//    }
}
