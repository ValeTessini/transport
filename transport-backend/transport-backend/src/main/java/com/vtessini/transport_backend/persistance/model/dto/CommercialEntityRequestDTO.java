package com.vtessini.transport_backend.persistance.model.dto;

import com.vtessini.transport_backend.enums.PersonType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommercialEntityRequestDTO(

        @NotBlank(message = "El nombre es obligatorio")
        String name,

        String lastName,

        String phoneNumber,

        @NotNull(message = "El companyId es obligatorio")
        Long companyId,

        @NotNull(message = "El tipo de persona es obligatorio")
        PersonType personType,

        @NotNull(message = "Debe indicar si es cliente")
        Boolean isClient,

        @NotNull(message = "Debe indicar si es proveedor")
        Boolean isProvider
        
) {}
