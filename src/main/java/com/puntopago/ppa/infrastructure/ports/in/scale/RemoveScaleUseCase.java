package com.puntopago.ppa.infrastructure.ports.in.scale;

import com.puntopago.ppa.application.exceptions.general.ApiException;

public interface RemoveScaleUseCase {

    void execute(Long id) throws ApiException;
}
