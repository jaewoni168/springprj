package com.resultMap1.mapper;

import com.resultMap1.dto.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface StudentMapper {

    @Select("SELECT * FROM student")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE departmentId = #{departmentId}")

    List<Student> findByDepartmentId(int departmentId);

}