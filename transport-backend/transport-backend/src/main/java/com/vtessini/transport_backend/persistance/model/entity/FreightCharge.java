package com.vtessini.transport_backend.persistance.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.vtessini.transport_backend.enums.PaymentMethod;
import com.vtessini.transport_backend.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "freight_charges")
public class FreightCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private ClientOrder order;
    
    @Column(nullable = false)
    private BigDecimal agreedAmount;    // Lo que se acordó cobrar
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    @Column
    private LocalDate paymentDate; 
    
    @Column
    private BigDecimal paidAmount;      // Lo que efectivamente se cobró
    
    @Column
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

}
