package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAll();

    void save(Customer customer);

    void delete (Long id);

    Optional<Customer> findById(Long id);

    Customer getOne(Long id);
}
