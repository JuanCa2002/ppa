package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirlineEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {

    @Query("""
            SELECT AL FROM AirlineEntity AL 
            WHERE (:name IS NULL OR AL.name LIKE %:name%)
            AND (:state IS NULL OR AL.state = :state)
            """)
    Page<AirlineEntity> findByCriteria(@Param("name") String name,
                                       @Param("state")State state,
                                       Pageable pageable);
}
