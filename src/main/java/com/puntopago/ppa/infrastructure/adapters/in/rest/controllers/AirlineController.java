package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.AirlineApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline.AirlineRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline.filters.AirlineRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airline.AirlineResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.airline.AirlineMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.airline.CreateAirlineUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airline.FindByCriteriaAirlineUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airline.FindByIdAirlineUseCase;
import com.puntopago.ppa.infrastructure.ports.in.airline.UpdateStateAirlineUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${request-mapping.controller.airline}")
public class AirlineController implements AirlineApi {

    private final CreateAirlineUseCase createAirlineUseCase;

    private final UpdateStateAirlineUseCase updateStateAirlineUseCase;

    private final FindByCriteriaAirlineUseCase findByCriteriaAirlineUseCase;

    private final FindByIdAirlineUseCase findByIdAirlineUseCase;

    private final AirlineMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<AirlineResponse> save(AirlineRequest request) {
        var response = createAirlineUseCase.execute(mapperRest.requestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<AirlineResponse> updateState(@PathVariable Long id) throws ApiException {
        var response = updateStateAirlineUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<PageResponse<List<AirlineResponse>>> finByCriteria(AirlineRqFilter filter) {
        var responses = findByCriteriaAirlineUseCase.execute(mapperRest.rqFilterToFilter(filter));
        PageResponse<List<AirlineResponse>> response = new PageResponse<>(mapperRest.domainsToResponses(responses.data()), responses.total());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AirlineResponse> findById(@PathVariable Long id) throws ApiException {
        var response = findByIdAirlineUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }
}
