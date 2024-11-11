package com.puntopago.ppa.infrastructure.ports.in.airport;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.AirportState;
import com.puntopago.ppa.domain.models.Airport;

public interface UpdateStateAirportUseCase {

    Airport execute(Long id, AirportState state) throws ApiException;
}
