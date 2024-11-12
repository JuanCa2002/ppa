package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.ScaleApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.scale.ScaleRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.scale.ScaleResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.scale.ScaleMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.scale.CreateAllScaleUseCase;
import com.puntopago.ppa.infrastructure.ports.in.scale.FindByItineraryScaleUseCase;
import com.puntopago.ppa.infrastructure.ports.in.scale.RemoveScaleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${request-mapping.controller.scale}")
public class ScaleController implements ScaleApi {

    private final CreateAllScaleUseCase createAllScaleUseCase;

    private final RemoveScaleUseCase removeScaleUseCase;

    private final FindByItineraryScaleUseCase findByItineraryScaleUseCase;

    private final ScaleMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<List<ScaleResponse>> save(List<ScaleRequest> request) throws ApiException {
        var response = createAllScaleUseCase.createAll(mapperRest.requestsToDomains(request));
        return new ResponseEntity<>(mapperRest.domainsToResponses(response), HttpStatus.CREATED);
    }

    @GetMapping("/itinerary/{itineraryId}")
    @Override
    public ResponseEntity<List<ScaleResponse>> finByItinerary(@PathVariable Long itineraryId) {
        var response = findByItineraryScaleUseCase.execute(itineraryId);
        return new ResponseEntity<>(mapperRest.domainsToResponses(response), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Long id) throws ApiException {
        removeScaleUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
