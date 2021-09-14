package com.senla.hotel.dto;

import com.senla.hotel.model.entities.AEntity;
import com.senla.hotel.model.entities.Room;
import com.senla.hotel.model.entities.enums.RoomStars;
import com.senla.hotel.model.entities.enums.RoomStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomDto extends AEntity {

    private Integer number;
    private Integer capacity;
    private RoomStatus status;
    private Double price;
    private RoomStars stars;

    public RoomDto(Room room) {
        this.id = room.getId();
        this.number = room.getNumber();
        this.capacity = room.getCapacity();
        this.status = room.getStatus();
        this.price = room.getPrice();
        this.stars = room.getStars();
    }
}
