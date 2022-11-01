package com.example.taykotoproject.service;

import com.example.taykotoproject.model.InfoService;

import java.util.List;
import java.util.Optional;

public interface InfoServices {
    List<InfoService> getAll();

    void save(InfoService info);

    void delete (Long id);

    Optional<InfoService> findById(Long id);

    InfoService getOne(Long id);

    Optional<InfoService> findByVehicleId(Long id);
}
