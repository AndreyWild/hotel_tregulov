package com.senla.hotel.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private RoleValue role;


    public enum RoleValue{
        ADMINISTRATOR, GUEST;
    }
}
