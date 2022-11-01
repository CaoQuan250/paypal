package com.example.taykotoproject.service;

import com.example.taykotoproject.model.VehicleGallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VehicleGalleryService {
    List<VehicleGallery> getAll();

    void save(VehicleGallery vehicleGallery);

    void delete (Long id);

    Optional<VehicleGallery> findById(Long id);

    VehicleGallery getOne(Long id);

    List<VehicleGallery> findAllById(Long id);
}
