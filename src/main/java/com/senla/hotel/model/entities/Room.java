package com.senla.hotel.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senla.hotel.model.entities.enums.RoomStars;
import com.senla.hotel.model.entities.enums.RoomStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room extends AEntity {

    @Column(name = "number")
    private Integer number;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "room_status")
    @Enumerated(EnumType.STRING)
    private RoomStatus status = RoomStatus.OPEN;

    @Column(name = "price")
    private Double price;

    @Column(name = "stars")
    @Enumerated(value = EnumType.STRING)
    private RoomStars stars = RoomStars.ONE;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "room")
    private List<Order> orders = new ArrayList<>();

    public Room(Integer number, Integer capacity, Double price, RoomStars stars) {
        this.number = number;
        this.capacity = capacity;
        this.price = price;
        this.stars = stars;
    }

    public Room(Room room) {
        setId(room.getId());
        this.number = room.getNumber();
        this.capacity = room.getCapacity();
        this.status = room.getStatus();
        this.price = room.getPrice();
        this.stars = room.getStars();
        this.orders = room.getOrders();
    }

    public void addOrdersToRoom(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        } else {
            orders.add(order);
            order.setRoom(this);
        }
    }

    @Override
    public String toString() {
        return id + ". Room: №" + number + ' ' + capacity + "-persons " + status + ' ' + price + "$ " + stars;
    }
}

