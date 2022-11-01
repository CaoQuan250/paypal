package com.example.taykotoproject.service;

import com.example.taykotoproject.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    Optional<Users> findById(Long id);
    void saveUsers(Users user);

    //lấy tất cả
    List<Users> getAll();

    //tìm theo id
    Users findUserById(Long id);

    //delete
    void deleteByUser(Long id);

    Users findByUsername(String name);

    Boolean existsByUsername(String username);

    void processOAuthPostLogin(String username);
}
