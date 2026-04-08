package com.vtessini.transport_backend.service;

import org.springframework.stereotype.Service;

import com.vtessini.transport_backend.exception.ResourceNotFoundException;
import com.vtessini.transport_backend.persistance.model.dto.CommercialEntityRequestDTO;
import com.vtessini.transport_backend.persistance.model.dto.CommercialEntityResponseDTO;
import com.vtessini.transport_backend.persistance.model.dto.CommercialEntityUpdateDTO;
import com.vtessini.transport_backend.persistance.model.entity.CommercialEntity;
import com.vtessini.transport_backend.persistance.model.entity.Company;
import com.vtessini.transport_backend.persistance.repository.CommercialEntityRepository;
import com.vtessini.transport_backend.persistance.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommercialEntityService {

    private final CommercialEntityRepository commercialEntityRepository;
    private final CompanyRepository companyRepository;

    private CommercialEntityResponseDTO toResponseDTO(CommercialEntity entity) {

        return new CommercialEntityResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getPhoneNumber(),
                entity.getCompany().getId(),
                entity.getCompany().getName(),
                entity.getPersonType(),
                entity.getIsClient(),
                entity.getIsProvider()
        );

    }

    public CommercialEntityResponseDTO addCommercialEntity(CommercialEntityRequestDTO request, Long companyId) {

        if (!request.companyId().equals(companyId)) {
            throw new ResourceNotFoundException("Company", request.companyId());
        }

        Company company = companyRepository.findById(companyId)
                            .orElseThrow(() -> new ResourceNotFoundException("Company", companyId));

        CommercialEntity entity = new CommercialEntity();
        entity.setName(request.name());
        entity.setLastName(request.lastName());
        entity.setPhoneNumber(request.phoneNumber());
        entity.setCompany(company);
        entity.setPersonType(request.personType());
        entity.setIsClient(request.isClient());
        entity.setIsProvider(request.isProvider());

        commercialEntityRepository.save(entity);

        return toResponseDTO(entity);

    }

    public CommercialEntityResponseDTO modifyCommercialEntity(Long id, CommercialEntityUpdateDTO request, Long companyId) {

        if (!request.hasChanges()) {
            throw new IllegalArgumentException("No se enviaron campos para modificar");
        }

        CommercialEntity entity = commercialEntityRepository.findByIdAndCompanyId(id, companyId)
                                    .orElseThrow(() -> new ResourceNotFoundException("CommercialEntity", id));

        if (request.name() != null && !request.name().isBlank()) entity.setName(request.name());
        if (request.lastName() != null) entity.setLastName(request.lastName());
        if (request.phoneNumber() != null) entity.setPhoneNumber(request.phoneNumber());
        if (request.personType() != null) entity.setPersonType(request.personType());
        if (request.isClient() != null) entity.setIsClient(request.isClient());
        if (request.isProvider() != null) entity.setIsProvider(request.isProvider());

        commercialEntityRepository.save(entity);

        return toResponseDTO(entity);

    }

    public void deleteCommercialEntity(Long commercialEntityId, Long companyId) {
        CommercialEntity entity = commercialEntityRepository.findByIdAndCompanyId(commercialEntityId, companyId)
                                    .orElseThrow(() -> new ResourceNotFoundException("CommercialEntity", commercialEntityId));

        commercialEntityRepository.delete(entity);
    }

}
