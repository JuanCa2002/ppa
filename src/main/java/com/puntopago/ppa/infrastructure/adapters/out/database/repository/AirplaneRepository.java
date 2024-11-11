package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirplaneEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Long> {

    @Query("""
            SELECT AP FROM AirplaneEntity AP 
            WHERE (:branch IS NULL OR AP.branch LIKE %:branch%)
            AND (:model IS NULL OR AP.model = :model)
            AND (:state IS NULL OR AP.state = :state)
            AND AP.airline.id = :airlineId
            """)
    Page<AirplaneEntity> findByCriteria(@Param("branch") String branch,
                                        @Param("model") Integer model,
                                        @Param("state")State state,
                                        @Param("airlineId") Integer airlineId,
                                        Pageable pageable);
}
