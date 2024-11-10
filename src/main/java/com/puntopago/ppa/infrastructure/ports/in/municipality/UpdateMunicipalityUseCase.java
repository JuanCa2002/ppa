package com.puntopago.ppa.infrastructure.ports.in.municipality;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Municipality;

public interface UpdateMunicipalityUseCase {

    Municipality execute(Municipality municipality) throws ApiException;
}
