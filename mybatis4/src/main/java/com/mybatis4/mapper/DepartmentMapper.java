package com.mybatis4.mapper;

import com.mybatis4.dto.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM department")

    List<Department> findAll();
}
