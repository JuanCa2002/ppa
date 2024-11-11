package com.puntopago.ppa.application.usecases.airport;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.AirportState;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.infrastructure.ports.in.airport.UpdateStateAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateStateAirportUseCaseImpl implements UpdateStateAirportUseCase {

    private final AirportPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airport execute(Long id, AirportState state) throws ApiException {
        Airport foundAirport = port.findById(id);
        foundAirport.setState(state);
        return port.update(foundAirport);
    }
}
