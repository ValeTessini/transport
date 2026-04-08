package com.vtessini.transport_backend.persistance.model.dto;

import com.vtessini.transport_backend.enums.PersonType;

public record CommercialEntityResponseDTO(
        
        Long id,
        String name,
        String lastName,
        String phoneNumber,
        Long companyId,
        String companyName,
        PersonType personType,
        Boolean isClient,
        Boolean isProvider

) {}
