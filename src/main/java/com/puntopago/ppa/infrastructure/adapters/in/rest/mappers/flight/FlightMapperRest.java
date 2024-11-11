package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.flight;

import com.puntopago.ppa.domain.filters.FlightFilter;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.FlightRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.UpdateFlightRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.filters.FlightRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight.FlightExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapperRest {

    @Mapping(target = "itinerary.id", source = "itineraryId")
    @Mapping(target = "airplane.id", source = "airplaneId")
    Flight requestToDomain(FlightRequest request);

    @Mapping(target = "itineraryId", source = "itinerary.id")
    @Mapping(target = "airplaneId", source = "airplane.id")
    FlightResponse domainToResponse(Flight domain);

    @Mapping(target = "airplane.id", source = "airplaneId")
    Flight updateRequestToDomain(UpdateFlightRequest request);

    FlightFilter rqFilterToFilter(FlightRqFilter filter);

    @Mapping(target = "itineraryId", source = "itinerary.id")
    @Mapping(target = "airplaneId", source = "airplane.id")
    @Mapping(target = "municipalityOriginName", source = "itinerary.origin.location.name")
    @Mapping(target = "municipalityDestinyName", source = "itinerary.destiny.location.name")
    @Mapping(target = "estimatedTime", source = "itinerary.estimatedTime")
    @Mapping(target = "unitTime", source = "itinerary.unitTime")
    FlightExtendResponse domainToExtendResponse(Flight domain);

    List<FlightExtendResponse> domainsToExtendResponses(List<Flight> domains);
}
