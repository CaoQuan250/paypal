package com.example.taykotoproject.repository;

import com.example.taykotoproject.model.InfoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoServiceRepository extends JpaRepository<InfoService, Long> {

    Optional<InfoService> findByVehicleId(Long id);


}
