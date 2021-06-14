package com.hack.graduation_project_system.dao;

import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.ClassExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClassMapper {
    @SelectProvider(type=ClassSqlProvider.class, method="countByExample")
    int countByExample(ClassExample example);

    @DeleteProvider(type=ClassSqlProvider.class, method="deleteByExample")
    int deleteByExample(ClassExample example);

    @Delete({
        "delete from class",
        "where classId = #{classid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String classid);

    @Insert({
        "insert into class (classId, className)",
        "values (#{classid,jdbcType=VARCHAR}, #{classname,jdbcType=VARCHAR})"
    })
    int insert(Class record);

    @InsertProvider(type=ClassSqlProvider.class, method="insertSelective")
    int insertSelective(Class record);

    @SelectProvider(type=ClassSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="classId", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="className", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Class> selectByExample(ClassExample example);

    @Select({
        "select",
        "classId, className",
        "from class",
        "where classId = #{classid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="classId", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="className", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Class selectByPrimaryKey(String classid);

    @UpdateProvider(type=ClassSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    @UpdateProvider(type=ClassSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    @UpdateProvider(type=ClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Class record);

    @Update({
        "update class",
        "set className = #{classname,jdbcType=VARCHAR}",
        "where classId = #{classid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Class record);
}