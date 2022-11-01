package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Deal;
import com.example.taykotoproject.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Override
    public List<Deal> getAll() {
        return dealRepository.findAll();
    }

    @Override
    public void save(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public void delete(Long id) {
        dealRepository.deleteById(id);
    }

    @Override
    public Optional<Deal> findById(Long id) {
        return dealRepository.findById(id);
    }

    @Override
    public Deal getOne(Long id) {
        return dealRepository.findById(id).get();
    }

    @Override
    public List<Deal> getAllById(Long id) {
        return dealRepository.findAllByCustomerId(id);
    }
}
