package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.MunicipalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipalityRepository extends JpaRepository<MunicipalityEntity, Long> {

    @Query("""
            SELECT M FROM MunicipalityEntity M 
            WHERE M.department.id = :departmentId
            AND (:name IS NULL OR M.name LIKE %:name%) 
            AND (:state IS NULL OR M.state = :state)
            """)
    List<MunicipalityEntity> findAllByCriteria(@Param("departmentId") Long departmentId,
                                               @Param("name") String name,
                                               @Param("state")State state);
}
