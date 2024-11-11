package com.puntopago.ppa.infrastructure.adapters.out.database.entities;

import com.puntopago.ppa.domain.enums.State;
import jakarta.persistence.Column;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "SEQ_AIRPLANE", sequenceName = "SEQ_AIRPLANE", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "airplane")
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AIRPLANE")
    @Column(name = "id")
    private Long id;

    @Column(name = "branch", nullable = false, length = 50)
    private String branch;

    @Column(name = "model", nullable = false)
    private Integer model;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private AirlineEntity airline;
}
