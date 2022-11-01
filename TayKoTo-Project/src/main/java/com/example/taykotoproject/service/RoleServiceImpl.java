package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Roles;
import com.example.taykotoproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Roles> findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }
}

