package com.senla.hotel.dto;

import com.senla.hotel.model.entities.Order;
import com.senla.hotel.model.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Long guest;
    private Long room;
    private String checkIn;
    private String checkOut;
    private OrderStatus status;

    public OrderDto(Order order) {
        this.id = order.getId();
        if(order.getGuest() != null){
            this.guest = order.getGuest().getId();
        }
        if (order.getRoom() != null){
            this.room = order.getRoom().getId();
        }
        this.checkIn = order.getCheckIn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.checkOut = order.getCheckOut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.status = order.getStatus();
    }
}
