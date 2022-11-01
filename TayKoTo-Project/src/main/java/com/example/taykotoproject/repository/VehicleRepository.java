package com.example.taykotoproject.repository;

import com.example.taykotoproject.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Page<Vehicle> findAll(Pageable pageable);

    @Query("SELECT v FROM Vehicle v " +
            "WHERE v.vehicleMake " +
            "LIKE %?1% " +
            "OR v.vehicleModel " +
            "LIKE %?1%")
    List<Vehicle> search(String keyword);

    Page<Vehicle>findByVehicleMakeAndBodyStyle(Pageable pageable,String brand, String body);

    Page<Vehicle>findByVehicleMake(Pageable pageable,String brand);

    Page<Vehicle>findByBodyStyle(Pageable pageable,String body);


}
