package com.senla.hotel.dto;

import com.senla.hotel.model.entities.Maintenance;


public class MaintenanceDto {

    private Long id;
    private String name;
    private Double price;

    public MaintenanceDto() {
    }

    public MaintenanceDto(Maintenance maintenance) {
        this.id = maintenance.getId();
        this.name = maintenance.getName();
        this.price = maintenance.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
