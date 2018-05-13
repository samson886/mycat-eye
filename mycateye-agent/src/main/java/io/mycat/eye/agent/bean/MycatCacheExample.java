package io.mycat.eye.agent.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatCacheExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatCacheExample() {
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

        public Criteria andCacheIsNull() {
            addCriterion("cache is null");
            return (Criteria) this;
        }

        public Criteria andCacheIsNotNull() {
            addCriterion("cache is not null");
            return (Criteria) this;
        }

        public Criteria andCacheEqualTo(String value) {
            addCriterion("cache =", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotEqualTo(String value) {
            addCriterion("cache <>", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheGreaterThan(String value) {
            addCriterion("cache >", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheGreaterThanOrEqualTo(String value) {
            addCriterion("cache >=", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheLessThan(String value) {
            addCriterion("cache <", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheLessThanOrEqualTo(String value) {
            addCriterion("cache <=", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheLike(String value) {
            addCriterion("cache like", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotLike(String value) {
            addCriterion("cache not like", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheIn(List<String> values) {
            addCriterion("cache in", values, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotIn(List<String> values) {
            addCriterion("cache not in", values, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheBetween(String value1, String value2) {
            addCriterion("cache between", value1, value2, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotBetween(String value1, String value2) {
            addCriterion("cache not between", value1, value2, "cache");
            return (Criteria) this;
        }

        public Criteria andCMaxIsNull() {
            addCriterion("c_max is null");
            return (Criteria) this;
        }

        public Criteria andCMaxIsNotNull() {
            addCriterion("c_max is not null");
            return (Criteria) this;
        }

        public Criteria andCMaxEqualTo(Integer value) {
            addCriterion("c_max =", value, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxNotEqualTo(Integer value) {
            addCriterion("c_max <>", value, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxGreaterThan(Integer value) {
            addCriterion("c_max >", value, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_max >=", value, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxLessThan(Integer value) {
            addCriterion("c_max <", value, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxLessThanOrEqualTo(Integer value) {
            addCriterion("c_max <=", value, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxIn(List<Integer> values) {
            addCriterion("c_max in", values, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxNotIn(List<Integer> values) {
            addCriterion("c_max not in", values, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxBetween(Integer value1, Integer value2) {
            addCriterion("c_max between", value1, value2, "cMax");
            return (Criteria) this;
        }

        public Criteria andCMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("c_max not between", value1, value2, "cMax");
            return (Criteria) this;
        }

        public Criteria andCurIsNull() {
            addCriterion("cur is null");
            return (Criteria) this;
        }

        public Criteria andCurIsNotNull() {
            addCriterion("cur is not null");
            return (Criteria) this;
        }

        public Criteria andCurEqualTo(Integer value) {
            addCriterion("cur =", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurNotEqualTo(Integer value) {
            addCriterion("cur <>", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurGreaterThan(Integer value) {
            addCriterion("cur >", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurGreaterThanOrEqualTo(Integer value) {
            addCriterion("cur >=", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurLessThan(Integer value) {
            addCriterion("cur <", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurLessThanOrEqualTo(Integer value) {
            addCriterion("cur <=", value, "cur");
            return (Criteria) this;
        }

        public Criteria andCurIn(List<Integer> values) {
            addCriterion("cur in", values, "cur");
            return (Criteria) this;
        }

        public Criteria andCurNotIn(List<Integer> values) {
            addCriterion("cur not in", values, "cur");
            return (Criteria) this;
        }

        public Criteria andCurBetween(Integer value1, Integer value2) {
            addCriterion("cur between", value1, value2, "cur");
            return (Criteria) this;
        }

        public Criteria andCurNotBetween(Integer value1, Integer value2) {
            addCriterion("cur not between", value1, value2, "cur");
            return (Criteria) this;
        }

        public Criteria andAccessIsNull() {
            addCriterion("access is null");
            return (Criteria) this;
        }

        public Criteria andAccessIsNotNull() {
            addCriterion("access is not null");
            return (Criteria) this;
        }

        public Criteria andAccessEqualTo(Integer value) {
            addCriterion("access =", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotEqualTo(Integer value) {
            addCriterion("access <>", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessGreaterThan(Integer value) {
            addCriterion("access >", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("access >=", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessLessThan(Integer value) {
            addCriterion("access <", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessLessThanOrEqualTo(Integer value) {
            addCriterion("access <=", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessIn(List<Integer> values) {
            addCriterion("access in", values, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotIn(List<Integer> values) {
            addCriterion("access not in", values, "access");
            return (Criteria) this;
        }

        public Criteria andAccessBetween(Integer value1, Integer value2) {
            addCriterion("access between", value1, value2, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotBetween(Integer value1, Integer value2) {
            addCriterion("access not between", value1, value2, "access");
            return (Criteria) this;
        }

        public Criteria andHitIsNull() {
            addCriterion("hit is null");
            return (Criteria) this;
        }

        public Criteria andHitIsNotNull() {
            addCriterion("hit is not null");
            return (Criteria) this;
        }

        public Criteria andHitEqualTo(Integer value) {
            addCriterion("hit =", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitNotEqualTo(Integer value) {
            addCriterion("hit <>", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitGreaterThan(Integer value) {
            addCriterion("hit >", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitGreaterThanOrEqualTo(Integer value) {
            addCriterion("hit >=", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitLessThan(Integer value) {
            addCriterion("hit <", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitLessThanOrEqualTo(Integer value) {
            addCriterion("hit <=", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitIn(List<Integer> values) {
            addCriterion("hit in", values, "hit");
            return (Criteria) this;
        }

        public Criteria andHitNotIn(List<Integer> values) {
            addCriterion("hit not in", values, "hit");
            return (Criteria) this;
        }

        public Criteria andHitBetween(Integer value1, Integer value2) {
            addCriterion("hit between", value1, value2, "hit");
            return (Criteria) this;
        }

        public Criteria andHitNotBetween(Integer value1, Integer value2) {
            addCriterion("hit not between", value1, value2, "hit");
            return (Criteria) this;
        }

        public Criteria andPutIsNull() {
            addCriterion("put is null");
            return (Criteria) this;
        }

        public Criteria andPutIsNotNull() {
            addCriterion("put is not null");
            return (Criteria) this;
        }

        public Criteria andPutEqualTo(Integer value) {
            addCriterion("put =", value, "put");
            return (Criteria) this;
        }

        public Criteria andPutNotEqualTo(Integer value) {
            addCriterion("put <>", value, "put");
            return (Criteria) this;
        }

        public Criteria andPutGreaterThan(Integer value) {
            addCriterion("put >", value, "put");
            return (Criteria) this;
        }

        public Criteria andPutGreaterThanOrEqualTo(Integer value) {
            addCriterion("put >=", value, "put");
            return (Criteria) this;
        }

        public Criteria andPutLessThan(Integer value) {
            addCriterion("put <", value, "put");
            return (Criteria) this;
        }

        public Criteria andPutLessThanOrEqualTo(Integer value) {
            addCriterion("put <=", value, "put");
            return (Criteria) this;
        }

        public Criteria andPutIn(List<Integer> values) {
            addCriterion("put in", values, "put");
            return (Criteria) this;
        }

        public Criteria andPutNotIn(List<Integer> values) {
            addCriterion("put not in", values, "put");
            return (Criteria) this;
        }

        public Criteria andPutBetween(Integer value1, Integer value2) {
            addCriterion("put between", value1, value2, "put");
            return (Criteria) this;
        }

        public Criteria andPutNotBetween(Integer value1, Integer value2) {
            addCriterion("put not between", value1, value2, "put");
            return (Criteria) this;
        }

        public Criteria andLastAccessIsNull() {
            addCriterion("last_access is null");
            return (Criteria) this;
        }

        public Criteria andLastAccessIsNotNull() {
            addCriterion("last_access is not null");
            return (Criteria) this;
        }

        public Criteria andLastAccessEqualTo(Integer value) {
            addCriterion("last_access =", value, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessNotEqualTo(Integer value) {
            addCriterion("last_access <>", value, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessGreaterThan(Integer value) {
            addCriterion("last_access >", value, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_access >=", value, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessLessThan(Integer value) {
            addCriterion("last_access <", value, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessLessThanOrEqualTo(Integer value) {
            addCriterion("last_access <=", value, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessIn(List<Integer> values) {
            addCriterion("last_access in", values, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessNotIn(List<Integer> values) {
            addCriterion("last_access not in", values, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessBetween(Integer value1, Integer value2) {
            addCriterion("last_access between", value1, value2, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastAccessNotBetween(Integer value1, Integer value2) {
            addCriterion("last_access not between", value1, value2, "lastAccess");
            return (Criteria) this;
        }

        public Criteria andLastPutIsNull() {
            addCriterion("last_put is null");
            return (Criteria) this;
        }

        public Criteria andLastPutIsNotNull() {
            addCriterion("last_put is not null");
            return (Criteria) this;
        }

        public Criteria andLastPutEqualTo(Integer value) {
            addCriterion("last_put =", value, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutNotEqualTo(Integer value) {
            addCriterion("last_put <>", value, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutGreaterThan(Integer value) {
            addCriterion("last_put >", value, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_put >=", value, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutLessThan(Integer value) {
            addCriterion("last_put <", value, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutLessThanOrEqualTo(Integer value) {
            addCriterion("last_put <=", value, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutIn(List<Integer> values) {
            addCriterion("last_put in", values, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutNotIn(List<Integer> values) {
            addCriterion("last_put not in", values, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutBetween(Integer value1, Integer value2) {
            addCriterion("last_put between", value1, value2, "lastPut");
            return (Criteria) this;
        }

        public Criteria andLastPutNotBetween(Integer value1, Integer value2) {
            addCriterion("last_put not between", value1, value2, "lastPut");
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