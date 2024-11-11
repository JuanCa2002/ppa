package com.puntopago.ppa.infrastructure.ports.out.airline;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface AirlinePort {

    Airline save(Airline airline);

    Airline update(Airline airline) throws ApiException;

    Airline findById(Long id) throws ApiException;

    PageModel<List<Airline>> findByCriteria(String name, State state, Integer rowsPerPage, Integer skip);
}
