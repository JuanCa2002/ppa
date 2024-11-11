package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline.AirlineRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline.filters.AirlineRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airline.AirlineResponse;
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

@Tag(name = "Airline", description = "Airline Services")
public interface AirlineApi {

    @Operation(summary = "Create new airline", description = "Create a new register of an airline")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Airline created successfully", content = @Content(schema = @Schema(implementation = AirlineResponse.class)))})
    ResponseEntity<AirlineResponse> save(@Valid @RequestBody AirlineRequest request);

    @Operation(summary = "Update state of an airline", description = "Update the state of an existing airline")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Airline State updated successfully", content = @Content(schema = @Schema(implementation = AirlineResponse.class)))})
    ResponseEntity<AirlineResponse> updateState(@Min(value = 1)
                                                   @Max(value = 999999999999999999L)
                                                   @Schema(description = "Airline unique id")
                                                   Long id) throws ApiException;

    @Operation(summary = "Find a list of airlines by criteria", description = "Search a paginated list of airlines by criteria")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Paginated airline list",  content ={ @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AirlineResponse.class)))})})
    ResponseEntity<PageResponse<List<AirlineResponse>>> finByCriteria(@Valid AirlineRqFilter filter);

    @Operation(summary = "Find a airline by id", description = "Find an existing airline by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found airline", content = @Content(schema = @Schema(implementation = AirlineResponse.class)))})
    ResponseEntity<AirlineResponse> findById(@Min(value = 1)
                                                @Max(value = 999999999999999999L)
                                                @Schema(description = "Airline unique id")
                                                Long id) throws ApiException;

}
