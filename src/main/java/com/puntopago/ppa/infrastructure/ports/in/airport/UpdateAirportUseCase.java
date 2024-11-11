package com.puntopago.ppa.infrastructure.ports.in.airport;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airport;

public interface UpdateAirportUseCase {

    Airport execute(Airport airport) throws ApiException;
}
