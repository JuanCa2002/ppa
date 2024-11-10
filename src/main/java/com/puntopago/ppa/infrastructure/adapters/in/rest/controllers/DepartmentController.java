package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.configuration.DepartmentApi;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.DepartmentRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.UpdateDepartmentRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.filters.DepartmentRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.department.DepartmentResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.department.DepartmentMapperRest;
import com.puntopago.ppa.infrastructure.ports.in.department.CreateDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.in.department.FindByCriteriaDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.in.department.FindByIdDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.in.department.UpdateDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.in.department.UpdateStateDepartmentUseCase;
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
@RequestMapping("${request-mapping.controller.department}")
public class DepartmentController implements DepartmentApi {

    private final CreateDepartmentUseCase createDepartmentUseCase;

    private final UpdateStateDepartmentUseCase updateStateDepartmentUseCase;

    private final UpdateDepartmentUseCase updateDepartmentUseCase;

    private final FindByCriteriaDepartmentUseCase findByCriteriaDepartmentUseCase;

    private final FindByIdDepartmentUseCase findByIdDepartmentUseCase;

    private final DepartmentMapperRest mapperRest;

    @PostMapping
    @Override
    public ResponseEntity<DepartmentResponse> save(DepartmentRequest request) {
        var response = createDepartmentUseCase.execute(mapperRest.requestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<DepartmentResponse> updateState(@PathVariable Long id) throws ApiException {
        var response = updateStateDepartmentUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<DepartmentResponse> update(UpdateDepartmentRequest request) throws ApiException {
        var response = updateDepartmentUseCase.execute(mapperRest.updateRequestToDomain(request));
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<PageResponse<List<DepartmentResponse>>> finByCriteria(DepartmentRqFilter filter) {
        var result = findByCriteriaDepartmentUseCase.execute(mapperRest.rqFilterToDomain(filter));
        PageResponse<List<DepartmentResponse>> response = new PageResponse<>(mapperRest.domainsToResponses(result.data()), result.total());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DepartmentResponse> findById(@PathVariable Long id) throws ApiException {
        var response = findByIdDepartmentUseCase.execute(id);
        return new ResponseEntity<>(mapperRest.domainToResponse(response), HttpStatus.OK);
    }
}
