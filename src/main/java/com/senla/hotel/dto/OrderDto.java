package com.senla.hotel.dto;

import com.senla.hotel.model.entities.Order;
import com.senla.hotel.model.entities.enums.OrderStatus;

import java.time.LocalDate;

public class OrderDto {

    private Long id;
    private Long guest;
    private Long room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private OrderStatus status;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.id = order.getId();
        if(order.getGuest() != null){
            this.guest = order.getGuest().getId();
        }
        if (order.getRoom() != null){
            this.room = order.getRoom().getId();
        }
        this.checkIn = order.getCheckIn();
        this.checkOut = order.getCheckOut();
        this.status = order.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGuest() {
        return guest;
    }

    public void setGuest(Long guest) {
        this.guest = guest;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
