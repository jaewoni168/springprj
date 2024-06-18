package com.jpa7.repository;

import com.jpa7.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByStudentNo(String studentNo);

    Page<Student> findByStudentNoOrNameStartsWithOrDepartmentNameStartsWith(
            String studentNo, String name, String departmentName, Pageable pageable);
}
