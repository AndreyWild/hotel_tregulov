package com.senla.hotel.dto;

import com.senla.hotel.model.entities.Maintenance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaintenanceDto {

    private Long id;
    private String name;
    private Double price;

    public MaintenanceDto(Maintenance maintenance) {
        this.id = maintenance.getId();
        this.name = maintenance.getName();
        this.price = maintenance.getPrice();
    }
}
