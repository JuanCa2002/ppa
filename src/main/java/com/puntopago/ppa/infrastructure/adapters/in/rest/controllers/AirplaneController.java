package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;


import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.AirplaneApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.AirplaneRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.UpdateAirplaneRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.filters.AirplaneRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airplane.AirplaneResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.airplane.AirplaneMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.airplane.CreateAirplaneUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airplane.FindByCriteriaAirplaneUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airplane.FindByIdUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airplane.UpdateAirplaneUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airplane.UpdateStateAirplaneUseCase;
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
@RequestMapping("${request-mapping.controller.airplane}")
public class AirplaneController implements AirplaneApi {

    private final CreateAirplaneUseCase createAirplaneUseCase;

    private final UpdateStateAirplaneUseCase updateStateAirplaneUseCase;

    private final UpdateAirplaneUseCase updateAirplaneUseCase;

    private final FindByCriteriaAirplaneUseCase findByCriteriaAirplaneUseCase;

    private final FindByIdUseCase findByIdUseCase;

    private final AirplaneMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<AirplaneResponse> save(AirplaneRequest request) throws ApiException {
        var response = createAirplaneUseCase.execute(mapperRest.requestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<AirplaneResponse> updateState(@PathVariable Long id) throws ApiException {
        var response = updateStateAirplaneUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<PageResponse<List<AirplaneResponse>>> finByCriteria(AirplaneRqFilter filter) {
        var responses = findByCriteriaAirplaneUseCase.execute(mapperRest.rqFilterToFilter(filter));
        PageResponse<List<AirplaneResponse>> response = new PageResponse<>(mapperRest.domainsToResponses(responses.data()), responses.total());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AirplaneResponse> findById(@PathVariable Long id) throws ApiException {
        var response = findByIdUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<AirplaneResponse> update(UpdateAirplaneRequest request) throws ApiException {
        var response = updateAirplaneUseCase.execute(mapperRest.updateRequestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }
}
