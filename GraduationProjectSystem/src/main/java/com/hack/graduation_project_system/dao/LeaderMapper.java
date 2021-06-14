package com.hack.graduation_project_system.dao;

import com.hack.graduation_project_system.domain.Leader;
import com.hack.graduation_project_system.domain.LeaderExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LeaderMapper {
    @SelectProvider(type=LeaderSqlProvider.class, method="countByExample")
    int countByExample(LeaderExample example);

    @DeleteProvider(type=LeaderSqlProvider.class, method="deleteByExample")
    int deleteByExample(LeaderExample example);

    @Delete({
        "delete from leader",
        "where leaderId = #{leaderid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer leaderid);

    @Insert({
        "insert into leader (leaderId, leaderName, ",
        "password, gender, ",
        "phone, majorId, ",
        "role)",
        "values (#{leaderid,jdbcType=INTEGER}, #{leadername,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{majorid,jdbcType=VARCHAR}, ",
        "#{role,jdbcType=VARCHAR})"
    })
    int insert(Leader record);

    @InsertProvider(type=LeaderSqlProvider.class, method="insertSelective")
    int insertSelective(Leader record);

    @SelectProvider(type=LeaderSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="leaderId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="leaderName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="role", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Leader> selectByExample(LeaderExample example);

    @Select({
        "select",
        "leaderId, leaderName, password, gender, phone, majorId, role",
        "from leader",
        "where leaderId = #{leaderid,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="leaderId", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="leaderName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="role", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Leader selectByPrimaryKey(Integer leaderid);

    @UpdateProvider(type=LeaderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Leader record, @Param("example") LeaderExample example);

    @UpdateProvider(type=LeaderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Leader record, @Param("example") LeaderExample example);

    @UpdateProvider(type=LeaderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Leader record);

    @Update({
        "update leader",
        "set leaderName = #{leadername,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "majorId = #{majorid,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=VARCHAR}",
        "where leaderId = #{leaderid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Leader record);
}