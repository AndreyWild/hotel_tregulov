package com.senla.hotel.dto;

import com.senla.hotel.model.entities.AEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestDto extends AEntity {

    private String name;
    private Integer age;
}
