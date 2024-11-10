package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.MunicipalityApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.MunicipalityRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.UpdateMunicipalityRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.filters.MunicipalityRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.municipality.MunicipalityResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.municipality.MunicipalityMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.municipality.CreateMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.in.municipality.FindAllCriteriaMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.in.municipality.FindByIdMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.in.municipality.UpdateMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.in.municipality.UpdateStateMunicipalityUseCase;
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
@RequestMapping("${request-mapping.controller.municipality}")
public class MunicipalityController implements MunicipalityApi {

    private final CreateMunicipalityUseCase createMunicipalityUseCase;

    private final UpdateMunicipalityUseCase updateMunicipalityUseCase;

    private final UpdateStateMunicipalityUseCase updateStateMunicipalityUseCase;

    private final FindByIdMunicipalityUseCase findByIdMunicipalityUseCase;

    private final FindAllCriteriaMunicipalityUseCase findAllCriteriaMunicipalityUseCase;

    private final MunicipalityMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<MunicipalityResponse> save(MunicipalityRequest request) throws ApiException {
        var response = createMunicipalityUseCase.execute(mapperRest.requestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.CREATED);
    }

    @PutMapping
    @Override
    public ResponseEntity<MunicipalityResponse> update(UpdateMunicipalityRequest request) throws ApiException {
        var response = updateMunicipalityUseCase.execute(mapperRest.updateRequestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<MunicipalityResponse> updateState(@PathVariable Long id) throws ApiException {
        var response = updateStateMunicipalityUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<MunicipalityResponse> findById(@PathVariable Long id) throws ApiException {
        var response = findByIdMunicipalityUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<MunicipalityResponse>> findByCriteria(MunicipalityRqFilter filter) {
        var response = findAllCriteriaMunicipalityUseCase.execute(mapperRest.rqFilterToFilter(filter));
        return new ResponseEntity<>(mapperRest.domainsToResponses(response), HttpStatus.OK);
    }
}
