package com.resultMap2.mapper;

import com.resultMap2.dto.Professor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProfessorMapper {

    @Results({
            @Result(property = "id", column="id", id=true),

            @Result(property="lectures", column="id",

                    many=@Many(select="com.resultMap2.mapper.LectureMapper.findByProfessorId"))

    })

    @Select("SELECT * FROM professor")
    List<Professor> findAll();



    @Select("SELECT * FROM professor WHERE id = #{id}")

    Professor findOne(int id);
}