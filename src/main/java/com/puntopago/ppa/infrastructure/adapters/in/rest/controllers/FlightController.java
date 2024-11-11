package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.FlightState;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.FlightApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.FlightRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.UpdateFlightRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.filters.FlightRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight.FlightExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight.FlightResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.flight.FlightMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.flight.CreateFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.in.flight.FindByCriteriaFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.in.flight.FindByIdFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.in.flight.UpdateFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.in.flight.UpdateStateFlightUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${request-mapping.controller.flight}")
public class FlightController implements FlightApi {

    private final CreateFlightUseCase createFlightUseCase;

    private final UpdateFlightUseCase updateFlightUseCase;

    private final FindByIdFlightUseCase findByIdFlightUseCase;

    private final UpdateStateFlightUseCase updateStateFlightUseCase;

    private final FindByCriteriaFlightUseCase findByCriteriaFlightUseCase;

    private final FlightMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<FlightResponse> save(FlightRequest request) throws ApiException {
        var response = createFlightUseCase.execute(mapperRest.requestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<FlightResponse> findById(@PathVariable Long id) throws ApiException {
        var response = findByIdFlightUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<FlightResponse> update(UpdateFlightRequest request) throws ApiException {
        var response = updateFlightUseCase.execute(mapperRest.updateRequestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<FlightResponse> updateState(@PathVariable Long id, String state) throws ApiException {
        var response = updateStateFlightUseCase.execute(id, FlightState.valueOf(state));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<PageResponse<List<FlightExtendResponse>>> finByCriteria(FlightRqFilter filter) {
        var result = findByCriteriaFlightUseCase.execute(mapperRest.rqFilterToFilter(filter));
        PageResponse<List<FlightExtendResponse>> response = new PageResponse<>(mapperRest.domainsToExtendResponses(result.data()), result.total());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
