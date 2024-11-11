package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.airplane;

import com.puntopago.ppa.domain.filters.AirplaneFilter;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.AirplaneRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.UpdateAirplaneRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.filters.AirplaneRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airplane.AirplaneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirplaneMapperRest {

    @Mapping(target = "airline.id", source = "airlineId")
    Airplane requestToDomain(AirplaneRequest request);

    Airplane updateRequestToDomain(UpdateAirplaneRequest request);

    AirplaneFilter rqFilterToFilter(AirplaneRqFilter rqFilter);

    AirplaneResponse domainToResponse(Airplane domain);

    List<AirplaneResponse> domainsToResponses(List<Airplane> domains);
}
