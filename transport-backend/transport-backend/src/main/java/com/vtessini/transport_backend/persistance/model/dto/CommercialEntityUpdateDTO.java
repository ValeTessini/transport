package com.vtessini.transport_backend.persistance.model.dto;

import com.vtessini.transport_backend.enums.PersonType;

public record CommercialEntityUpdateDTO(
        String name,
        String lastName,
        String phoneNumber,
        PersonType personType,
        Boolean isClient,
        Boolean isProvider
) {
    public boolean hasChanges() {
        return name != null || lastName != null || phoneNumber != null
                || personType != null || isClient != null || isProvider != null;
    }
}
