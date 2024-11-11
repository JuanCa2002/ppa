package com.puntopago.ppa.infrastructure.ports.out.airport;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.AirportState;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface AirportPort {

    Airport save(Airport airport);

    Airport findById(Long id) throws ApiException;

    Airport update(Airport airport) throws ApiException;

    PageModel<List<Airport>> findByCriteria(String name, Long locationId, Long departmentId, AirportState state,
                                            Integer rowsPerPage, Integer skip);
}
