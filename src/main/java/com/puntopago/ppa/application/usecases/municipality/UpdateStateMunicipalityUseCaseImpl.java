package com.puntopago.ppa.application.usecases.municipality;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.ports.in.municipality.UpdateStateMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.out.municipality.MunicipalityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateStateMunicipalityUseCaseImpl implements UpdateStateMunicipalityUseCase {

    private final MunicipalityPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Municipality execute(Long id) throws ApiException {
        Municipality foundMunicipality = port.findById(id);
        foundMunicipality.setState(foundMunicipality.getState().equals(State.ACTIVE) ? State.INACTIVE : State.ACTIVE);
        return port.update(foundMunicipality);
    }

}
