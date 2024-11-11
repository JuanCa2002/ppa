package com.puntopago.ppa.application.exceptions.flight;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class FlightNotFoundException extends NotFoundException {

    public FlightNotFoundException() {
        super(FlightApiErrorMessages.FLIGHT_NOT_FOUND);
    }
}
