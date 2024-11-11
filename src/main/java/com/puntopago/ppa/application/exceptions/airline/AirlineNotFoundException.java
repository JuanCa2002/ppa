package com.puntopago.ppa.application.exceptions.airline;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class AirlineNotFoundException extends NotFoundException {

    public AirlineNotFoundException() {
        super(AirlineApiErrorMessages.AIRLINE_NOT_FOUND);
    }
}
