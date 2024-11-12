package com.puntopago.ppa.application.usecases.scale;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.ports.in.scale.RemoveScaleUseCase;
import com.puntopago.ppa.infrastructure.ports.out.scale.ScalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveScaleUseCaseImpl implements RemoveScaleUseCase {

    private final ScalePort port;

    @Override
    public void execute(Long id) throws ApiException {
        port.delete(id);
    }
}
