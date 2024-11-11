package com.puntopago.ppa.application.usecases.airplane;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.infrastructure.ports.in.airplane.FindByIdUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindByIdUseCaseImpl implements FindByIdUseCase {

    private final AirplanePort port;

    @Transactional(readOnly = true)
    @Override
    public Airplane execute(Long id) throws ApiException {
        return port.findById(id);
    }
}
