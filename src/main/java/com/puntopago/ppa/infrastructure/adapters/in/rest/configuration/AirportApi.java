package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.AirportRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.UpdateAirportRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.filters.AirportRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport.AirportExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport.AirportResponse;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Airport", description = "Airport Services")
public interface AirportApi {

    @Operation(summary = "Create new airport", description = "Create a new register of an airport")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Airport created successfully", content = @Content(schema = @Schema(implementation = AirportResponse.class)))})
    ResponseEntity<AirportResponse> save(@Valid @RequestBody AirportRequest request) throws ApiException;

    @Operation(summary = "Find an airport by id", description = "Find an existing airport by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found airport", content = @Content(schema = @Schema(implementation = AirportExtendResponse.class)))})
    ResponseEntity<AirportExtendResponse> findById(@Min(value = 1)
                                             @Max(value = 999999999999999999L)
                                             @Schema(description = "Airport unique id")
                                             Long id) throws ApiException;

    @Operation(summary = "Update an airport", description = "Update an existing airport")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Airport updated successfully", content = @Content(schema = @Schema(implementation = AirportExtendResponse.class)))})
    ResponseEntity<AirportExtendResponse> update(@Valid @RequestBody UpdateAirportRequest request) throws ApiException;

    @Operation(summary = "Update state of an airport", description = "Update the state of an existing airport")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Airport State updated successfully", content = @Content(schema = @Schema(implementation = AirportExtendResponse.class)))})
    ResponseEntity<AirportExtendResponse> updateState(@Min(value = 1)
                                                @Max(value = 999999999999999999L)
                                                @Schema(description = "Airport unique id")
                                                Long id,
                                                @NotNull
                                                @Pattern(regexp = "^(OUT_OF_SERVICE|ALLOWED|BUSY)$", message = ": has to be OUT_OF_SERVICE, ALLOWED or BUSY")
                                                @Size(min = 1, max = 15)
                                                @Schema(description = "Airport state", defaultValue = "ALLOWED")
                                                @RequestParam(value = "state", defaultValue = "ALLOWED", required = true) String state) throws ApiException;

    @Operation(summary = "Find a list of airports by criteria", description = "Search a paginated list of airports by criteria")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Paginated airport list",  content ={ @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AirportExtendResponse.class)))})})
    ResponseEntity<PageResponse<List<AirportExtendResponse>>> finByCriteria(@Valid AirportRqFilter filter);
}
