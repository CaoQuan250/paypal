package com.example.taykotoproject.service;

import com.example.taykotoproject.model.InfoService;
import com.example.taykotoproject.repository.InfoServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoServicesImpl implements InfoServices {

    @Autowired
    private InfoServiceRepository infoServiceRepository;


    @Override
    public List<InfoService> getAll() {
        return infoServiceRepository.findAll();
    }

    @Override
    public void save(InfoService info) {
        infoServiceRepository.save(info);
    }

    @Override
    public void delete(Long id) {
        infoServiceRepository.deleteById(id);
    }

    @Override
    public Optional<InfoService> findById(Long id) {
        return infoServiceRepository.findById(id);
    }

    @Override
    public InfoService getOne(Long id) {
        return infoServiceRepository.findById(id).get();
    }

    @Override
    public Optional<InfoService> findByVehicleId(Long id) {
        return infoServiceRepository.findByVehicleId(id);
    }
}
