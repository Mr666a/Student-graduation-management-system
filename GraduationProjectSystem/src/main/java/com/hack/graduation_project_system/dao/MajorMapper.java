package com.hack.graduation_project_system.dao;

import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.MajorExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MajorMapper {
    @SelectProvider(type=MajorSqlProvider.class, method="countByExample")
    int countByExample(MajorExample example);

    @DeleteProvider(type=MajorSqlProvider.class, method="deleteByExample")
    int deleteByExample(MajorExample example);

    @Delete({
        "delete from major",
        "where majorId = #{majorid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String majorid);

    @Insert({
        "insert into major (majorId, majorName, ",
        "leaderId)",
        "values (#{majorid,jdbcType=VARCHAR}, #{majorname,jdbcType=VARCHAR}, ",
        "#{leaderid,jdbcType=INTEGER})"
    })
    int insert(Major record);

    @InsertProvider(type=MajorSqlProvider.class, method="insertSelective")
    int insertSelective(Major record);

    @SelectProvider(type=MajorSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="majorName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="leaderId", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<Major> selectByExample(MajorExample example);

    @Select({
        "select",
        "majorId, majorName, leaderId",
        "from major",
        "where majorId = #{majorid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="majorId", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="majorName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="leaderId", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    Major selectByPrimaryKey(String majorid);

    @UpdateProvider(type=MajorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    @UpdateProvider(type=MajorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    @UpdateProvider(type=MajorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Major record);

    @Update({
        "update major",
        "set majorName = #{majorname,jdbcType=VARCHAR},",
          "leaderId = #{leaderid,jdbcType=INTEGER}",
        "where majorId = #{majorid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Major record);
}