package com.senla.hotel.dto;

import com.senla.hotel.model.entities.AEntity;
import com.senla.hotel.model.entities.Guest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestDto extends AEntity {

    private String name;
    private Integer age;

//    public GuestDto(Guest guest) {
//        this.id = guest.getId();
//        this.name = guest.getName();
//        this.age = guest.getAge();
//    }
}
