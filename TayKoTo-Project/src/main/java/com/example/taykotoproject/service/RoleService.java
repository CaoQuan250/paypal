package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Roles;

import java.util.Optional;

public interface RoleService {

    Optional<Roles> findByRoleName(String name);
}

