package com.vtessini.transport_backend.persistance.model.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "client_order")
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private CommercialEntity client;

    @Column(name="travel_date", nullable = false)
    private LocalDate travelDate;

    @ManyToOne
    @JoinColumn(name = "delivered_by_id")
    private User deliveredBy;

    @Column(name="description")
    private String description;
    
    @Column(name="origin", nullable = false)
    private String origin;                          //Esto lo voy a hacer con una API de google maps, pero por ahora lo dejo como un string
    
    @Column(name="destination", nullable = false)
    private String destination;                     //Esto lo voy a hacer con una API de google maps, pero por ahora lo dejo como un string
    
    @ElementCollection
    @CollectionTable(name = "order_intermediate_points", joinColumns = @JoinColumn(name = "order_id"))
    private List<String> intermediatePoints;        //Esto lo voy a hacer con una API de google maps, pero por ahora lo dejo como un string

}
