package com.hack.graduation_project_system.dao;

import com.hack.graduation_project_system.domain.Teacher;
import com.hack.graduation_project_system.domain.TeacherExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {
    @SelectProvider(type=TeacherSqlProvider.class, method="countByExample")
    int countByExample(TeacherExample example);

    @DeleteProvider(type=TeacherSqlProvider.class, method="deleteByExample")
    int deleteByExample(TeacherExample example);

    @Delete({
        "delete from teacher",
        "where teacherId = #{teacherid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer teacherid);

    @Insert({
        "insert into teacher (teacherId, teacherName, ",
        "password, gender, ",
        "phone, majorId, ",
        "classId)",
        "values (#{teacherid,jdbcType=INTEGER}, #{teachername,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{majorid,jdbcType=VARCHAR}, ",
        "#{classid,jdbcType=VARCHAR})"
    })
    int insert(Teacher record);

    @InsertProvider(type=TeacherSqlProvider.class, method="insertSelective")
    int insertSelective(Teacher record);

    @SelectProvider(type=TeacherSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="teacherId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="teacherName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="classId", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Teacher> selectByExample(TeacherExample example);

    @Select({
        "select",
        "teacherId, teacherName, password, gender, phone, majorId, classId",
        "from teacher",
        "where teacherId = #{teacherid,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="teacherId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="teacherName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="classId", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Teacher selectByPrimaryKey(Integer teacherid);

    @UpdateProvider(type=TeacherSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    @UpdateProvider(type=TeacherSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    @UpdateProvider(type=TeacherSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Teacher record);

    @Update({
        "update teacher",
        "set teacherName = #{teachername,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "majorId = #{majorid,jdbcType=VARCHAR},",
          "classId = #{classid,jdbcType=VARCHAR}",
        "where teacherId = #{teacherid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Teacher record);
}