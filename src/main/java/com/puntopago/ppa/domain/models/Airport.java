package com.puntopago.ppa.domain.models;

import com.puntopago.ppa.domain.enums.AirportState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airport {

    private Long id;

    private String name;

    private Municipality location;

    private String address;

    private AirportState state;
}
