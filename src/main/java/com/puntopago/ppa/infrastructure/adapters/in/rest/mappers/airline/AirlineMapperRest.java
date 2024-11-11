package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.airline;

import com.puntopago.ppa.domain.filters.AirlineFilter;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline.AirlineRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline.filters.AirlineRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airline.AirlineResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirlineMapperRest {

    Airline requestToDomain(AirlineRequest request);

    AirlineResponse domainToResponse(Airline domain);

    List<AirlineResponse> domainsToResponses(List<Airline> domains);

    AirlineFilter rqFilterToFilter(AirlineRqFilter rqFilter);
}
