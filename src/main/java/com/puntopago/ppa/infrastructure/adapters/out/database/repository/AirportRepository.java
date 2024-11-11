package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.domain.enums.AirportState;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    @Query("""
            SELECT AP FROM AirportEntity AP
            WHERE (:name IS NULL OR AP.name LIKE %:name%)
            AND (:locationId IS NULL OR AP.location.id = :locationId)
            AND (:departmentId IS NULL OR AP.location.department.id = :departmentId)
            AND (:state IS NULL OR AP.state = :state)
            """)
    Page<AirportEntity> findByCriteria(@Param("name") String name,
                                       @Param("locationId") Long locationId,
                                       @Param("departmentId") Long departmentId,
                                       @Param("state")AirportState state,
                                       Pageable pageable);
}
