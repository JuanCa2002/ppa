package com.puntopago.ppa.application.usecases.airline;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.infrastructure.ports.in.airline.CreateAirlineUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airline.AirlinePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateAirlineUseCaseImpl implements CreateAirlineUseCase {

    private final AirlinePort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airline execute(Airline airline) {
        airline.setId(null);
        airline.setState(State.ACTIVE);
        return port.save(airline);
    }
}
