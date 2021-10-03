package com.senla.hotel.controller;

import com.senla.hotel.api.service.IGuestService;
import com.senla.hotel.dto.GuestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
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

    private final IGuestService guestService;

    @GetMapping("/sort/name_v2")
    public List<GuestDto> getAllSortedByName() {
        log.info("Received request (GET): /guests/sort/name");
        return guestService.getSortedListByField("name");
    }

    @GetMapping("/sort/age_v2")
    public List<GuestDto> getAllSortedByAge() {
        log.info("Received request (GET): /guests/sort/age");
        return guestService.getSortedListByField("age");
    }

}
