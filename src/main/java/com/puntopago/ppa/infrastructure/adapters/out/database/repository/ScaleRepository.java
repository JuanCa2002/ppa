package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.infrastructure.adapters.out.database.entities.ScaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScaleRepository extends JpaRepository<ScaleEntity,Long> {

    @Query("SELECT S FROM ScaleEntity S WHERE S.itinerary.id = :itineraryId")
    List<ScaleEntity> findByItinerary(@Param("itineraryId") Long itineraryId);

    @Query("""
            SELECT CASE WHEN COUNT(S) > 0 THEN TRUE ELSE FALSE END
            FROM ScaleEntity S WHERE S.itinerary.id = :itineraryId
            """)
    boolean hasScale(@Param("itineraryId") Long itineraryId);

}
