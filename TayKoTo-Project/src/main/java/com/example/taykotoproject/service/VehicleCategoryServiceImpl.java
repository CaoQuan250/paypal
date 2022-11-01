package com.example.taykotoproject.service;

import com.example.taykotoproject.model.VehicleCategory;
import com.example.taykotoproject.repository.VehicleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Override
    public List<VehicleCategory> getAll() {
        return vehicleCategoryRepository.findAll();
    }

    @Override
    public void save(VehicleCategory vehicleCategory) {
        vehicleCategoryRepository.save(vehicleCategory);
    }

    @Override
    public void delete(Long id) {
        vehicleCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<VehicleCategory> findById(Long id) {
        return vehicleCategoryRepository.findById(id);
    }

    @Override
    public VehicleCategory getOne(Long id) {
        return vehicleCategoryRepository.findById(id).get();
    }
}
