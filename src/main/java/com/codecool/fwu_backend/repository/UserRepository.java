package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.FWUAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<FWUAppUser, Long> {

    Optional<FWUAppUser> findByUsername(String username);

}
