package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.itinerary.ItineraryRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.itinerary.UpdateItineraryRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary.ItineraryExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary.ItineraryResponse;
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

@Tag(name = "Itinerary", description = "Itinerary Services")
public interface ItineraryApi {

    @Operation(summary = "Create new itinerary", description = "Create a new register of an itinerary")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Itinerary created successfully", content = @Content(schema = @Schema(implementation = ItineraryResponse.class)))})
    ResponseEntity<ItineraryResponse> save(@Valid @RequestBody ItineraryRequest request) throws ApiException;

    @Operation(summary = "Find a itinerary by id", description = "Find an existing itinerary by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found itinerary", content = @Content(schema = @Schema(implementation = ItineraryResponse.class)))})
    ResponseEntity<ItineraryExtendResponse> findById(@Min(value = 1)
                                             @Max(value = 999999999999999999L)
                                             @Schema(description = "Itinerary unique id")
                                             Long id) throws ApiException;

    @Operation(summary = "Update an itinerary", description = "Update an existing itinerary")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Itinerary updated successfully", content = @Content(schema = @Schema(implementation = ItineraryResponse.class)))})
    ResponseEntity<ItineraryResponse> update(@Valid @RequestBody UpdateItineraryRequest request) throws ApiException;

    @Operation(summary = "Find a itinerary by flight id", description = "Find an existing itinerary by flight id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found itinerary", content = @Content(schema = @Schema(implementation = ItineraryResponse.class)))})
    ResponseEntity<ItineraryExtendResponse> findByFlight(@Min(value = 1)
                                                     @Max(value = 999999999999999999L)
                                                     @Schema(description = "Flight unique id")
                                                     Long flightId) throws ApiException;
}
