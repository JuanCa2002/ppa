package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.itinerary;

import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.itinerary.ItineraryRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.itinerary.UpdateItineraryRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary.ItineraryExtendResponse;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary.ItineraryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItineraryMapperRest {

    @Mapping(target = "origin.id", source = "originId")
    @Mapping(target = "destiny.id", source = "destinyId")
    Itinerary requestToDomain(ItineraryRequest request);

    @Mapping(target = "destinyId", source = "destiny.id")
    @Mapping(target = "originId", source = "origin.id")
    ItineraryResponse domainToResponse(Itinerary domain);

    Itinerary updateRequestToDomain(UpdateItineraryRequest request);

    @Mapping(target = "destinyId", source = "destiny.id")
    @Mapping(target = "originId", source = "origin.id")
    @Mapping(target = "destinyName", source = "destiny.name")
    @Mapping(target = "originName", source = "origin.name")
    @Mapping(target = "originDepartmentName", source = "origin.department.name")
    @Mapping(target = "destinyDepartmentName", source = "destiny.department.name")
    ItineraryExtendResponse domainToExtendResponse(Itinerary domain);

}
