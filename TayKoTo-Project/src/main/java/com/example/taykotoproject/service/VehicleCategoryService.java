package com.example.taykotoproject.service;

import com.example.taykotoproject.model.VehicleCategory;

import java.util.List;
import java.util.Optional;

public interface VehicleCategoryService {
    List<VehicleCategory> getAll();

    void save(VehicleCategory vehicleCategory);

    void delete (Long id);

    Optional<VehicleCategory> findById(Long id);

    VehicleCategory getOne(Long id);
}
