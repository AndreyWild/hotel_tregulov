package com.senla.hotel.controller;

import com.senla.hotel.api.service.IRoomService;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    IRoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getAll(){
        List<Room> allRooms = roomService.getAll();
        return allRooms;
    }

    @GetMapping("/rooms/{id}")
    public Room getById(@PathVariable Long id){
        Room room = roomService.getById(id);

        if(room == null){
            throw  new NoSuchEntityException("There is no Room with ID = " + id + " in Database");
        }

        return room;
    }

    @PostMapping("/rooms")
    public Room save(@RequestBody Room room) {
        roomService.save(room);
        return room;
    }

    @PutMapping("/rooms")
    public Room update(@RequestBody Room room) {
        roomService.update(room);
        return room;
    }

    @DeleteMapping("/rooms/{id}")
    public String delete(@PathVariable Long id) {
        Room room = roomService.getById(id);
        if (room == null) {
            throw new NoSuchEntityException("There is no room with ID = "
                    + id + " in Database");
        }

        roomService.deleteById(id);
        return "Room with ID = " + id + " was deleted";
    }
}
