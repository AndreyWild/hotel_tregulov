package com.senla.hotel.model.entities.enums;

public enum RoomStatus {
    OPEN("OPEN"), CLOSED("CLOSED"), REPAIR("CLOSED");

    private String value;

    RoomStatus(String status) {
        this.value = status;
    }

    public String getValue() {
        return this.value;
    }
}
