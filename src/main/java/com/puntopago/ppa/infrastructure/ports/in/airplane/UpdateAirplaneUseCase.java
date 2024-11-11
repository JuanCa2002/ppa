package com.puntopago.ppa.infrastructure.ports.in.airplane;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airplane;

public interface UpdateAirplaneUseCase {

    Airplane execute(Airplane airplane) throws ApiException;
}
