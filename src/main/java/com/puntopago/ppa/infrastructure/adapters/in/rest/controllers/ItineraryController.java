package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.ItineraryApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.itinerary.ItineraryRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.itinerary.UpdateItineraryRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary.ItineraryExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary.ItineraryResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.itinerary.ItineraryMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.itinerary.CreateItineraryUseCase;
import com.puntopago.ppa.infrastructure.ports.in.itinerary.FindByIdItineraryUseCase;
import com.puntopago.ppa.infrastructure.ports.in.itinerary.UpdateItineraryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${request-mapping.controller.itinerary}")
public class ItineraryController implements ItineraryApi {

    private final CreateItineraryUseCase createItineraryUseCase;

    private final UpdateItineraryUseCase updateItineraryUseCase;

    private final FindByIdItineraryUseCase findByIdItineraryUseCase;

    private final ItineraryMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<ItineraryResponse> save(ItineraryRequest request) throws ApiException {
        var response = createItineraryUseCase.execute(mapperRest.requestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ItineraryExtendResponse> findById(@PathVariable Long id) throws ApiException {
        var response = findByIdItineraryUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToExtendResponse(response), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<ItineraryResponse> update(UpdateItineraryRequest request) throws ApiException {
        var response = updateItineraryUseCase.execute(mapperRest.updateRequestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }
}
