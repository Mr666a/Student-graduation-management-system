package com.hack.graduation_project_system.dao;

import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.ProjectExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProjectMapper {
    @SelectProvider(type=ProjectSqlProvider.class, method="countByExample")
    int countByExample(ProjectExample example);

    @DeleteProvider(type=ProjectSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProjectExample example);

    @Delete({
        "delete from project",
        "where projectId = #{projectid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer projectid);

    @Insert({
        "insert into project (projectId, projectName, ",
        "need, submitId, ",
        "status, choose, specialProject, ",
        "time, contentFileName)",
        "values (#{projectid,jdbcType=INTEGER}, #{projectname,jdbcType=VARCHAR}, ",
        "#{need,jdbcType=VARCHAR}, #{submitid,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=BIT}, #{choose,jdbcType=BIT}, #{specialproject,jdbcType=BIT}, ",
        "#{time,jdbcType=TIMESTAMP}, #{contentfilename,jdbcType=VARCHAR})"
    })
    int insert(Project record);

    @InsertProvider(type=ProjectSqlProvider.class, method="insertSelective")
    int insertSelective(Project record);

    @SelectProvider(type=ProjectSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="projectId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="projectName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="need", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="submitId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="choose", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="specialProject", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="contentFileName", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Project> selectByExample(ProjectExample example);

    @Select({
        "select",
        "projectId, projectName, need, submitId, status, choose, specialProject, time, ",
        "contentFileName",
        "from project",
        "where projectId = #{projectid,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="projectId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="projectName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="need", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="submitId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="choose", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="specialProject", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="contentFileName", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Project selectByPrimaryKey(Integer projectid);

    @UpdateProvider(type=ProjectSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    @UpdateProvider(type=ProjectSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    @UpdateProvider(type=ProjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Project record);

    @Update({
        "update project",
        "set projectName = #{projectname,jdbcType=VARCHAR},",
          "need = #{need,jdbcType=VARCHAR},",
          "submitId = #{submitid,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=BIT},",
          "choose = #{choose,jdbcType=BIT},",
          "specialProject = #{specialproject,jdbcType=BIT},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "contentFileName = #{contentfilename,jdbcType=VARCHAR}",
        "where projectId = #{projectid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Project record);
}