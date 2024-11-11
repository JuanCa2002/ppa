package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.AirportState;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.AirportApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.AirportRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.UpdateAirportRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.filters.AirportRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport.AirportExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport.AirportResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.airport.AirportMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.airport.CreateAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airport.FindByCriteriaAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airport.FindByIdAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airport.UpdateAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airport.UpdateStateAirportUseCase;
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
@RequestMapping("${request-mapping.controller.airport}")
public class AirportController implements AirportApi {

    private final CreateAirportUseCase createAirportUseCase;

    private final FindByIdAirportUseCase findByIdAirportUseCase;

    private final UpdateAirportUseCase updateAirportUseCase;

    private final UpdateStateAirportUseCase updateStateAirportUseCase;

    private final FindByCriteriaAirportUseCase findByCriteriaAirportUseCase;

    private final AirportMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<AirportResponse> save(AirportRequest request) throws ApiException {
        var response = createAirportUseCase.execute(mapperRest.requestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AirportExtendResponse> findById(@PathVariable Long id) throws ApiException {
        var response = findByIdAirportUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToExtendResponse(response), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<AirportExtendResponse> update(UpdateAirportRequest request) throws ApiException {
        var response = updateAirportUseCase.execute(mapperRest.updateRequestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToExtendResponse(response), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<AirportExtendResponse> updateState(@PathVariable Long id, String state) throws ApiException {
        var response = updateStateAirportUseCase.execute(id, AirportState.valueOf(state));
        return new ResponseEntity<>(mapperRest.domainToExtendResponse(response), HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<PageResponse<List<AirportExtendResponse>>> finByCriteria(AirportRqFilter filter) {
        var responses = findByCriteriaAirportUseCase.execute(mapperRest.rqFilterToFilter(filter));
        PageResponse<List<AirportExtendResponse>> response = new PageResponse<>(mapperRest.domainsToResponses(responses.data()), responses.total());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
