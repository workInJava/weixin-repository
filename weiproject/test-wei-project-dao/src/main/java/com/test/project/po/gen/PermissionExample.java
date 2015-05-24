package com.test.project.po.gen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPermissionIdIsNull() {
            addCriterion("PERMISSION_ID is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("PERMISSION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(String value) {
            addCriterion("PERMISSION_ID =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(String value) {
            addCriterion("PERMISSION_ID <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(String value) {
            addCriterion("PERMISSION_ID >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_ID >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(String value) {
            addCriterion("PERMISSION_ID <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_ID <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLike(String value) {
            addCriterion("PERMISSION_ID like", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotLike(String value) {
            addCriterion("PERMISSION_ID not like", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<String> values) {
            addCriterion("PERMISSION_ID in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<String> values) {
            addCriterion("PERMISSION_ID not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(String value1, String value2) {
            addCriterion("PERMISSION_ID between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_ID not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNull() {
            addCriterion("PERMISSION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("PERMISSION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("PERMISSION_NAME =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("PERMISSION_NAME <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("PERMISSION_NAME >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_NAME >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("PERMISSION_NAME <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_NAME <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("PERMISSION_NAME like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("PERMISSION_NAME not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("PERMISSION_NAME in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("PERMISSION_NAME not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("PERMISSION_NAME between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_NAME not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionIsNull() {
            addCriterion("PERMISSION_DECRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionIsNotNull() {
            addCriterion("PERMISSION_DECRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionEqualTo(String value) {
            addCriterion("PERMISSION_DECRIPTION =", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionNotEqualTo(String value) {
            addCriterion("PERMISSION_DECRIPTION <>", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionGreaterThan(String value) {
            addCriterion("PERMISSION_DECRIPTION >", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_DECRIPTION >=", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionLessThan(String value) {
            addCriterion("PERMISSION_DECRIPTION <", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_DECRIPTION <=", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionLike(String value) {
            addCriterion("PERMISSION_DECRIPTION like", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionNotLike(String value) {
            addCriterion("PERMISSION_DECRIPTION not like", value, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionIn(List<String> values) {
            addCriterion("PERMISSION_DECRIPTION in", values, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionNotIn(List<String> values) {
            addCriterion("PERMISSION_DECRIPTION not in", values, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionBetween(String value1, String value2) {
            addCriterion("PERMISSION_DECRIPTION between", value1, value2, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionDecriptionNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_DECRIPTION not between", value1, value2, "permissionDecription");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderIsNull() {
            addCriterion("PERMISSION_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderIsNotNull() {
            addCriterion("PERMISSION_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderEqualTo(BigDecimal value) {
            addCriterion("PERMISSION_ORDER =", value, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderNotEqualTo(BigDecimal value) {
            addCriterion("PERMISSION_ORDER <>", value, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderGreaterThan(BigDecimal value) {
            addCriterion("PERMISSION_ORDER >", value, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PERMISSION_ORDER >=", value, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderLessThan(BigDecimal value) {
            addCriterion("PERMISSION_ORDER <", value, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PERMISSION_ORDER <=", value, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderIn(List<BigDecimal> values) {
            addCriterion("PERMISSION_ORDER in", values, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderNotIn(List<BigDecimal> values) {
            addCriterion("PERMISSION_ORDER not in", values, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERMISSION_ORDER between", value1, value2, "permissionOrder");
            return (Criteria) this;
        }

        public Criteria andPermissionOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERMISSION_ORDER not between", value1, value2, "permissionOrder");
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