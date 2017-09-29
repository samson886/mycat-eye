package io.mycat.eye.agent.bean;

import java.util.ArrayList;
import java.util.List;

public class MysqlWeakPasswordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public MysqlWeakPasswordExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlaintextIsNull() {
            addCriterion("plaintext is null");
            return (Criteria) this;
        }

        public Criteria andPlaintextIsNotNull() {
            addCriterion("plaintext is not null");
            return (Criteria) this;
        }

        public Criteria andPlaintextEqualTo(String value) {
            addCriterion("plaintext =", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextNotEqualTo(String value) {
            addCriterion("plaintext <>", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextGreaterThan(String value) {
            addCriterion("plaintext >", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextGreaterThanOrEqualTo(String value) {
            addCriterion("plaintext >=", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextLessThan(String value) {
            addCriterion("plaintext <", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextLessThanOrEqualTo(String value) {
            addCriterion("plaintext <=", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextLike(String value) {
            addCriterion("plaintext like", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextNotLike(String value) {
            addCriterion("plaintext not like", value, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextIn(List<String> values) {
            addCriterion("plaintext in", values, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextNotIn(List<String> values) {
            addCriterion("plaintext not in", values, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextBetween(String value1, String value2) {
            addCriterion("plaintext between", value1, value2, "plaintext");
            return (Criteria) this;
        }

        public Criteria andPlaintextNotBetween(String value1, String value2) {
            addCriterion("plaintext not between", value1, value2, "plaintext");
            return (Criteria) this;
        }

        public Criteria andCiphertextIsNull() {
            addCriterion("ciphertext is null");
            return (Criteria) this;
        }

        public Criteria andCiphertextIsNotNull() {
            addCriterion("ciphertext is not null");
            return (Criteria) this;
        }

        public Criteria andCiphertextEqualTo(String value) {
            addCriterion("ciphertext =", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextNotEqualTo(String value) {
            addCriterion("ciphertext <>", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextGreaterThan(String value) {
            addCriterion("ciphertext >", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextGreaterThanOrEqualTo(String value) {
            addCriterion("ciphertext >=", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextLessThan(String value) {
            addCriterion("ciphertext <", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextLessThanOrEqualTo(String value) {
            addCriterion("ciphertext <=", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextLike(String value) {
            addCriterion("ciphertext like", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextNotLike(String value) {
            addCriterion("ciphertext not like", value, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextIn(List<String> values) {
            addCriterion("ciphertext in", values, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextNotIn(List<String> values) {
            addCriterion("ciphertext not in", values, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextBetween(String value1, String value2) {
            addCriterion("ciphertext between", value1, value2, "ciphertext");
            return (Criteria) this;
        }

        public Criteria andCiphertextNotBetween(String value1, String value2) {
            addCriterion("ciphertext not between", value1, value2, "ciphertext");
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