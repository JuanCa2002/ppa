package com.puntopago.ppa.application.usecases.airport;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.AirportState;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.ports.in.airport.CreateAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import com.puntopago.ppa.infrastructure.ports.out.municipality.MunicipalityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateAirportUseCaseImpl implements CreateAirportUseCase {

    private final AirportPort port;

    private final MunicipalityPort municipalityPort;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airport execute(Airport airport) throws ApiException {
        Municipality foundMunicipality = municipalityPort.findById(airport.getLocation().getId());
        airport.setId(null);
        airport.setState(AirportState.ALLOWED);
        Airport savedAirport = port.save(airport);
        savedAirport.setLocation(foundMunicipality);
        return savedAirport;
    }
}
