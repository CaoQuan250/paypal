package com.example.taykotoproject.repository;

import com.example.taykotoproject.model.Usersrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRoleRepository extends JpaRepository<Usersrole, Long> {

    Optional<Usersrole> findUserRoleByUserId(Long id);

    void deleteById(Long id);
}