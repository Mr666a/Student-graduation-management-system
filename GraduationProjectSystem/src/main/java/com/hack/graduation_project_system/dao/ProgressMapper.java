package com.hack.graduation_project_system.dao;

import com.hack.graduation_project_system.domain.Progress;
import com.hack.graduation_project_system.domain.ProgressExample;
import com.hack.graduation_project_system.domain.ProgressKey;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProgressMapper {
    @SelectProvider(type=ProgressSqlProvider.class, method="countByExample")
    int countByExample(ProgressExample example);

    @DeleteProvider(type=ProgressSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProgressExample example);

    @Delete({
        "delete from progress",
        "where studentId = #{studentid,jdbcType=INTEGER}",
          "and projectId = #{projectid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(ProgressKey key);

    @Insert({
        "insert into progress (studentId, projectId, ",
        "contentFileName)",
        "values (#{studentid,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{contentfilename,jdbcType=VARCHAR})"
    })
    int insert(Progress record);

    @InsertProvider(type=ProgressSqlProvider.class, method="insertSelective")
    int insertSelective(Progress record);

    @SelectProvider(type=ProgressSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="studentId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="projectId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="contentFileName", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Progress> selectByExample(ProgressExample example);

    @Select({
        "select",
        "studentId, projectId, contentFileName",
        "from progress",
        "where studentId = #{studentid,jdbcType=INTEGER}",
          "and projectId = #{projectid,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="studentId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="projectId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="contentFileName", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Progress selectByPrimaryKey(ProgressKey key);

    @UpdateProvider(type=ProgressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Progress record, @Param("example") ProgressExample example);

    @UpdateProvider(type=ProgressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Progress record, @Param("example") ProgressExample example);

    @UpdateProvider(type=ProgressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Progress record);

    @Update({
        "update progress",
        "set contentFileName = #{contentfilename,jdbcType=VARCHAR}",
        "where studentId = #{studentid,jdbcType=INTEGER}",
          "and projectId = #{projectid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Progress record);
}