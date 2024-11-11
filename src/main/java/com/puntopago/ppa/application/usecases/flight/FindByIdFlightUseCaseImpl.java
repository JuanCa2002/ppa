package com.puntopago.ppa.application.usecases.flight;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.infrastructure.ports.in.flight.FindByIdFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.out.flight.FlightPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindByIdFlightUseCaseImpl implements FindByIdFlightUseCase {

    private final FlightPort flightPort;

    @Transactional(readOnly = true)
    @Override
    public Flight execute(Long id) throws ApiException {
        return flightPort.findById(id);
    }
}
