package com.puntopago.ppa.application.exceptions.scale;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class ScaleNotFoundException extends NotFoundException {

    public ScaleNotFoundException() {
        super(ScaleApiErrorMessages.SCALE_NOT_FOUND);
    }
}
