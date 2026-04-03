package com.vtessini.transport_backend.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtessini.transport_backend.persistance.model.entity.ClientOrder;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

}
