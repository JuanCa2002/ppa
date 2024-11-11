package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.infrastructure.adapters.out.database.entities.ItineraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {

    @Query("SELECT I FROM ItineraryEntity I JOIN FlightEntity F ON F.itinerary.id = I.id" +
            " WHERE F.id = :flightId")
    ItineraryEntity findByFlight(@Param("flightId") Long flightId);
}
