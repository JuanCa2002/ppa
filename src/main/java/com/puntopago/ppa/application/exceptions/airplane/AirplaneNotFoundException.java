package com.puntopago.ppa.application.exceptions.airplane;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class AirplaneNotFoundException extends NotFoundException {

    public AirplaneNotFoundException() {
        super(AirplaneApiErrorMessages.AIRPLANE_NOT_FOUND);
    }
}
