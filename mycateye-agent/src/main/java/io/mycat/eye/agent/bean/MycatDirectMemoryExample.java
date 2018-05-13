package io.mycat.eye.agent.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatDirectMemoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatDirectMemoryExample() {
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

        public Criteria andThreadIdIsNull() {
            addCriterion("thread_id is null");
            return (Criteria) this;
        }

        public Criteria andThreadIdIsNotNull() {
            addCriterion("thread_id is not null");
            return (Criteria) this;
        }

        public Criteria andThreadIdEqualTo(Long value) {
            addCriterion("thread_id =", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotEqualTo(Long value) {
            addCriterion("thread_id <>", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdGreaterThan(Long value) {
            addCriterion("thread_id >", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("thread_id >=", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdLessThan(Long value) {
            addCriterion("thread_id <", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdLessThanOrEqualTo(Long value) {
            addCriterion("thread_id <=", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdIn(List<Long> values) {
            addCriterion("thread_id in", values, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotIn(List<Long> values) {
            addCriterion("thread_id not in", values, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdBetween(Long value1, Long value2) {
            addCriterion("thread_id between", value1, value2, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotBetween(Long value1, Long value2) {
            addCriterion("thread_id not between", value1, value2, "threadId");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeIsNull() {
            addCriterion("mem_use_type is null");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeIsNotNull() {
            addCriterion("mem_use_type is not null");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeEqualTo(String value) {
            addCriterion("mem_use_type =", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeNotEqualTo(String value) {
            addCriterion("mem_use_type <>", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeGreaterThan(String value) {
            addCriterion("mem_use_type >", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mem_use_type >=", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeLessThan(String value) {
            addCriterion("mem_use_type <", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeLessThanOrEqualTo(String value) {
            addCriterion("mem_use_type <=", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeLike(String value) {
            addCriterion("mem_use_type like", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeNotLike(String value) {
            addCriterion("mem_use_type not like", value, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeIn(List<String> values) {
            addCriterion("mem_use_type in", values, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeNotIn(List<String> values) {
            addCriterion("mem_use_type not in", values, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeBetween(String value1, String value2) {
            addCriterion("mem_use_type between", value1, value2, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMemUseTypeNotBetween(String value1, String value2) {
            addCriterion("mem_use_type not between", value1, value2, "memUseType");
            return (Criteria) this;
        }

        public Criteria andMSizeIsNull() {
            addCriterion("m_size is null");
            return (Criteria) this;
        }

        public Criteria andMSizeIsNotNull() {
            addCriterion("m_size is not null");
            return (Criteria) this;
        }

        public Criteria andMSizeEqualTo(String value) {
            addCriterion("m_size =", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeNotEqualTo(String value) {
            addCriterion("m_size <>", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeGreaterThan(String value) {
            addCriterion("m_size >", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeGreaterThanOrEqualTo(String value) {
            addCriterion("m_size >=", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeLessThan(String value) {
            addCriterion("m_size <", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeLessThanOrEqualTo(String value) {
            addCriterion("m_size <=", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeLike(String value) {
            addCriterion("m_size like", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeNotLike(String value) {
            addCriterion("m_size not like", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeIn(List<String> values) {
            addCriterion("m_size in", values, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeNotIn(List<String> values) {
            addCriterion("m_size not in", values, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeBetween(String value1, String value2) {
            addCriterion("m_size between", value1, value2, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeNotBetween(String value1, String value2) {
            addCriterion("m_size not between", value1, value2, "mSize");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedIsNull() {
            addCriterion("mdirect_memory_maxed is null");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedIsNotNull() {
            addCriterion("mdirect_memory_maxed is not null");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedEqualTo(String value) {
            addCriterion("mdirect_memory_maxed =", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotEqualTo(String value) {
            addCriterion("mdirect_memory_maxed <>", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedGreaterThan(String value) {
            addCriterion("mdirect_memory_maxed >", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedGreaterThanOrEqualTo(String value) {
            addCriterion("mdirect_memory_maxed >=", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedLessThan(String value) {
            addCriterion("mdirect_memory_maxed <", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedLessThanOrEqualTo(String value) {
            addCriterion("mdirect_memory_maxed <=", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedLike(String value) {
            addCriterion("mdirect_memory_maxed like", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotLike(String value) {
            addCriterion("mdirect_memory_maxed not like", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedIn(List<String> values) {
            addCriterion("mdirect_memory_maxed in", values, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotIn(List<String> values) {
            addCriterion("mdirect_memory_maxed not in", values, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedBetween(String value1, String value2) {
            addCriterion("mdirect_memory_maxed between", value1, value2, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotBetween(String value1, String value2) {
            addCriterion("mdirect_memory_maxed not between", value1, value2, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedIsNull() {
            addCriterion("direct_memory_used is null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedIsNotNull() {
            addCriterion("direct_memory_used is not null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedEqualTo(String value) {
            addCriterion("direct_memory_used =", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotEqualTo(String value) {
            addCriterion("direct_memory_used <>", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedGreaterThan(String value) {
            addCriterion("direct_memory_used >", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedGreaterThanOrEqualTo(String value) {
            addCriterion("direct_memory_used >=", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedLessThan(String value) {
            addCriterion("direct_memory_used <", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedLessThanOrEqualTo(String value) {
            addCriterion("direct_memory_used <=", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedLike(String value) {
            addCriterion("direct_memory_used like", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotLike(String value) {
            addCriterion("direct_memory_used not like", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedIn(List<String> values) {
            addCriterion("direct_memory_used in", values, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotIn(List<String> values) {
            addCriterion("direct_memory_used not in", values, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedBetween(String value1, String value2) {
            addCriterion("direct_memory_used between", value1, value2, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotBetween(String value1, String value2) {
            addCriterion("direct_memory_used not between", value1, value2, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableIsNull() {
            addCriterion("direct_memory_available is null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableIsNotNull() {
            addCriterion("direct_memory_available is not null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableEqualTo(String value) {
            addCriterion("direct_memory_available =", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotEqualTo(String value) {
            addCriterion("direct_memory_available <>", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableGreaterThan(String value) {
            addCriterion("direct_memory_available >", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableGreaterThanOrEqualTo(String value) {
            addCriterion("direct_memory_available >=", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableLessThan(String value) {
            addCriterion("direct_memory_available <", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableLessThanOrEqualTo(String value) {
            addCriterion("direct_memory_available <=", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableLike(String value) {
            addCriterion("direct_memory_available like", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotLike(String value) {
            addCriterion("direct_memory_available not like", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableIn(List<String> values) {
            addCriterion("direct_memory_available in", values, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotIn(List<String> values) {
            addCriterion("direct_memory_available not in", values, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableBetween(String value1, String value2) {
            addCriterion("direct_memory_available between", value1, value2, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotBetween(String value1, String value2) {
            addCriterion("direct_memory_available not between", value1, value2, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionIsNull() {
            addCriterion("safety_fraction is null");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionIsNotNull() {
            addCriterion("safety_fraction is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionEqualTo(Float value) {
            addCriterion("safety_fraction =", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionNotEqualTo(Float value) {
            addCriterion("safety_fraction <>", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionGreaterThan(Float value) {
            addCriterion("safety_fraction >", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionGreaterThanOrEqualTo(Float value) {
            addCriterion("safety_fraction >=", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionLessThan(Float value) {
            addCriterion("safety_fraction <", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionLessThanOrEqualTo(Float value) {
            addCriterion("safety_fraction <=", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionIn(List<Float> values) {
            addCriterion("safety_fraction in", values, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionNotIn(List<Float> values) {
            addCriterion("safety_fraction not in", values, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionBetween(Float value1, Float value2) {
            addCriterion("safety_fraction between", value1, value2, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionNotBetween(Float value1, Float value2) {
            addCriterion("safety_fraction not between", value1, value2, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedIsNull() {
            addCriterion("direct_memory_reserved is null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedIsNotNull() {
            addCriterion("direct_memory_reserved is not null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedEqualTo(String value) {
            addCriterion("direct_memory_reserved =", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotEqualTo(String value) {
            addCriterion("direct_memory_reserved <>", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedGreaterThan(String value) {
            addCriterion("direct_memory_reserved >", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedGreaterThanOrEqualTo(String value) {
            addCriterion("direct_memory_reserved >=", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedLessThan(String value) {
            addCriterion("direct_memory_reserved <", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedLessThanOrEqualTo(String value) {
            addCriterion("direct_memory_reserved <=", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedLike(String value) {
            addCriterion("direct_memory_reserved like", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotLike(String value) {
            addCriterion("direct_memory_reserved not like", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedIn(List<String> values) {
            addCriterion("direct_memory_reserved in", values, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotIn(List<String> values) {
            addCriterion("direct_memory_reserved not in", values, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedBetween(String value1, String value2) {
            addCriterion("direct_memory_reserved between", value1, value2, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotBetween(String value1, String value2) {
            addCriterion("direct_memory_reserved not between", value1, value2, "directMemoryReserved");
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