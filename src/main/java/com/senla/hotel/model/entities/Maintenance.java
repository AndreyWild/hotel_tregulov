package com.senla.hotel.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "maintenances")
public class Maintenance extends AEntity {
    public Maintenance() {
    }

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    public Maintenance(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Maintenance(Maintenance maintenance) {
        setId(maintenance.getId());
        this.name = maintenance.getName();
        this.price = maintenance.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ". Maintenance: " + name + ' ' + price + '$';
    }
}
