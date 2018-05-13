package io.mycat.eye.web.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatSqlExecuteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatSqlExecuteExample() {
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

        public Criteria andSqlIdIsNull() {
            addCriterion("sql_id is null");
            return (Criteria) this;
        }

        public Criteria andSqlIdIsNotNull() {
            addCriterion("sql_id is not null");
            return (Criteria) this;
        }

        public Criteria andSqlIdEqualTo(Long value) {
            addCriterion("sql_id =", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdNotEqualTo(Long value) {
            addCriterion("sql_id <>", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdGreaterThan(Long value) {
            addCriterion("sql_id >", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sql_id >=", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdLessThan(Long value) {
            addCriterion("sql_id <", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdLessThanOrEqualTo(Long value) {
            addCriterion("sql_id <=", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdIn(List<Long> values) {
            addCriterion("sql_id in", values, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdNotIn(List<Long> values) {
            addCriterion("sql_id not in", values, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdBetween(Long value1, Long value2) {
            addCriterion("sql_id between", value1, value2, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdNotBetween(Long value1, Long value2) {
            addCriterion("sql_id not between", value1, value2, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteIsNull() {
            addCriterion("sql_execute is null");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteIsNotNull() {
            addCriterion("sql_execute is not null");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteEqualTo(Long value) {
            addCriterion("sql_execute =", value, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteNotEqualTo(Long value) {
            addCriterion("sql_execute <>", value, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteGreaterThan(Long value) {
            addCriterion("sql_execute >", value, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteGreaterThanOrEqualTo(Long value) {
            addCriterion("sql_execute >=", value, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteLessThan(Long value) {
            addCriterion("sql_execute <", value, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteLessThanOrEqualTo(Long value) {
            addCriterion("sql_execute <=", value, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteIn(List<Long> values) {
            addCriterion("sql_execute in", values, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteNotIn(List<Long> values) {
            addCriterion("sql_execute not in", values, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteBetween(Long value1, Long value2) {
            addCriterion("sql_execute between", value1, value2, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlExecuteNotBetween(Long value1, Long value2) {
            addCriterion("sql_execute not between", value1, value2, "sqlExecute");
            return (Criteria) this;
        }

        public Criteria andSqlTimeIsNull() {
            addCriterion("sql_time is null");
            return (Criteria) this;
        }

        public Criteria andSqlTimeIsNotNull() {
            addCriterion("sql_time is not null");
            return (Criteria) this;
        }

        public Criteria andSqlTimeEqualTo(Double value) {
            addCriterion("sql_time =", value, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeNotEqualTo(Double value) {
            addCriterion("sql_time <>", value, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeGreaterThan(Double value) {
            addCriterion("sql_time >", value, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("sql_time >=", value, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeLessThan(Double value) {
            addCriterion("sql_time <", value, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeLessThanOrEqualTo(Double value) {
            addCriterion("sql_time <=", value, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeIn(List<Double> values) {
            addCriterion("sql_time in", values, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeNotIn(List<Double> values) {
            addCriterion("sql_time not in", values, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeBetween(Double value1, Double value2) {
            addCriterion("sql_time between", value1, value2, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andSqlTimeNotBetween(Double value1, Double value2) {
            addCriterion("sql_time not between", value1, value2, "sqlTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeIsNull() {
            addCriterion("max_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxTimeIsNotNull() {
            addCriterion("max_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTimeEqualTo(Double value) {
            addCriterion("max_time =", value, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeNotEqualTo(Double value) {
            addCriterion("max_time <>", value, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeGreaterThan(Double value) {
            addCriterion("max_time >", value, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("max_time >=", value, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLessThan(Double value) {
            addCriterion("max_time <", value, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeLessThanOrEqualTo(Double value) {
            addCriterion("max_time <=", value, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeIn(List<Double> values) {
            addCriterion("max_time in", values, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeNotIn(List<Double> values) {
            addCriterion("max_time not in", values, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeBetween(Double value1, Double value2) {
            addCriterion("max_time between", value1, value2, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMaxTimeNotBetween(Double value1, Double value2) {
            addCriterion("max_time not between", value1, value2, "maxTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeIsNull() {
            addCriterion("min_time is null");
            return (Criteria) this;
        }

        public Criteria andMinTimeIsNotNull() {
            addCriterion("min_time is not null");
            return (Criteria) this;
        }

        public Criteria andMinTimeEqualTo(Double value) {
            addCriterion("min_time =", value, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeNotEqualTo(Double value) {
            addCriterion("min_time <>", value, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeGreaterThan(Double value) {
            addCriterion("min_time >", value, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("min_time >=", value, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeLessThan(Double value) {
            addCriterion("min_time <", value, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeLessThanOrEqualTo(Double value) {
            addCriterion("min_time <=", value, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeIn(List<Double> values) {
            addCriterion("min_time in", values, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeNotIn(List<Double> values) {
            addCriterion("min_time not in", values, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeBetween(Double value1, Double value2) {
            addCriterion("min_time between", value1, value2, "minTime");
            return (Criteria) this;
        }

        public Criteria andMinTimeNotBetween(Double value1, Double value2) {
            addCriterion("min_time not between", value1, value2, "minTime");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Integer value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Integer value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Integer value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Integer value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Integer value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Integer> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Integer> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Integer value1, Integer value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNull() {
            addCriterion("collect_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNotNull() {
            addCriterion("collect_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeEqualTo(Long value) {
            addCriterion("collect_time =", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotEqualTo(Long value) {
            addCriterion("collect_time <>", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThan(Long value) {
            addCriterion("collect_time >", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("collect_time >=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThan(Long value) {
            addCriterion("collect_time <", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThanOrEqualTo(Long value) {
            addCriterion("collect_time <=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIn(List<Long> values) {
            addCriterion("collect_time in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotIn(List<Long> values) {
            addCriterion("collect_time not in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeBetween(Long value1, Long value2) {
            addCriterion("collect_time between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotBetween(Long value1, Long value2) {
            addCriterion("collect_time not between", value1, value2, "collectTime");
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