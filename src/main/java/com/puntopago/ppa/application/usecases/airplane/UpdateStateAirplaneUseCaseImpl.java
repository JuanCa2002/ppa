package com.puntopago.ppa.application.usecases.airplane;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.infrastructure.ports.in.airplane.UpdateStateAirplaneUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateStateAirplaneUseCaseImpl implements UpdateStateAirplaneUseCase {

    private final AirplanePort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airplane execute(Long id) throws ApiException {
        Airplane foundAirplane = port.findById(id);
        foundAirplane.setState(foundAirplane.getState().equals(State.ACTIVE) ? State.INACTIVE: State.ACTIVE);
        return port.update(foundAirplane);
    }
}
