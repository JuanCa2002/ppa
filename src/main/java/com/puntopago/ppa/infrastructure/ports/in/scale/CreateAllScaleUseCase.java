package com.puntopago.ppa.infrastructure.ports.in.scale;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Scale;

import java.util.List;

public interface CreateAllScaleUseCase {

    List<Scale> createAll(List<Scale> scales) throws ApiException;
}
