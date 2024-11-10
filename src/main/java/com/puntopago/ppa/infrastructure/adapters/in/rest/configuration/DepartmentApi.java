package com.puntopago.ppa.infrastructure.adapters.in.rest.configuration;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.DepartmentRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.UpdateDepartmentRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.filters.DepartmentRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.PageResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.department.DepartmentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Department", description = "Department Services")
public interface DepartmentApi {

    @Operation(summary = "Create new department", description = "Create a new register of department")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Department created successfully", content = @Content(schema = @Schema(implementation = DepartmentResponse.class)))})
    ResponseEntity<DepartmentResponse> save(@Valid @RequestBody DepartmentRequest request);

    @Operation(summary = "Update state of a department", description = "Update the state of an existing department")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Department State updated successfully", content = @Content(schema = @Schema(implementation = DepartmentResponse.class)))})
    ResponseEntity<DepartmentResponse> updateState(Long id) throws ApiException;

    @Operation(summary = "Update a department", description = "Update an existing department")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Department updated successfully", content = @Content(schema = @Schema(implementation = DepartmentResponse.class)))})
    ResponseEntity<DepartmentResponse> update(@Valid @RequestBody UpdateDepartmentRequest request) throws ApiException;


    @Operation(summary = "Find a list of departments by criteria", description = "Search a paginated list of departments by criteria")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Paginated department list",  content ={ @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DepartmentResponse.class)))})})
    ResponseEntity<PageResponse<List<DepartmentResponse>>> finByCriteria(@Valid DepartmentRqFilter filter);
}
