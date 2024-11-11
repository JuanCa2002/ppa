package com.puntopago.ppa.application.usecases.flight;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.FlightState;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.infrastructure.ports.in.flight.UpdateStateFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.out.flight.FlightPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateStateFlightUseCaseImpl implements UpdateStateFlightUseCase {

    private final FlightPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Flight execute(Long id, FlightState state) throws ApiException {
        Flight currentFlight = port.findById(id);
        currentFlight.setState(state);
        return port.save(currentFlight);
    }
}
