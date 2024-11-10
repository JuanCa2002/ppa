package com.puntopago.ppa.infrastructure.adapters.out.database.entities;

import com.puntopago.ppa.domain.enums.State;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@SequenceGenerator(name = "SEQ_DEPARTMENT", sequenceName = "SEQ_DEPARTMENT", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DEPARTMENT")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private State state;
}
