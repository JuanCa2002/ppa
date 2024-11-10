package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.MunicipalityRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.UpdateMunicipalityRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.filters.MunicipalityRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.municipality.MunicipalityResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Municipality", description = "Municipality Services")
public interface MunicipalityApi {

    @Operation(summary = "Create new municipality", description = "Create a new register of municipality")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Municipality created successfully", content = @Content(schema = @Schema(implementation = MunicipalityResponse.class)))})
    ResponseEntity<MunicipalityResponse> save(@Valid @RequestBody MunicipalityRequest request) throws ApiException;

    @Operation(summary = "Update a municipality", description = "Update an existing municipality")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Municipality updated successfully", content = @Content(schema = @Schema(implementation = MunicipalityResponse.class)))})
    ResponseEntity<MunicipalityResponse> update(@Valid @RequestBody UpdateMunicipalityRequest request) throws ApiException;

    @Operation(summary = "Update state of a municipality", description = "Update the state of an existing municipality")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Municipality State updated successfully", content = @Content(schema = @Schema(implementation = MunicipalityResponse.class)))})
    ResponseEntity<MunicipalityResponse> updateState(@Min(value = 1)
                                                     @Max(value = 999999999999999999L)
                                                     @Schema(description = "Municipality unique id")
                                                     Long id) throws ApiException;

    @Operation(summary = "Find a municipality by id", description = "Find an existing municipality by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found Municipality", content = @Content(schema = @Schema(implementation = MunicipalityResponse.class)))})
    ResponseEntity<MunicipalityResponse> findById( @Min(value = 1)
                                                   @Max(value = 999999999999999999L)
                                                   @Schema(description = "Municipality unique id")
                                                   Long id) throws ApiException;


    @Operation(summary = "Find a list of municipalities", description = "Find a list of municipalities")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of municipalities", content = @Content(schema = @Schema(implementation = MunicipalityResponse.class)))})
    ResponseEntity<List<MunicipalityResponse>> findByCriteria(@Valid MunicipalityRqFilter filter);
}
