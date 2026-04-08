package com.vtessini.transport_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtessini.transport_backend.persistance.model.dto.CommercialEntityRequestDTO;
import com.vtessini.transport_backend.persistance.model.dto.CommercialEntityResponseDTO;
import com.vtessini.transport_backend.persistance.model.dto.CommercialEntityUpdateDTO;
import com.vtessini.transport_backend.service.CommercialEntityService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


//Este controller sera utilizado solo por un ADMIN, no un user cualquiera

@RestController
@RequestMapping("/api/commercial-entities")
@RequiredArgsConstructor
public class CommercialEntityController {

    private final CommercialEntityService commercialEntityService;

    @PostMapping
    public ResponseEntity<CommercialEntityResponseDTO> create(@Valid @RequestBody CommercialEntityRequestDTO request) {

        // TODO: obtener companyId del token JWT cuando se integre auth
        Long companyId = 1L; // placeholder hasta integrar JwtService
        CommercialEntityResponseDTO response = commercialEntityService.addCommercialEntity(request, companyId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommercialEntityResponseDTO> modify(@PathVariable Long id, @RequestBody CommercialEntityUpdateDTO request) {

        // TODO: obtener companyId del token JWT cuando se integre auth
        Long companyId = 1L; // placeholder hasta integrar JwtService
        CommercialEntityResponseDTO response = commercialEntityService.modifyCommercialEntity(id, request, companyId);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    
        // TODO: obtener companyId del token JWT cuando se integre auth
        Long companyId = 1L; // placeholder hasta integrar JwtService
        commercialEntityService.deleteCommercialEntity(id, companyId);
        return ResponseEntity.noContent().build();
        
    }
}
