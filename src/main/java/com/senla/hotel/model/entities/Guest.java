package com.senla.hotel.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest extends AEntity {
    public Guest() {
    }

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "guest")
    @JsonIgnore
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return id + ". Guest: " + name + ' ' + age + " age";
    }
}
