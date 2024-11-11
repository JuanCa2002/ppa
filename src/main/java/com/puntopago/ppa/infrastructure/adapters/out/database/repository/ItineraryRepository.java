package com.puntopago.ppa.infrastructure.adapters.out.database.repository;

import com.puntopago.ppa.infrastructure.adapters.out.database.entities.ItineraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {
}
