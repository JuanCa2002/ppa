package com.puntopago.ppa.infrastructure.ports.out.airplane;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface AirplanePort {

    Airplane save(Airplane airplane);

    Airplane update(Airplane airplane) throws ApiException;

    Airplane findById(Long id) throws ApiException;

    PageModel<List<Airplane>> findByCriteria(String branch, Integer model, State state, Integer airlineId,Integer rowsPerPage, Integer skip);
}
