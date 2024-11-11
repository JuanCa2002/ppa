package com.puntopago.ppa.infrastructure.ports.in.flight;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.FlightState;
import com.puntopago.ppa.domain.models.Flight;

public interface UpdateStateFlightUseCase {

    Flight execute(Long id, FlightState state) throws ApiException;
}
