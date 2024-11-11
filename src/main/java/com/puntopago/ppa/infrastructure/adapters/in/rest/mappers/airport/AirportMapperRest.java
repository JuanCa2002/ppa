package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.airport;

import com.puntopago.ppa.domain.filters.AirportFilter;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.AirportRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.UpdateAirportRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.filters.AirportRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport.AirportExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport.AirportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapperRest {

    @Mapping(target = "location.id", source = "locationId")
    Airport requestToDomain(AirportRequest request);

    Airport updateRequestToDomain(UpdateAirportRequest request);

    @Mapping(target = "locationId", source = "location.id")
    AirportResponse domainToResponse(Airport domain);

    @Mapping(target = "locationId", source = "location.id")
    @Mapping(target = "departmentId", source = "location.department.id")
    @Mapping(target = "locationName", source = "location.name")
    @Mapping(target = "departmentName", source = "location.department.name")
    AirportExtendResponse domainToExtendResponse(Airport domain);

    List<AirportExtendResponse> domainsToResponses(List<Airport> domains);

    AirportFilter rqFilterToFilter(AirportRqFilter rqFilter);
}
