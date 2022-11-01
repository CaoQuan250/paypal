package com.example.taykotoproject.repository;

import com.example.taykotoproject.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
    List<Deal> findAllByCustomerId(Long id);
}
