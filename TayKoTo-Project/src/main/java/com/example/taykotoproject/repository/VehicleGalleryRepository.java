package com.example.taykotoproject.repository;

import com.example.taykotoproject.model.VehicleGallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleGalleryRepository extends JpaRepository<VehicleGallery, Long> {

    List<VehicleGallery> findAllByVehicleId(Long id);
}
