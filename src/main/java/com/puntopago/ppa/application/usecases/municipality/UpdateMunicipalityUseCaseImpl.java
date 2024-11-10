package com.puntopago.ppa.application.usecases.municipality;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.ports.in.municipality.UpdateMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.out.municipality.MunicipalityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateMunicipalityUseCaseImpl implements UpdateMunicipalityUseCase {

    private final MunicipalityPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Municipality execute(Municipality municipality) throws ApiException {
        return port.update(municipality);
    }
}
