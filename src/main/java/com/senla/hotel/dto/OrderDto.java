package com.senla.hotel.dto;

import com.senla.hotel.model.entities.AEntity;
import com.senla.hotel.model.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto extends AEntity {

    private GuestDto guest;
    private RoomDto room;
    private String checkIn;
    private String checkOut;
    private OrderStatus status;
}
