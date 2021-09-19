package com.senla.hotel.security.controller;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String login;

    private String password;
}
