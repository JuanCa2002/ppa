package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.domain.enums.FlightState;
import com.puntopago.ppa.domain.filters.FlightFilter;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.FlightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    @Query("""
            SELECT F FROM FlightEntity F 
            WHERE F.itinerary.origin.location.id = :#{#filter.originId}
            AND F.itinerary.destiny.location.id = :#{#filter.destinyId}
            AND (:#{#filter.exitDate} IS NULL OR F.itinerary.exitDate = :#{#filter.exitDate}) 
            AND (:#{#filter.exitTime} IS NULL OR F.itinerary.exitTime = :#{#filter.exitTime})
            AND (:#{#filter.estimatedTime} IS NULL OR F.itinerary.estimatedTime <= :#{#filter.estimatedTime})
            AND (:#{#filter.unitTime} IS NULL OR F.itinerary.unitTime = :#{#filter.unitTime})
            AND (:#{#filter.airlineId} IS NULL OR F.airplane.airline.id = :#{#filter.airlineId})
            AND (:#{#filter.price} IS NULL OR F.price <= :#{#filter.price})
            AND (:#{#filter.isDirect} IS NULL OR F.isDirect = :#{#filter.isDirect})
            AND (:state IS NULL OR F.state = :state)
            """)
    Page<FlightEntity> findByCriteria(@Param("filter")FlightFilter filter,
                                      @Param("state")FlightState state,
                                      Pageable pageable);
}
