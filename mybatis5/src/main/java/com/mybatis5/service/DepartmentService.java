package com.mybatis5.service;

import com.mybatis5.dto.Department;
import com.mybatis5.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    public DepartmentMapper departmentMapper;



    public List<Department> findAll() {
        return departmentMapper.findAll();

    }
}
