package com.puntopago.ppa.application.exceptions.municipality;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class MunicipalityNotFoundException extends NotFoundException {

    public MunicipalityNotFoundException() {
        super(MunicipalityApiErrorMessages.MUNICIPALITY_NOT_FOUND);
    }
}
