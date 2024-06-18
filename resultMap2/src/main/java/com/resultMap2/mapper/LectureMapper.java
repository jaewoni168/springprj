package com.resultMap2.mapper;

import com.resultMap2.dto.Lecture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LectureMapper {
    @Results({
            @Result(property="professorId", column="professorId"),
            @Result(property="professor", column="professorId",
                    one=@One(select="com.resultMap2.mapper.ProfessorMapper.findOne"))
    })

    @Select(" SELECT * FROM lecture ")
    List<Lecture> findAll();

    @Select("SELECT * FROM lecture WHERE professorId = #{professorId}")
    List<Lecture> findByProfessorId(int professorId);
}
