package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.AirplaneRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.UpdateAirplaneRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.filters.AirplaneRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airplane.AirplaneResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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

@Tag(name = "Airplane", description = "Airplane Services")
public interface AirplaneApi {

    @Operation(summary = "Create new airplane", description = "Create a new register of an airplane")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Airplane created successfully", content = @Content(schema = @Schema(implementation = AirplaneResponse.class)))})
    ResponseEntity<AirplaneResponse> save(@Valid @RequestBody AirplaneRequest request) throws ApiException;

    @Operation(summary = "Update state of an airplane", description = "Update the state of an existing airplane")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Airplane State updated successfully", content = @Content(schema = @Schema(implementation = AirplaneResponse.class)))})
    ResponseEntity<AirplaneResponse> updateState(@Min(value = 1)
                                                @Max(value = 999999999999999999L)
                                                @Schema(description = "Airplane unique id")
                                                Long id) throws ApiException;

    @Operation(summary = "Find a list of airplanes by criteria", description = "Search a paginated list of airplanes by criteria")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Paginated airplane list",  content ={ @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AirplaneResponse.class)))})})
    ResponseEntity<PageResponse<List<AirplaneResponse>>> finByCriteria(@Valid AirplaneRqFilter filter);

    @Operation(summary = "Find a airplane by id", description = "Find an existing airplane by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found airplane", content = @Content(schema = @Schema(implementation = AirplaneResponse.class)))})
    ResponseEntity<AirplaneResponse> findById(@Min(value = 1)
                                             @Max(value = 999999999999999999L)
                                             @Schema(description = "Airplane unique id")
                                             Long id) throws ApiException;

    @Operation(summary = "Update an airplane", description = "Update an existing airplane")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Airplane updated successfully", content = @Content(schema = @Schema(implementation = AirplaneResponse.class)))})
    ResponseEntity<AirplaneResponse> update(@Valid @RequestBody UpdateAirplaneRequest request) throws ApiException;

}
