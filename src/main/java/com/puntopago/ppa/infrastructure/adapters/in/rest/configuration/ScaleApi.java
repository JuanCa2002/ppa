package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.filters.FlightRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.scale.ScaleRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight.FlightExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.scale.ScaleResponse;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Validated
@Tag(name = "Scale", description = "Scale Services")
public interface ScaleApi {

    @Operation(summary = "Create new list of scales", description = "Create a new list of a scales for an itinerary")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "List of scales created successfully", content ={ @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ScaleResponse.class)))})})
    ResponseEntity<List<ScaleResponse>> save(@Valid @RequestBody List<@Valid ScaleRequest> request) throws ApiException;

    @Operation(summary = "Find a list of scales by itinerary", description = "Search a list of scales by itinerary id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Scale list by itinerary",  content ={ @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ScaleResponse.class)))})})
    ResponseEntity<List<ScaleResponse>> finByItinerary(@Min(value = 1)
                                                      @Max(value = 999999999999999999L)
                                                      @Schema(description = "Itinerary unique id")
                                                      Long itineraryId);

    @Operation(summary = "Remove Scale", description = "Remove Scale by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Scale removed successfully")})
    ResponseEntity<Void> remove(@Min(value = 1)
                                @Max(value = 999999999999999999L)
                                @Schema(description = "Scale unique id")
                                Long id) throws ApiException;
}
