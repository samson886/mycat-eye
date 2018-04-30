package io.mycat.eye.agent.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatServerStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatServerStatusExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMycatIdIsNull() {
            addCriterion("mycat_id is null");
            return (Criteria) this;
        }

        public Criteria andMycatIdIsNotNull() {
            addCriterion("mycat_id is not null");
            return (Criteria) this;
        }

        public Criteria andMycatIdEqualTo(Integer value) {
            addCriterion("mycat_id =", value, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdNotEqualTo(Integer value) {
            addCriterion("mycat_id <>", value, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdGreaterThan(Integer value) {
            addCriterion("mycat_id >", value, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mycat_id >=", value, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdLessThan(Integer value) {
            addCriterion("mycat_id <", value, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdLessThanOrEqualTo(Integer value) {
            addCriterion("mycat_id <=", value, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdIn(List<Integer> values) {
            addCriterion("mycat_id in", values, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdNotIn(List<Integer> values) {
            addCriterion("mycat_id not in", values, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdBetween(Integer value1, Integer value2) {
            addCriterion("mycat_id between", value1, value2, "mycatId");
            return (Criteria) this;
        }

        public Criteria andMycatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mycat_id not between", value1, value2, "mycatId");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNull() {
            addCriterion("uptime is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("uptime is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(String value) {
            addCriterion("uptime =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(String value) {
            addCriterion("uptime <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(String value) {
            addCriterion("uptime >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(String value) {
            addCriterion("uptime >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(String value) {
            addCriterion("uptime <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(String value) {
            addCriterion("uptime <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLike(String value) {
            addCriterion("uptime like", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotLike(String value) {
            addCriterion("uptime not like", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<String> values) {
            addCriterion("uptime in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<String> values) {
            addCriterion("uptime not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(String value1, String value2) {
            addCriterion("uptime between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(String value1, String value2) {
            addCriterion("uptime not between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryIsNull() {
            addCriterion("used_memory is null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryIsNotNull() {
            addCriterion("used_memory is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryEqualTo(Long value) {
            addCriterion("used_memory =", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryNotEqualTo(Long value) {
            addCriterion("used_memory <>", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryGreaterThan(Long value) {
            addCriterion("used_memory >", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryGreaterThanOrEqualTo(Long value) {
            addCriterion("used_memory >=", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryLessThan(Long value) {
            addCriterion("used_memory <", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryLessThanOrEqualTo(Long value) {
            addCriterion("used_memory <=", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryIn(List<Long> values) {
            addCriterion("used_memory in", values, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryNotIn(List<Long> values) {
            addCriterion("used_memory not in", values, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryBetween(Long value1, Long value2) {
            addCriterion("used_memory between", value1, value2, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryNotBetween(Long value1, Long value2) {
            addCriterion("used_memory not between", value1, value2, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryIsNull() {
            addCriterion("total_memory is null");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryIsNotNull() {
            addCriterion("total_memory is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryEqualTo(Long value) {
            addCriterion("total_memory =", value, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryNotEqualTo(Long value) {
            addCriterion("total_memory <>", value, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryGreaterThan(Long value) {
            addCriterion("total_memory >", value, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryGreaterThanOrEqualTo(Long value) {
            addCriterion("total_memory >=", value, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryLessThan(Long value) {
            addCriterion("total_memory <", value, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryLessThanOrEqualTo(Long value) {
            addCriterion("total_memory <=", value, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryIn(List<Long> values) {
            addCriterion("total_memory in", values, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryNotIn(List<Long> values) {
            addCriterion("total_memory not in", values, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryBetween(Long value1, Long value2) {
            addCriterion("total_memory between", value1, value2, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andTotalMemoryNotBetween(Long value1, Long value2) {
            addCriterion("total_memory not between", value1, value2, "totalMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryIsNull() {
            addCriterion("max_memory is null");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryIsNotNull() {
            addCriterion("max_memory is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryEqualTo(Long value) {
            addCriterion("max_memory =", value, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryNotEqualTo(Long value) {
            addCriterion("max_memory <>", value, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryGreaterThan(Long value) {
            addCriterion("max_memory >", value, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryGreaterThanOrEqualTo(Long value) {
            addCriterion("max_memory >=", value, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryLessThan(Long value) {
            addCriterion("max_memory <", value, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryLessThanOrEqualTo(Long value) {
            addCriterion("max_memory <=", value, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryIn(List<Long> values) {
            addCriterion("max_memory in", values, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryNotIn(List<Long> values) {
            addCriterion("max_memory not in", values, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryBetween(Long value1, Long value2) {
            addCriterion("max_memory between", value1, value2, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryNotBetween(Long value1, Long value2) {
            addCriterion("max_memory not between", value1, value2, "maxMemory");
            return (Criteria) this;
        }

        public Criteria andReloadTimeIsNull() {
            addCriterion("reload_time is null");
            return (Criteria) this;
        }

        public Criteria andReloadTimeIsNotNull() {
            addCriterion("reload_time is not null");
            return (Criteria) this;
        }

        public Criteria andReloadTimeEqualTo(Long value) {
            addCriterion("reload_time =", value, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeNotEqualTo(Long value) {
            addCriterion("reload_time <>", value, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeGreaterThan(Long value) {
            addCriterion("reload_time >", value, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("reload_time >=", value, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeLessThan(Long value) {
            addCriterion("reload_time <", value, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeLessThanOrEqualTo(Long value) {
            addCriterion("reload_time <=", value, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeIn(List<Long> values) {
            addCriterion("reload_time in", values, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeNotIn(List<Long> values) {
            addCriterion("reload_time not in", values, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeBetween(Long value1, Long value2) {
            addCriterion("reload_time between", value1, value2, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andReloadTimeNotBetween(Long value1, Long value2) {
            addCriterion("reload_time not between", value1, value2, "reloadTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeIsNull() {
            addCriterion("rollback_time is null");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeIsNotNull() {
            addCriterion("rollback_time is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeEqualTo(Long value) {
            addCriterion("rollback_time =", value, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeNotEqualTo(Long value) {
            addCriterion("rollback_time <>", value, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeGreaterThan(Long value) {
            addCriterion("rollback_time >", value, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("rollback_time >=", value, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeLessThan(Long value) {
            addCriterion("rollback_time <", value, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeLessThanOrEqualTo(Long value) {
            addCriterion("rollback_time <=", value, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeIn(List<Long> values) {
            addCriterion("rollback_time in", values, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeNotIn(List<Long> values) {
            addCriterion("rollback_time not in", values, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeBetween(Long value1, Long value2) {
            addCriterion("rollback_time between", value1, value2, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andRollbackTimeNotBetween(Long value1, Long value2) {
            addCriterion("rollback_time not between", value1, value2, "rollbackTime");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNull() {
            addCriterion("charset is null");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNotNull() {
            addCriterion("charset is not null");
            return (Criteria) this;
        }

        public Criteria andCharsetEqualTo(String value) {
            addCriterion("charset =", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotEqualTo(String value) {
            addCriterion("charset <>", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThan(String value) {
            addCriterion("charset >", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThanOrEqualTo(String value) {
            addCriterion("charset >=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThan(String value) {
            addCriterion("charset <", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThanOrEqualTo(String value) {
            addCriterion("charset <=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLike(String value) {
            addCriterion("charset like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotLike(String value) {
            addCriterion("charset not like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetIn(List<String> values) {
            addCriterion("charset in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotIn(List<String> values) {
            addCriterion("charset not in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetBetween(String value1, String value2) {
            addCriterion("charset between", value1, value2, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotBetween(String value1, String value2) {
            addCriterion("charset not between", value1, value2, "charset");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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