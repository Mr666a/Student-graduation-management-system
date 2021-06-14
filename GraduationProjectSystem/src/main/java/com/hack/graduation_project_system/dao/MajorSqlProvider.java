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

import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.MajorExample.Criteria;
import com.hack.graduation_project_system.domain.MajorExample.Criterion;
import com.hack.graduation_project_system.domain.MajorExample;
import java.util.List;
import java.util.Map;

public class MajorSqlProvider {

    public String countByExample(MajorExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("major");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(MajorExample example) {
        BEGIN();
        DELETE_FROM("major");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Major record) {
        BEGIN();
        INSERT_INTO("major");
        
        if (record.getMajorid() != null) {
            VALUES("majorId", "#{majorid,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorname() != null) {
            VALUES("majorName", "#{majorname,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaderid() != null) {
            VALUES("leaderId", "#{leaderid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(MajorExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("majorId");
        } else {
            SELECT("majorId");
        }
        SELECT("majorName");
        SELECT("leaderId");
        FROM("major");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Major record = (Major) parameter.get("record");
        MajorExample example = (MajorExample) parameter.get("example");
        
        BEGIN();
        UPDATE("major");
        
        if (record.getMajorid() != null) {
            SET("majorId = #{record.majorid,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorname() != null) {
            SET("majorName = #{record.majorname,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaderid() != null) {
            SET("leaderId = #{record.leaderid,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("major");
        
        SET("majorId = #{record.majorid,jdbcType=VARCHAR}");
        SET("majorName = #{record.majorname,jdbcType=VARCHAR}");
        SET("leaderId = #{record.leaderid,jdbcType=INTEGER}");
        
        MajorExample example = (MajorExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Major record) {
        BEGIN();
        UPDATE("major");
        
        if (record.getMajorname() != null) {
            SET("majorName = #{majorname,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaderid() != null) {
            SET("leaderId = #{leaderid,jdbcType=INTEGER}");
        }
        
        WHERE("majorId = #{majorid,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(MajorExample example, boolean includeExamplePhrase) {
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