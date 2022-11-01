package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Usersrole;

import java.util.Optional;

public interface UsersRoleService {
    Optional<Usersrole> findUserRoleByUserId(Long id);

    void deleteById(Long id);

    void save(Usersrole usersrole);
}
