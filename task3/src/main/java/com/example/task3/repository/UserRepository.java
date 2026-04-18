package com.example.task3.repository;

import com.example.task3.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {
    // Здесь все готовые методы: save, findById, findAll, deleteById и т.д.
}