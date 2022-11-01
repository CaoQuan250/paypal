package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Vehicle;
import com.example.taykotoproject.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Page<Vehicle> getAllLimit(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Page<Vehicle> filter(Pageable pageable,String brand, String body) {
        if (brand != null && body != null){
            return vehicleRepository.findByVehicleMakeAndBodyStyle(pageable,brand,body);
        } else if (brand != null && body == null) {
            return vehicleRepository.findByVehicleMake(pageable,brand);
        } else if (brand == null && body != null) {
            return vehicleRepository.findByBodyStyle(pageable,body);
        }
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> search(String keyword) {
        return vehicleRepository.search(keyword);
    }
}
