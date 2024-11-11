package com.puntopago.ppa.application.usecases.airplane;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.infrastructure.ports.in.airplane.UpdateAirplaneUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateAirplaneUseCaseImpl implements UpdateAirplaneUseCase {

    private final AirplanePort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airplane execute(Airplane airplane) throws ApiException {
        return port.update(airplane);
    }
}
