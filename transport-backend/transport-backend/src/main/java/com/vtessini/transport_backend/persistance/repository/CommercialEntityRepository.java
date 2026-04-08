package com.vtessini.transport_backend.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.vtessini.transport_backend.persistance.model.entity.CommercialEntity;

@Repository
public interface CommercialEntityRepository extends JpaRepository<CommercialEntity, Long> {

    Optional<CommercialEntity> findByIdAndCompanyId(Long id, Long companyId);

}
