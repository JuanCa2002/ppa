package com.puntopago.ppa.infrastructure.adapters.out.database.entities;


import com.puntopago.ppa.domain.enums.UnitTime;
import com.puntopago.ppa.infrastructure.config.converters.LocalTimeStringConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "SEQ_SCALE", sequenceName = "SEQ_SCALE", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "scale")
public class ScaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCALE")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scale_place_id", nullable = false)
    private AirportEntity scalePlace;

    @Convert(converter = LocalTimeStringConverter.class)
    @Column(name = "arrival_time_scale", nullable = false, length = 8)
    private LocalTime arrivalTimeScale;

    @Column(name = "estimated_time_scale", nullable = false)
    private Integer estimatedTimeScale;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_time", nullable = false, length = 8)
    private UnitTime unitTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itinerary_id", nullable = false)
    private ItineraryEntity itinerary;
}
