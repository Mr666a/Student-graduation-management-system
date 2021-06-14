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

import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.ProjectExample.Criteria;
import com.hack.graduation_project_system.domain.ProjectExample.Criterion;
import com.hack.graduation_project_system.domain.ProjectExample;
import java.util.List;
import java.util.Map;

public class ProjectSqlProvider {

    public String countByExample(ProjectExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("project");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ProjectExample example) {
        BEGIN();
        DELETE_FROM("project");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Project record) {
        BEGIN();
        INSERT_INTO("project");
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getProjectname() != null) {
            VALUES("projectName", "#{projectname,jdbcType=VARCHAR}");
        }
        
        if (record.getNeed() != null) {
            VALUES("need", "#{need,jdbcType=VARCHAR}");
        }
        
        if (record.getSubmitid() != null) {
            VALUES("submitId", "#{submitid,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=BIT}");
        }
        
        if (record.getChoose() != null) {
            VALUES("choose", "#{choose,jdbcType=BIT}");
        }
        
        if (record.getSpecialproject() != null) {
            VALUES("specialProject", "#{specialproject,jdbcType=BIT}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContentfilename() != null) {
            VALUES("contentFileName", "#{contentfilename,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ProjectExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("projectId");
        } else {
            SELECT("projectId");
        }
        SELECT("projectName");
        SELECT("need");
        SELECT("submitId");
        SELECT("status");
        SELECT("choose");
        SELECT("specialProject");
        SELECT("time");
        SELECT("contentFileName");
        FROM("project");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Project record = (Project) parameter.get("record");
        ProjectExample example = (ProjectExample) parameter.get("example");
        
        BEGIN();
        UPDATE("project");
        
        if (record.getProjectid() != null) {
            SET("projectId = #{record.projectid,jdbcType=INTEGER}");
        }
        
        if (record.getProjectname() != null) {
            SET("projectName = #{record.projectname,jdbcType=VARCHAR}");
        }
        
        if (record.getNeed() != null) {
            SET("need = #{record.need,jdbcType=VARCHAR}");
        }
        
        if (record.getSubmitid() != null) {
            SET("submitId = #{record.submitid,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=BIT}");
        }
        
        if (record.getChoose() != null) {
            SET("choose = #{record.choose,jdbcType=BIT}");
        }
        
        if (record.getSpecialproject() != null) {
            SET("specialProject = #{record.specialproject,jdbcType=BIT}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContentfilename() != null) {
            SET("contentFileName = #{record.contentfilename,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("project");
        
        SET("projectId = #{record.projectid,jdbcType=INTEGER}");
        SET("projectName = #{record.projectname,jdbcType=VARCHAR}");
        SET("need = #{record.need,jdbcType=VARCHAR}");
        SET("submitId = #{record.submitid,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=BIT}");
        SET("choose = #{record.choose,jdbcType=BIT}");
        SET("specialProject = #{record.specialproject,jdbcType=BIT}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        SET("contentFileName = #{record.contentfilename,jdbcType=VARCHAR}");
        
        ProjectExample example = (ProjectExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Project record) {
        BEGIN();
        UPDATE("project");
        
        if (record.getProjectname() != null) {
            SET("projectName = #{projectname,jdbcType=VARCHAR}");
        }
        
        if (record.getNeed() != null) {
            SET("need = #{need,jdbcType=VARCHAR}");
        }
        
        if (record.getSubmitid() != null) {
            SET("submitId = #{submitid,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=BIT}");
        }
        
        if (record.getChoose() != null) {
            SET("choose = #{choose,jdbcType=BIT}");
        }
        
        if (record.getSpecialproject() != null) {
            SET("specialProject = #{specialproject,jdbcType=BIT}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContentfilename() != null) {
            SET("contentFileName = #{contentfilename,jdbcType=VARCHAR}");
        }
        
        WHERE("projectId = #{projectid,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(ProjectExample example, boolean includeExamplePhrase) {
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