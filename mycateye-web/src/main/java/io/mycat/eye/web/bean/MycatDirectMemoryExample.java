package io.mycat.eye.web.bean;

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

        public Criteria andMdirectMemoryMaxedIsNull() {
            addCriterion("MDIRECT_MEMORY_MAXED is null");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedIsNotNull() {
            addCriterion("MDIRECT_MEMORY_MAXED is not null");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedEqualTo(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED =", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotEqualTo(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED <>", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedGreaterThan(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED >", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedGreaterThanOrEqualTo(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED >=", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedLessThan(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED <", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedLessThanOrEqualTo(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED <=", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedLike(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED like", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotLike(String value) {
            addCriterion("MDIRECT_MEMORY_MAXED not like", value, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedIn(List<String> values) {
            addCriterion("MDIRECT_MEMORY_MAXED in", values, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotIn(List<String> values) {
            addCriterion("MDIRECT_MEMORY_MAXED not in", values, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedBetween(String value1, String value2) {
            addCriterion("MDIRECT_MEMORY_MAXED between", value1, value2, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andMdirectMemoryMaxedNotBetween(String value1, String value2) {
            addCriterion("MDIRECT_MEMORY_MAXED not between", value1, value2, "mdirectMemoryMaxed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedIsNull() {
            addCriterion("DIRECT_MEMORY_USED is null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedIsNotNull() {
            addCriterion("DIRECT_MEMORY_USED is not null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_USED =", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_USED <>", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedGreaterThan(String value) {
            addCriterion("DIRECT_MEMORY_USED >", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_USED >=", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedLessThan(String value) {
            addCriterion("DIRECT_MEMORY_USED <", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedLessThanOrEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_USED <=", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedLike(String value) {
            addCriterion("DIRECT_MEMORY_USED like", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotLike(String value) {
            addCriterion("DIRECT_MEMORY_USED not like", value, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedIn(List<String> values) {
            addCriterion("DIRECT_MEMORY_USED in", values, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotIn(List<String> values) {
            addCriterion("DIRECT_MEMORY_USED not in", values, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedBetween(String value1, String value2) {
            addCriterion("DIRECT_MEMORY_USED between", value1, value2, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryUsedNotBetween(String value1, String value2) {
            addCriterion("DIRECT_MEMORY_USED not between", value1, value2, "directMemoryUsed");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableIsNull() {
            addCriterion("DIRECT_MEMORY_AVAILABLE is null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableIsNotNull() {
            addCriterion("DIRECT_MEMORY_AVAILABLE is not null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE =", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE <>", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableGreaterThan(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE >", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE >=", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableLessThan(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE <", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableLessThanOrEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE <=", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableLike(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE like", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotLike(String value) {
            addCriterion("DIRECT_MEMORY_AVAILABLE not like", value, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableIn(List<String> values) {
            addCriterion("DIRECT_MEMORY_AVAILABLE in", values, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotIn(List<String> values) {
            addCriterion("DIRECT_MEMORY_AVAILABLE not in", values, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableBetween(String value1, String value2) {
            addCriterion("DIRECT_MEMORY_AVAILABLE between", value1, value2, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryAvailableNotBetween(String value1, String value2) {
            addCriterion("DIRECT_MEMORY_AVAILABLE not between", value1, value2, "directMemoryAvailable");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionIsNull() {
            addCriterion("SAFETY_FRACTION is null");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionIsNotNull() {
            addCriterion("SAFETY_FRACTION is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionEqualTo(Float value) {
            addCriterion("SAFETY_FRACTION =", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionNotEqualTo(Float value) {
            addCriterion("SAFETY_FRACTION <>", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionGreaterThan(Float value) {
            addCriterion("SAFETY_FRACTION >", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionGreaterThanOrEqualTo(Float value) {
            addCriterion("SAFETY_FRACTION >=", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionLessThan(Float value) {
            addCriterion("SAFETY_FRACTION <", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionLessThanOrEqualTo(Float value) {
            addCriterion("SAFETY_FRACTION <=", value, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionIn(List<Float> values) {
            addCriterion("SAFETY_FRACTION in", values, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionNotIn(List<Float> values) {
            addCriterion("SAFETY_FRACTION not in", values, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionBetween(Float value1, Float value2) {
            addCriterion("SAFETY_FRACTION between", value1, value2, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andSafetyFractionNotBetween(Float value1, Float value2) {
            addCriterion("SAFETY_FRACTION not between", value1, value2, "safetyFraction");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedIsNull() {
            addCriterion("DIRECT_MEMORY_RESERVED is null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedIsNotNull() {
            addCriterion("DIRECT_MEMORY_RESERVED is not null");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED =", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED <>", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedGreaterThan(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED >", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED >=", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedLessThan(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED <", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedLessThanOrEqualTo(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED <=", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedLike(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED like", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotLike(String value) {
            addCriterion("DIRECT_MEMORY_RESERVED not like", value, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedIn(List<String> values) {
            addCriterion("DIRECT_MEMORY_RESERVED in", values, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotIn(List<String> values) {
            addCriterion("DIRECT_MEMORY_RESERVED not in", values, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedBetween(String value1, String value2) {
            addCriterion("DIRECT_MEMORY_RESERVED between", value1, value2, "directMemoryReserved");
            return (Criteria) this;
        }

        public Criteria andDirectMemoryReservedNotBetween(String value1, String value2) {
            addCriterion("DIRECT_MEMORY_RESERVED not between", value1, value2, "directMemoryReserved");
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