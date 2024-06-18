package com.example.spring3.mapper;

import com.example.spring3.dto.Department;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("""
            SELECT * from student2.department """)
    List<Department> findAll();
}
