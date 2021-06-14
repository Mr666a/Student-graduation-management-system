package com.hack.graduation_project_system.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.domain.StudentExample.Criteria;
import com.hack.graduation_project_system.domain.StudentExample.Criterion;
import com.hack.graduation_project_system.domain.StudentExample;
import java.util.List;
import java.util.Map;

public class StudentSqlProvider {

    public String countByExample(StudentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("student");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(StudentExample example) {
        BEGIN();
        DELETE_FROM("student");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Student record) {
        BEGIN();
        INSERT_INTO("student");
        
        if (record.getStudentid() != null) {
            VALUES("studentId", "#{studentid,jdbcType=INTEGER}");
        }
        
        if (record.getStudentname() != null) {
            VALUES("studentName", "#{studentname,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("gender", "#{gender,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorid() != null) {
            VALUES("majorId", "#{majorid,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getClassid() != null) {
            VALUES("classId", "#{classid,jdbcType=VARCHAR}");
        }
        
        if (record.getGraduationdate() != null) {
            VALUES("graduationDate", "#{graduationdate,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            VALUES("grade", "#{grade,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(StudentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("studentId");
        } else {
            SELECT("studentId");
        }
        SELECT("studentName");
        SELECT("password");
        SELECT("gender");
        SELECT("majorId");
        SELECT("projectId");
        SELECT("classId");
        SELECT("graduationDate");
        SELECT("email");
        SELECT("phone");
        SELECT("id");
        SELECT("grade");
        FROM("student");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Student record = (Student) parameter.get("record");
        StudentExample example = (StudentExample) parameter.get("example");
        
        BEGIN();
        UPDATE("student");
        
        if (record.getStudentid() != null) {
            SET("studentId = #{record.studentid,jdbcType=INTEGER}");
        }
        
        if (record.getStudentname() != null) {
            SET("studentName = #{record.studentname,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{record.gender,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorid() != null) {
            SET("majorId = #{record.majorid,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectid() != null) {
            SET("projectId = #{record.projectid,jdbcType=INTEGER}");
        }
        
        if (record.getClassid() != null) {
            SET("classId = #{record.classid,jdbcType=VARCHAR}");
        }
        
        if (record.getGraduationdate() != null) {
            SET("graduationDate = #{record.graduationdate,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            SET("grade = #{record.grade,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("student");
        
        SET("studentId = #{record.studentid,jdbcType=INTEGER}");
        SET("studentName = #{record.studentname,jdbcType=VARCHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("gender = #{record.gender,jdbcType=VARCHAR}");
        SET("majorId = #{record.majorid,jdbcType=VARCHAR}");
        SET("projectId = #{record.projectid,jdbcType=INTEGER}");
        SET("classId = #{record.classid,jdbcType=VARCHAR}");
        SET("graduationDate = #{record.graduationdate,jdbcType=INTEGER}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("phone = #{record.phone,jdbcType=VARCHAR}");
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("grade = #{record.grade,jdbcType=INTEGER}");
        
        StudentExample example = (StudentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Student record) {
        BEGIN();
        UPDATE("student");
        
        if (record.getStudentname() != null) {
            SET("studentName = #{studentname,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{gender,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorid() != null) {
            SET("majorId = #{majorid,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getClassid() != null) {
            SET("classId = #{classid,jdbcType=VARCHAR}");
        }
        
        if (record.getGraduationdate() != null) {
            SET("graduationDate = #{graduationdate,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getId() != null) {
            SET("id = #{id,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            SET("grade = #{grade,jdbcType=INTEGER}");
        }
        
        WHERE("studentId = #{studentid,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(StudentExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}