package com.jpa5.repository;

import com.jpa5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByStudentNo(String studentNo);
}
