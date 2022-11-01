package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Page<Vehicle> getAllLimit(Pageable pageable);

    List<Vehicle> getAll();

    Page<Vehicle> filter(Pageable pageable,String brand, String body);

    void saveVehicle(Vehicle vehicle);

    void deleteVehicle(Long id);

    Optional<Vehicle> findById(Long id);

    List<Vehicle> search(String keyword);


}
