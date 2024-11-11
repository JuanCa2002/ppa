package com.puntopago.ppa.application.usecases.airline;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.infrastructure.ports.in.airline.UpdateStateAirlineUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airline.AirlinePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateStateAirlineUseCaseImpl implements UpdateStateAirlineUseCase {

    private final AirlinePort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airline execute(Long id) throws ApiException {
        Airline foundAirline = port.findById(id);
        foundAirline.setState(foundAirline.getState().equals(State.ACTIVE) ? State.INACTIVE: State.ACTIVE);
        return port.update(foundAirline);
    }
}
