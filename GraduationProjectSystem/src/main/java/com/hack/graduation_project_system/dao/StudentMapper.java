package com.hack.graduation_project_system.dao;

import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.domain.StudentExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {
    @SelectProvider(type=StudentSqlProvider.class, method="countByExample")
    int countByExample(StudentExample example);

    @DeleteProvider(type=StudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentExample example);

    @Delete({
        "delete from student",
        "where studentId = #{studentid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer studentid);

    @Insert({
        "insert into student (studentId, studentName, ",
        "password, gender, ",
        "majorId, projectId, ",
        "classId, graduationDate, ",
        "email, phone, id, ",
        "grade)",
        "values (#{studentid,jdbcType=INTEGER}, #{studentname,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
        "#{majorid,jdbcType=VARCHAR}, #{projectid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=VARCHAR}, #{graduationdate,jdbcType=INTEGER}, ",
        "#{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{id,jdbcType=VARCHAR}, ",
        "#{grade,jdbcType=INTEGER})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="studentId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="studentName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="projectId", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="classId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="graduationDate", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="grade", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "studentId, studentName, password, gender, majorId, projectId, classId, graduationDate, ",
        "email, phone, id, grade",
        "from student",
        "where studentId = #{studentid,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="studentId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="studentName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="projectId", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="classId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="graduationDate", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="grade", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    Student selectByPrimaryKey(Integer studentid);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set studentName = #{studentname,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=VARCHAR},",
          "majorId = #{majorid,jdbcType=VARCHAR},",
          "projectId = #{projectid,jdbcType=INTEGER},",
          "classId = #{classid,jdbcType=VARCHAR},",
          "graduationDate = #{graduationdate,jdbcType=INTEGER},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "id = #{id,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=INTEGER}",
        "where studentId = #{studentid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}