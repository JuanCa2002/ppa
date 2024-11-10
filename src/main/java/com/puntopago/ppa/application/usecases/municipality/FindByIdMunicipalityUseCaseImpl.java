package com.puntopago.ppa.application.usecases.municipality;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.ports.in.municipality.FindByIdMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.out.municipality.MunicipalityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindByIdMunicipalityUseCaseImpl implements FindByIdMunicipalityUseCase {

    private final MunicipalityPort port;

    @Transactional(readOnly = true)
    @Override
    public Municipality execute(Long id) throws ApiException {
        return port.findById(id);
    }
}
