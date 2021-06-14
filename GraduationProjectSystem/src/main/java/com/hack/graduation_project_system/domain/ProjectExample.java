package com.hack.graduation_project_system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProjectidIsNull() {
            addCriterion("projectId is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("projectId is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(Integer value) {
            addCriterion("projectId =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(Integer value) {
            addCriterion("projectId <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(Integer value) {
            addCriterion("projectId >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectId >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(Integer value) {
            addCriterion("projectId <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(Integer value) {
            addCriterion("projectId <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<Integer> values) {
            addCriterion("projectId in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<Integer> values) {
            addCriterion("projectId not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(Integer value1, Integer value2) {
            addCriterion("projectId between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("projectId not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNull() {
            addCriterion("projectName is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("projectName is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("projectName =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("projectName <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("projectName >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("projectName >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("projectName <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("projectName <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("projectName like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("projectName not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("projectName in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("projectName not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("projectName between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("projectName not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andNeedIsNull() {
            addCriterion("need is null");
            return (Criteria) this;
        }

        public Criteria andNeedIsNotNull() {
            addCriterion("need is not null");
            return (Criteria) this;
        }

        public Criteria andNeedEqualTo(String value) {
            addCriterion("need =", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedNotEqualTo(String value) {
            addCriterion("need <>", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedGreaterThan(String value) {
            addCriterion("need >", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedGreaterThanOrEqualTo(String value) {
            addCriterion("need >=", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedLessThan(String value) {
            addCriterion("need <", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedLessThanOrEqualTo(String value) {
            addCriterion("need <=", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedLike(String value) {
            addCriterion("need like", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedNotLike(String value) {
            addCriterion("need not like", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedIn(List<String> values) {
            addCriterion("need in", values, "need");
            return (Criteria) this;
        }

        public Criteria andNeedNotIn(List<String> values) {
            addCriterion("need not in", values, "need");
            return (Criteria) this;
        }

        public Criteria andNeedBetween(String value1, String value2) {
            addCriterion("need between", value1, value2, "need");
            return (Criteria) this;
        }

        public Criteria andNeedNotBetween(String value1, String value2) {
            addCriterion("need not between", value1, value2, "need");
            return (Criteria) this;
        }

        public Criteria andSubmitidIsNull() {
            addCriterion("submitId is null");
            return (Criteria) this;
        }

        public Criteria andSubmitidIsNotNull() {
            addCriterion("submitId is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitidEqualTo(String value) {
            addCriterion("submitId =", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidNotEqualTo(String value) {
            addCriterion("submitId <>", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidGreaterThan(String value) {
            addCriterion("submitId >", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidGreaterThanOrEqualTo(String value) {
            addCriterion("submitId >=", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidLessThan(String value) {
            addCriterion("submitId <", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidLessThanOrEqualTo(String value) {
            addCriterion("submitId <=", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidLike(String value) {
            addCriterion("submitId like", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidNotLike(String value) {
            addCriterion("submitId not like", value, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidIn(List<String> values) {
            addCriterion("submitId in", values, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidNotIn(List<String> values) {
            addCriterion("submitId not in", values, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidBetween(String value1, String value2) {
            addCriterion("submitId between", value1, value2, "submitid");
            return (Criteria) this;
        }

        public Criteria andSubmitidNotBetween(String value1, String value2) {
            addCriterion("submitId not between", value1, value2, "submitid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andChooseIsNull() {
            addCriterion("choose is null");
            return (Criteria) this;
        }

        public Criteria andChooseIsNotNull() {
            addCriterion("choose is not null");
            return (Criteria) this;
        }

        //修改+1
        public Criteria andChooseEqualTo(Boolean value) {
            addCriterion("choose =", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotEqualTo(Boolean value) {
            addCriterion("choose <>", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseGreaterThan(Boolean value) {
            addCriterion("choose >", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("choose >=", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLessThan(Boolean value) {
            addCriterion("choose <", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLessThanOrEqualTo(Boolean value) {
            addCriterion("choose <=", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseIn(List<Boolean> values) {
            addCriterion("choose in", values, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotIn(List<Boolean> values) {
            addCriterion("choose not in", values, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseBetween(Boolean value1, Boolean value2) {
            addCriterion("choose between", value1, value2, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("choose not between", value1, value2, "choose");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectIsNull() {
            addCriterion("specialProject is null");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectIsNotNull() {
            addCriterion("specialProject is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectEqualTo(Boolean value) {
            addCriterion("specialProject =", value, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectNotEqualTo(Boolean value) {
            addCriterion("specialProject <>", value, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectGreaterThan(Boolean value) {
            addCriterion("specialProject >", value, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectGreaterThanOrEqualTo(Boolean value) {
            addCriterion("specialProject >=", value, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectLessThan(Boolean value) {
            addCriterion("specialProject <", value, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectLessThanOrEqualTo(Boolean value) {
            addCriterion("specialProject <=", value, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectIn(List<Boolean> values) {
            addCriterion("specialProject in", values, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectNotIn(List<Boolean> values) {
            addCriterion("specialProject not in", values, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectBetween(Boolean value1, Boolean value2) {
            addCriterion("specialProject between", value1, value2, "specialproject");
            return (Criteria) this;
        }

        public Criteria andSpecialprojectNotBetween(Boolean value1, Boolean value2) {
            addCriterion("specialProject not between", value1, value2, "specialproject");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andContentfilenameIsNull() {
            addCriterion("contentFileName is null");
            return (Criteria) this;
        }

        public Criteria andContentfilenameIsNotNull() {
            addCriterion("contentFileName is not null");
            return (Criteria) this;
        }

        public Criteria andContentfilenameEqualTo(String value) {
            addCriterion("contentFileName =", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameNotEqualTo(String value) {
            addCriterion("contentFileName <>", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameGreaterThan(String value) {
            addCriterion("contentFileName >", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameGreaterThanOrEqualTo(String value) {
            addCriterion("contentFileName >=", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameLessThan(String value) {
            addCriterion("contentFileName <", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameLessThanOrEqualTo(String value) {
            addCriterion("contentFileName <=", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameLike(String value) {
            addCriterion("contentFileName like", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameNotLike(String value) {
            addCriterion("contentFileName not like", value, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameIn(List<String> values) {
            addCriterion("contentFileName in", values, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameNotIn(List<String> values) {
            addCriterion("contentFileName not in", values, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameBetween(String value1, String value2) {
            addCriterion("contentFileName between", value1, value2, "contentfilename");
            return (Criteria) this;
        }

        public Criteria andContentfilenameNotBetween(String value1, String value2) {
            addCriterion("contentFileName not between", value1, value2, "contentfilename");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}