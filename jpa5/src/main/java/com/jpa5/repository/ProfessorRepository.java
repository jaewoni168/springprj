package com.jpa5.repository;

import com.jpa5.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    Professor findByName(String name);
}