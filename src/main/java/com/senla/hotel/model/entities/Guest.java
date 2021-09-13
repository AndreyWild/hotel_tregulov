package com.senla.hotel.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "guests")
public class Guest extends AEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "guest")
    private List<Order> orders;

    public Guest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Guest(Guest guest) {
        setId(guest.getId());
        this.name = guest.getName();
        this.age = guest.getAge();
        this.orders = guest.getOrders();
    }

    public void addOrdersToGuest(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        } else {
            orders.add(order);
            order.setGuest(this);
        }
    }

    @Override
    public String toString() {
        return id + ". Guest: " + name + ' ' + age + " age";
    }
}
