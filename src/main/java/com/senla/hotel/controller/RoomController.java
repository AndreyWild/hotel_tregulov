package com.senla.hotel.controller;

import com.senla.hotel.api.service.IRoomService;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.model.entities.Room;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j
@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomService roomService;

    @GetMapping
    public List<RoomDto> getAll() {
        log.info("Received request (GET): /room");
        return roomService.getAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RoomDto getById(@PathVariable Long id) {
        log.info("Received request (GET): /rooms/" + id);
        return new RoomDto(roomService.getById(id));
    }

    @PostMapping
    public RoomDto save(@RequestBody RoomDto roomDto) {
        log.info("Received request (POST): /rooms");
        Room room = new Room();
        room.setNumber(roomDto.getNumber());
        room.setCapacity(roomDto.getCapacity());
        room.setStatus(roomDto.getStatus());
        room.setPrice(roomDto.getPrice());
        room.setStars(roomDto.getStars());
        roomService.save(room);
        return new RoomDto(room);
    }

    @PutMapping
    public RoomDto update(@RequestBody RoomDto roomDto) {
        log.info("Received request (PUT): /rooms");
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setNumber(roomDto.getNumber());
        room.setCapacity(roomDto.getCapacity());
        room.setStatus(roomDto.getStatus());
        room.setPrice(roomDto.getPrice());
        room.setStars(roomDto.getStars());
        roomService.update(room);
        return roomDto;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        log.info("Received request (DELETE): /rooms/" + id);
        roomService.deleteById(id);
        return "Room with ID = " + id + " was deleted";
    }
}
