package com.puntopago.ppa.infrastructure.ports.out.municipality;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Municipality;

import java.util.List;

public interface MunicipalityPort {

    Municipality save(Municipality municipality);

    Municipality update(Municipality municipality) throws ApiException;

    Municipality findById(Long id) throws ApiException;

    List<Municipality> findAllByCriteria( Long departmentId, State state, String name);
}
