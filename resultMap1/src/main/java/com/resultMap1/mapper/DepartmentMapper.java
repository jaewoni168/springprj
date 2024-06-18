package com.resultMap1.mapper;

import com.resultMap1.dto.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM department")
    List<Department> findAll();
    @Select("SELECT * FROM department WHERE id = #{id}")
    Department findOne(int id);
}