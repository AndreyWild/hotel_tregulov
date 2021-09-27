package com.senla.hotel.controller;

import com.senla.hotel.api.service.IRoomService;
import com.senla.hotel.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController extends AbstractController<RoomDto, IRoomService>{

    private static final String ENDPOINT = "rooms";

    @Override
    protected String getEndPoint() {
        return ENDPOINT;
    }

    private final IRoomService roomService;

    @GetMapping("/sorted/number_v2")
    public List<RoomDto> getAllSortedByNumber() {
        log.info("Received request (GET): /rooms/sorted/number");
        return roomService.getSortedListByField("number");
    }

    @GetMapping("/sorted/capacity_v2")
    public List<RoomDto> getAllSortedByCapacity() {
        log.info("Received request (GET): /rooms/sorted/capacity");
        return roomService.getSortedListByField("capacity");
    }

    @GetMapping("/sorted/price_v2")
    public List<RoomDto> getAllSortedByPrice() {
        log.info("Received request (GET): /rooms/sorted/price");
        return roomService.getSortedListByField("price");
    }

}
