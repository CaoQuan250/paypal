package com.example.taykotoproject.service;

import com.example.taykotoproject.model.VehicleGallery;
import com.example.taykotoproject.repository.VehicleGalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleGalleryServiceImpl implements VehicleGalleryService {

    @Autowired
    private VehicleGalleryRepository vehicleGalleryRepository;


    @Override
    public List<VehicleGallery> getAll() {
        return vehicleGalleryRepository.findAll();
    }

    @Override
    public void save(VehicleGallery vehicleGallery) {
        vehicleGalleryRepository.save(vehicleGallery);
    }

    @Override
    public void delete(Long id) {
        vehicleGalleryRepository.deleteById(id);
    }

    @Override
    public Optional<VehicleGallery> findById(Long id) {
        return vehicleGalleryRepository.findById(id);
    }

    @Override
    public VehicleGallery getOne(Long id) {
        return vehicleGalleryRepository.findById(id).get();
    }

    @Override
    public List<VehicleGallery> findAllById(Long id) {
        return vehicleGalleryRepository.findAllByVehicleId(id);
    }
}
