package com.senla.hotel.dto;

import com.senla.hotel.model.entities.Room;
import com.senla.hotel.model.entities.enums.RoomStars;
import com.senla.hotel.model.entities.enums.RoomStatus;

public class RoomDto {

    private Long id;
    private Integer number;
    private Integer capacity;
    private RoomStatus status;
    private Double price;
    private RoomStars stars;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.number = room.getNumber();
        this.capacity = room.getCapacity();
        this.status = room.getStatus();
        this.price = room.getPrice();
        this.stars = room.getStars();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RoomStars getStars() {
        return stars;
    }

    public void setStars(RoomStars stars) {
        this.stars = stars;
    }
}
