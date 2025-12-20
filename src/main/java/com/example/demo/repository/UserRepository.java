package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Used during login
    Optional<User> findByEmail(String email);

    // Used during register (duplicate check)
    boolean existsByEmail(String email);
}
