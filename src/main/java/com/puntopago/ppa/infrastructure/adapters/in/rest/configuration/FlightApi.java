package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.FlightRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.UpdateFlightRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.filters.FlightRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight.FlightExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight.FlightResponse;
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

@Tag(name = "Flight", description = "Flight Services")
public interface FlightApi {

    @Operation(summary = "Create new flight", description = "Create a new register of a flight")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Flight created successfully", content = @Content(schema = @Schema(implementation = FlightResponse.class)))})
    ResponseEntity<FlightResponse> save(@Valid @RequestBody FlightRequest request) throws ApiException;

    @Operation(summary = "Find a flight by id", description = "Find an existing flight by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found flight", content = @Content(schema = @Schema(implementation = FlightResponse.class)))})
    ResponseEntity<FlightResponse> findById(@Min(value = 1)
                                             @Max(value = 999999999999999999L)
                                             @Schema(description = "Flight unique id")
                                             Long id) throws ApiException;


    @Operation(summary = "Update an flight", description = "Update an existing flight")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Flight updated successfully", content = @Content(schema = @Schema(implementation = FlightResponse.class)))})
    ResponseEntity<FlightResponse> update(@Valid @RequestBody UpdateFlightRequest request) throws ApiException;

    @Operation(summary = "Update state of an flight", description = "Update the state of an existing flight")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Flight State updated successfully", content = @Content(schema = @Schema(implementation = FlightResponse.class)))})
    ResponseEntity<FlightResponse> updateState(@Min(value = 1)
                                                      @Max(value = 999999999999999999L)
                                                      @Schema(description = "Flight unique id")
                                                      Long id,
                                                      @NotNull
                                                      @Size(min = 1, max = 20)
                                                      @Pattern(
                                                              regexp = "^(SCHEDULED|BOARDING|AT_GATE|DELAYED|CANCELLED|POSTPONED|IN_FLIGHT|DIVERTED|LANDED|AT_GATE_ARRIVAL|ON_HOLD|DEPARTED|RETURN_TO_GATE|FINAL_CALL|ARRIVED|UNKNOWN)$",
                                                              message = ": must be one of the following values - SCHEDULED, BOARDING, AT_GATE, DELAYED, CANCELLED, POSTPONED, IN_FLIGHT, DIVERTED, LANDED, AT_GATE_ARRIVAL, ON_HOLD, DEPARTED, RETURN_TO_GATE, FINAL_CALL, ARRIVED, UNKNOWN"
                                                      )
                                                      @Schema(description = "Flight state", defaultValue = "SCHEDULED")
                                                      @RequestParam(value = "state", defaultValue = "SCHEDULED", required = true) String state) throws ApiException;


    @Operation(summary = "Find a list of flights by criteria", description = "Search a paginated list of flights by criteria")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Paginated flight list",  content ={ @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FlightExtendResponse.class)))})})
    ResponseEntity<PageResponse<List<FlightExtendResponse>>> finByCriteria(@Valid FlightRqFilter filter);
}
