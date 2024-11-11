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

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "SEQ_ITINERARY", sequenceName = "SEQ_ITINERARY", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "itinerary")
public class ItineraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITINERARY")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_id", nullable = false)
    private AirportEntity origin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destiny_id", nullable = false)
    private AirportEntity destiny;

    @Column(name = "estimated_time", nullable = false)
    private Integer estimatedTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_time", nullable = false, length = 8)
    private UnitTime unitTime;

    @Convert(converter = LocalTimeStringConverter.class)
    @Column(name = "exit_time", nullable = false, length = 8)
    private LocalTime exitTime;

    @Convert(converter = LocalTimeStringConverter.class)
    @Column(name = "arrival_time", nullable = false, length = 8)
    private LocalTime arrivalTime;

    @Column(name = "exit_date", nullable = false)
    private LocalDate exitDate;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

}
