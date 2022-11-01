package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Usersrole;
import com.example.taykotoproject.repository.UsersRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersRoleServiceImpl implements UsersRoleService {

    @Autowired
    private UsersRoleRepository usersRoleRepository;

    @Override
    public Optional<Usersrole> findUserRoleByUserId(Long id) {
        return usersRoleRepository.findUserRoleByUserId(id);
    }

    @Override
    public void deleteById(Long id) {
        usersRoleRepository.deleteById(id);
    }

    @Override
    public void save(Usersrole usersrole) {
        usersRoleRepository.save(usersrole);
    }


}