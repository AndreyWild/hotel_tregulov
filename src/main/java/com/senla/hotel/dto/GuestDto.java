package com.senla.hotel.dto;


import com.senla.hotel.model.entities.Guest;

public class GuestDto {

    private Long id;
    private String name;
    private Integer age;

    public GuestDto() {
    }

    public GuestDto(Guest guest) {
        this.id = guest.getId();
        this.name = guest.getName();
        this.age = guest.getAge();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
