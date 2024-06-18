package com.jpa1.repository;

import com.jpa1.entity.Department;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    @Test
    @DisplayName("저장테스트")
    public void createTest(){
        Department d = new Department();
        d.setName("학과");
        d.setShortName("건축");
        d.setPhone("021231111");
        Department d2 = departmentRepository.save(d);

        log.info(String.valueOf(d2));
        String d3 = "경제학과 02 044 666";
        assertEquals(d3.toString(), d2.toString());
                 // 예상,    결과치
    }

    @Test
    @DisplayName("조회테스트")
    public void findByIdTest(){
        Department d1 = departmentRepository.findById(1).orElse(null);
        // Optional<Department> d1=departmentRepository.findById(1);
        String d2="Depatment(id=2, name=컴퓨터공학과, shortJame= 소트, phone=02-2610-9563";

        log.info(d1.toString());
        // 예상

        // 실제

        // 검증
        assertEquals(d2.toString(), d1.toString());

    }

}