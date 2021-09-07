package com.senla.hotel.model.entities.enums;

public enum RoomStars {
    ONE("ONE"), TWO("TWO"), THREE("THREE"), FOUR("FOUR"), FIVE("FIVE");

    private String value;

    RoomStars(String status) {
        this.value = status;
    }

    public String getValue() {
        return this.value;
    }
}
