package com.puntopago.ppa.application.exceptions.airport;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class AirportNotFoundException extends NotFoundException {

    public AirportNotFoundException() {
        super(AirportApiErrorMessages.AIRPORT_NOT_FOUND);
    }
}
