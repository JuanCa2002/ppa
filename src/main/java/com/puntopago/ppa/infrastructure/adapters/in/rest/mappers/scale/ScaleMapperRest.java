package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.scale;

import com.puntopago.ppa.domain.models.Scale;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.scale.ScaleRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.scale.ScaleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScaleMapperRest {

    @Mapping(target = "scalePlace.id ", source = "scalePlaceId")
    @Mapping(target = "itinerary.id", source = "itineraryId")
    Scale requestToDomain(ScaleRequest request);

    List<Scale> requestsToDomains(List<ScaleRequest> requests);

    @Mapping(target = "scalePlaceId", source = "scalePlace.id")
    @Mapping(target = "itineraryId", source = "itinerary.id")
    @Mapping(target = "scalePlaceName", source = "scalePlace.name")
    @Mapping(target = "scalePlaceLocationName", source = "scalePlace.location.name")
    ScaleResponse domainToResponse(Scale domain);

    List<ScaleResponse> domainsToResponses(List<Scale> domains);
}
