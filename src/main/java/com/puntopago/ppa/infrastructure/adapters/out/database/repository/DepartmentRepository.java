package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Query("""
            SELECT D FROM DepartmentEntity D WHERE (:name IS NULL OR UPPER(D.name) LIKE CONCAT('%', UPPER(:name), '%'))
            AND (:state IS NULL OR D.state = :state)
            """)
    Page<DepartmentEntity> findByCriteria(@Param("name") String name,
                                          @Param("state")State state,
                                          Pageable pageable);

}
