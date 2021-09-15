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

//    private final IRoomService roomService;
//
//    @GetMapping
//    public List<RoomDto> getAll() {
//        log.info("Received request (GET): /room");
//        return roomService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public RoomDto getById(@PathVariable Long id) {
//        log.info("Received request (GET): /rooms/" + id);
//        return roomService.getById(id);
//    }
//
//    @PostMapping
//    public RoomDto save(@RequestBody RoomDto roomDto) {
//        log.info("Received request (POST): /rooms");
//        return roomService.save(roomDto);
//    }
//
//    @PutMapping
//    public RoomDto update(@RequestBody RoomDto roomDto) {
//        log.info("Received request (PUT): /rooms");
//        roomService.update(roomDto);
//        return roomDto;
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Long id) {
//        log.info("Received request (DELETE): /rooms/" + id);
//        roomService.deleteById(id);
//        return "Room with ID = " + id + " was deleted";
//    }
}
