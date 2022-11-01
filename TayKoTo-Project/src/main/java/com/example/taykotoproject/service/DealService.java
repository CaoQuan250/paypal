package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Deal;

import java.util.List;
import java.util.Optional;

public interface DealService {
    List<Deal> getAll();

    void save(Deal deal);

    void delete (Long id);

    Optional<Deal> findById(Long id);

    Deal getOne(Long id);

    List<Deal> getAllById(Long id);
}
