package io.mycat.eye.agent.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatConnectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatConnectionExample() {
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

        public Criteria andCTypeIsNull() {
            addCriterion("c_type is null");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNotNull() {
            addCriterion("c_type is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeEqualTo(String value) {
            addCriterion("c_type =", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotEqualTo(String value) {
            addCriterion("c_type <>", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThan(String value) {
            addCriterion("c_type >", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThanOrEqualTo(String value) {
            addCriterion("c_type >=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThan(String value) {
            addCriterion("c_type <", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThanOrEqualTo(String value) {
            addCriterion("c_type <=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLike(String value) {
            addCriterion("c_type like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotLike(String value) {
            addCriterion("c_type not like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeIn(List<String> values) {
            addCriterion("c_type in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotIn(List<String> values) {
            addCriterion("c_type not in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeBetween(String value1, String value2) {
            addCriterion("c_type between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotBetween(String value1, String value2) {
            addCriterion("c_type not between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andProcessorIsNull() {
            addCriterion("processor is null");
            return (Criteria) this;
        }

        public Criteria andProcessorIsNotNull() {
            addCriterion("processor is not null");
            return (Criteria) this;
        }

        public Criteria andProcessorEqualTo(String value) {
            addCriterion("processor =", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotEqualTo(String value) {
            addCriterion("processor <>", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorGreaterThan(String value) {
            addCriterion("processor >", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorGreaterThanOrEqualTo(String value) {
            addCriterion("processor >=", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorLessThan(String value) {
            addCriterion("processor <", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorLessThanOrEqualTo(String value) {
            addCriterion("processor <=", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorLike(String value) {
            addCriterion("processor like", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotLike(String value) {
            addCriterion("processor not like", value, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorIn(List<String> values) {
            addCriterion("processor in", values, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotIn(List<String> values) {
            addCriterion("processor not in", values, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorBetween(String value1, String value2) {
            addCriterion("processor between", value1, value2, "processor");
            return (Criteria) this;
        }

        public Criteria andProcessorNotBetween(String value1, String value2) {
            addCriterion("processor not between", value1, value2, "processor");
            return (Criteria) this;
        }

        public Criteria andMysqlidIsNull() {
            addCriterion("mysqlId is null");
            return (Criteria) this;
        }

        public Criteria andMysqlidIsNotNull() {
            addCriterion("mysqlId is not null");
            return (Criteria) this;
        }

        public Criteria andMysqlidEqualTo(Integer value) {
            addCriterion("mysqlId =", value, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidNotEqualTo(Integer value) {
            addCriterion("mysqlId <>", value, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidGreaterThan(Integer value) {
            addCriterion("mysqlId >", value, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mysqlId >=", value, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidLessThan(Integer value) {
            addCriterion("mysqlId <", value, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidLessThanOrEqualTo(Integer value) {
            addCriterion("mysqlId <=", value, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidIn(List<Integer> values) {
            addCriterion("mysqlId in", values, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidNotIn(List<Integer> values) {
            addCriterion("mysqlId not in", values, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidBetween(Integer value1, Integer value2) {
            addCriterion("mysqlId between", value1, value2, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andMysqlidNotBetween(Integer value1, Integer value2) {
            addCriterion("mysqlId not between", value1, value2, "mysqlid");
            return (Criteria) this;
        }

        public Criteria andCHostIsNull() {
            addCriterion("c_host is null");
            return (Criteria) this;
        }

        public Criteria andCHostIsNotNull() {
            addCriterion("c_host is not null");
            return (Criteria) this;
        }

        public Criteria andCHostEqualTo(String value) {
            addCriterion("c_host =", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostNotEqualTo(String value) {
            addCriterion("c_host <>", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostGreaterThan(String value) {
            addCriterion("c_host >", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostGreaterThanOrEqualTo(String value) {
            addCriterion("c_host >=", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostLessThan(String value) {
            addCriterion("c_host <", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostLessThanOrEqualTo(String value) {
            addCriterion("c_host <=", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostLike(String value) {
            addCriterion("c_host like", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostNotLike(String value) {
            addCriterion("c_host not like", value, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostIn(List<String> values) {
            addCriterion("c_host in", values, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostNotIn(List<String> values) {
            addCriterion("c_host not in", values, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostBetween(String value1, String value2) {
            addCriterion("c_host between", value1, value2, "cHost");
            return (Criteria) this;
        }

        public Criteria andCHostNotBetween(String value1, String value2) {
            addCriterion("c_host not between", value1, value2, "cHost");
            return (Criteria) this;
        }

        public Criteria andCPortIsNull() {
            addCriterion("c_port is null");
            return (Criteria) this;
        }

        public Criteria andCPortIsNotNull() {
            addCriterion("c_port is not null");
            return (Criteria) this;
        }

        public Criteria andCPortEqualTo(Integer value) {
            addCriterion("c_port =", value, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortNotEqualTo(Integer value) {
            addCriterion("c_port <>", value, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortGreaterThan(Integer value) {
            addCriterion("c_port >", value, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_port >=", value, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortLessThan(Integer value) {
            addCriterion("c_port <", value, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortLessThanOrEqualTo(Integer value) {
            addCriterion("c_port <=", value, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortIn(List<Integer> values) {
            addCriterion("c_port in", values, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortNotIn(List<Integer> values) {
            addCriterion("c_port not in", values, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortBetween(Integer value1, Integer value2) {
            addCriterion("c_port between", value1, value2, "cPort");
            return (Criteria) this;
        }

        public Criteria andCPortNotBetween(Integer value1, Integer value2) {
            addCriterion("c_port not between", value1, value2, "cPort");
            return (Criteria) this;
        }

        public Criteria andLPortIsNull() {
            addCriterion("l_port is null");
            return (Criteria) this;
        }

        public Criteria andLPortIsNotNull() {
            addCriterion("l_port is not null");
            return (Criteria) this;
        }

        public Criteria andLPortEqualTo(Integer value) {
            addCriterion("l_port =", value, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortNotEqualTo(Integer value) {
            addCriterion("l_port <>", value, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortGreaterThan(Integer value) {
            addCriterion("l_port >", value, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_port >=", value, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortLessThan(Integer value) {
            addCriterion("l_port <", value, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortLessThanOrEqualTo(Integer value) {
            addCriterion("l_port <=", value, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortIn(List<Integer> values) {
            addCriterion("l_port in", values, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortNotIn(List<Integer> values) {
            addCriterion("l_port not in", values, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortBetween(Integer value1, Integer value2) {
            addCriterion("l_port between", value1, value2, "lPort");
            return (Criteria) this;
        }

        public Criteria andLPortNotBetween(Integer value1, Integer value2) {
            addCriterion("l_port not between", value1, value2, "lPort");
            return (Criteria) this;
        }

        public Criteria andNetInIsNull() {
            addCriterion("net_in is null");
            return (Criteria) this;
        }

        public Criteria andNetInIsNotNull() {
            addCriterion("net_in is not null");
            return (Criteria) this;
        }

        public Criteria andNetInEqualTo(Long value) {
            addCriterion("net_in =", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotEqualTo(Long value) {
            addCriterion("net_in <>", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInGreaterThan(Long value) {
            addCriterion("net_in >", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInGreaterThanOrEqualTo(Long value) {
            addCriterion("net_in >=", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInLessThan(Long value) {
            addCriterion("net_in <", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInLessThanOrEqualTo(Long value) {
            addCriterion("net_in <=", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInIn(List<Long> values) {
            addCriterion("net_in in", values, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotIn(List<Long> values) {
            addCriterion("net_in not in", values, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInBetween(Long value1, Long value2) {
            addCriterion("net_in between", value1, value2, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotBetween(Long value1, Long value2) {
            addCriterion("net_in not between", value1, value2, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetOutIsNull() {
            addCriterion("net_out is null");
            return (Criteria) this;
        }

        public Criteria andNetOutIsNotNull() {
            addCriterion("net_out is not null");
            return (Criteria) this;
        }

        public Criteria andNetOutEqualTo(Long value) {
            addCriterion("net_out =", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotEqualTo(Long value) {
            addCriterion("net_out <>", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutGreaterThan(Long value) {
            addCriterion("net_out >", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutGreaterThanOrEqualTo(Long value) {
            addCriterion("net_out >=", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutLessThan(Long value) {
            addCriterion("net_out <", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutLessThanOrEqualTo(Long value) {
            addCriterion("net_out <=", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutIn(List<Long> values) {
            addCriterion("net_out in", values, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotIn(List<Long> values) {
            addCriterion("net_out not in", values, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutBetween(Long value1, Long value2) {
            addCriterion("net_out between", value1, value2, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotBetween(Long value1, Long value2) {
            addCriterion("net_out not between", value1, value2, "netOut");
            return (Criteria) this;
        }

        public Criteria andCUserIsNull() {
            addCriterion("c_user is null");
            return (Criteria) this;
        }

        public Criteria andCUserIsNotNull() {
            addCriterion("c_user is not null");
            return (Criteria) this;
        }

        public Criteria andCUserEqualTo(String value) {
            addCriterion("c_user =", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserNotEqualTo(String value) {
            addCriterion("c_user <>", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserGreaterThan(String value) {
            addCriterion("c_user >", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserGreaterThanOrEqualTo(String value) {
            addCriterion("c_user >=", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserLessThan(String value) {
            addCriterion("c_user <", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserLessThanOrEqualTo(String value) {
            addCriterion("c_user <=", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserLike(String value) {
            addCriterion("c_user like", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserNotLike(String value) {
            addCriterion("c_user not like", value, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserIn(List<String> values) {
            addCriterion("c_user in", values, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserNotIn(List<String> values) {
            addCriterion("c_user not in", values, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserBetween(String value1, String value2) {
            addCriterion("c_user between", value1, value2, "cUser");
            return (Criteria) this;
        }

        public Criteria andCUserNotBetween(String value1, String value2) {
            addCriterion("c_user not between", value1, value2, "cUser");
            return (Criteria) this;
        }

        public Criteria andCSchemaIsNull() {
            addCriterion("c_schema is null");
            return (Criteria) this;
        }

        public Criteria andCSchemaIsNotNull() {
            addCriterion("c_schema is not null");
            return (Criteria) this;
        }

        public Criteria andCSchemaEqualTo(String value) {
            addCriterion("c_schema =", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaNotEqualTo(String value) {
            addCriterion("c_schema <>", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaGreaterThan(String value) {
            addCriterion("c_schema >", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("c_schema >=", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaLessThan(String value) {
            addCriterion("c_schema <", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaLessThanOrEqualTo(String value) {
            addCriterion("c_schema <=", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaLike(String value) {
            addCriterion("c_schema like", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaNotLike(String value) {
            addCriterion("c_schema not like", value, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaIn(List<String> values) {
            addCriterion("c_schema in", values, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaNotIn(List<String> values) {
            addCriterion("c_schema not in", values, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaBetween(String value1, String value2) {
            addCriterion("c_schema between", value1, value2, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCSchemaNotBetween(String value1, String value2) {
            addCriterion("c_schema not between", value1, value2, "cSchema");
            return (Criteria) this;
        }

        public Criteria andCCharsetIsNull() {
            addCriterion("c_charset is null");
            return (Criteria) this;
        }

        public Criteria andCCharsetIsNotNull() {
            addCriterion("c_charset is not null");
            return (Criteria) this;
        }

        public Criteria andCCharsetEqualTo(String value) {
            addCriterion("c_charset =", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetNotEqualTo(String value) {
            addCriterion("c_charset <>", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetGreaterThan(String value) {
            addCriterion("c_charset >", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetGreaterThanOrEqualTo(String value) {
            addCriterion("c_charset >=", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetLessThan(String value) {
            addCriterion("c_charset <", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetLessThanOrEqualTo(String value) {
            addCriterion("c_charset <=", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetLike(String value) {
            addCriterion("c_charset like", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetNotLike(String value) {
            addCriterion("c_charset not like", value, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetIn(List<String> values) {
            addCriterion("c_charset in", values, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetNotIn(List<String> values) {
            addCriterion("c_charset not in", values, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetBetween(String value1, String value2) {
            addCriterion("c_charset between", value1, value2, "cCharset");
            return (Criteria) this;
        }

        public Criteria andCCharsetNotBetween(String value1, String value2) {
            addCriterion("c_charset not between", value1, value2, "cCharset");
            return (Criteria) this;
        }

        public Criteria andLifeIsNull() {
            addCriterion("life is null");
            return (Criteria) this;
        }

        public Criteria andLifeIsNotNull() {
            addCriterion("life is not null");
            return (Criteria) this;
        }

        public Criteria andLifeEqualTo(Long value) {
            addCriterion("life =", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeNotEqualTo(Long value) {
            addCriterion("life <>", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeGreaterThan(Long value) {
            addCriterion("life >", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeGreaterThanOrEqualTo(Long value) {
            addCriterion("life >=", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeLessThan(Long value) {
            addCriterion("life <", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeLessThanOrEqualTo(Long value) {
            addCriterion("life <=", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeIn(List<Long> values) {
            addCriterion("life in", values, "life");
            return (Criteria) this;
        }

        public Criteria andLifeNotIn(List<Long> values) {
            addCriterion("life not in", values, "life");
            return (Criteria) this;
        }

        public Criteria andLifeBetween(Long value1, Long value2) {
            addCriterion("life between", value1, value2, "life");
            return (Criteria) this;
        }

        public Criteria andLifeNotBetween(Long value1, Long value2) {
            addCriterion("life not between", value1, value2, "life");
            return (Criteria) this;
        }

        public Criteria andAliveTimeIsNull() {
            addCriterion("alive_time is null");
            return (Criteria) this;
        }

        public Criteria andAliveTimeIsNotNull() {
            addCriterion("alive_time is not null");
            return (Criteria) this;
        }

        public Criteria andAliveTimeEqualTo(Long value) {
            addCriterion("alive_time =", value, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeNotEqualTo(Long value) {
            addCriterion("alive_time <>", value, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeGreaterThan(Long value) {
            addCriterion("alive_time >", value, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("alive_time >=", value, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeLessThan(Long value) {
            addCriterion("alive_time <", value, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeLessThanOrEqualTo(Long value) {
            addCriterion("alive_time <=", value, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeIn(List<Long> values) {
            addCriterion("alive_time in", values, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeNotIn(List<Long> values) {
            addCriterion("alive_time not in", values, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeBetween(Long value1, Long value2) {
            addCriterion("alive_time between", value1, value2, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andAliveTimeNotBetween(Long value1, Long value2) {
            addCriterion("alive_time not between", value1, value2, "aliveTime");
            return (Criteria) this;
        }

        public Criteria andRecvBufferIsNull() {
            addCriterion("recv_buffer is null");
            return (Criteria) this;
        }

        public Criteria andRecvBufferIsNotNull() {
            addCriterion("recv_buffer is not null");
            return (Criteria) this;
        }

        public Criteria andRecvBufferEqualTo(Integer value) {
            addCriterion("recv_buffer =", value, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferNotEqualTo(Integer value) {
            addCriterion("recv_buffer <>", value, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferGreaterThan(Integer value) {
            addCriterion("recv_buffer >", value, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferGreaterThanOrEqualTo(Integer value) {
            addCriterion("recv_buffer >=", value, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferLessThan(Integer value) {
            addCriterion("recv_buffer <", value, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferLessThanOrEqualTo(Integer value) {
            addCriterion("recv_buffer <=", value, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferIn(List<Integer> values) {
            addCriterion("recv_buffer in", values, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferNotIn(List<Integer> values) {
            addCriterion("recv_buffer not in", values, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferBetween(Integer value1, Integer value2) {
            addCriterion("recv_buffer between", value1, value2, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andRecvBufferNotBetween(Integer value1, Integer value2) {
            addCriterion("recv_buffer not between", value1, value2, "recvBuffer");
            return (Criteria) this;
        }

        public Criteria andClosedIsNull() {
            addCriterion("closed is null");
            return (Criteria) this;
        }

        public Criteria andClosedIsNotNull() {
            addCriterion("closed is not null");
            return (Criteria) this;
        }

        public Criteria andClosedEqualTo(String value) {
            addCriterion("closed =", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotEqualTo(String value) {
            addCriterion("closed <>", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedGreaterThan(String value) {
            addCriterion("closed >", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedGreaterThanOrEqualTo(String value) {
            addCriterion("closed >=", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedLessThan(String value) {
            addCriterion("closed <", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedLessThanOrEqualTo(String value) {
            addCriterion("closed <=", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedLike(String value) {
            addCriterion("closed like", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotLike(String value) {
            addCriterion("closed not like", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedIn(List<String> values) {
            addCriterion("closed in", values, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotIn(List<String> values) {
            addCriterion("closed not in", values, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedBetween(String value1, String value2) {
            addCriterion("closed between", value1, value2, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotBetween(String value1, String value2) {
            addCriterion("closed not between", value1, value2, "closed");
            return (Criteria) this;
        }

        public Criteria andBorrowedIsNull() {
            addCriterion("borrowed is null");
            return (Criteria) this;
        }

        public Criteria andBorrowedIsNotNull() {
            addCriterion("borrowed is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowedEqualTo(String value) {
            addCriterion("borrowed =", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedNotEqualTo(String value) {
            addCriterion("borrowed <>", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedGreaterThan(String value) {
            addCriterion("borrowed >", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedGreaterThanOrEqualTo(String value) {
            addCriterion("borrowed >=", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedLessThan(String value) {
            addCriterion("borrowed <", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedLessThanOrEqualTo(String value) {
            addCriterion("borrowed <=", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedLike(String value) {
            addCriterion("borrowed like", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedNotLike(String value) {
            addCriterion("borrowed not like", value, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedIn(List<String> values) {
            addCriterion("borrowed in", values, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedNotIn(List<String> values) {
            addCriterion("borrowed not in", values, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedBetween(String value1, String value2) {
            addCriterion("borrowed between", value1, value2, "borrowed");
            return (Criteria) this;
        }

        public Criteria andBorrowedNotBetween(String value1, String value2) {
            addCriterion("borrowed not between", value1, value2, "borrowed");
            return (Criteria) this;
        }

        public Criteria andSendQueueIsNull() {
            addCriterion("send_queue is null");
            return (Criteria) this;
        }

        public Criteria andSendQueueIsNotNull() {
            addCriterion("send_queue is not null");
            return (Criteria) this;
        }

        public Criteria andSendQueueEqualTo(Integer value) {
            addCriterion("send_queue =", value, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueNotEqualTo(Integer value) {
            addCriterion("send_queue <>", value, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueGreaterThan(Integer value) {
            addCriterion("send_queue >", value, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_queue >=", value, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueLessThan(Integer value) {
            addCriterion("send_queue <", value, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueLessThanOrEqualTo(Integer value) {
            addCriterion("send_queue <=", value, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueIn(List<Integer> values) {
            addCriterion("send_queue in", values, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueNotIn(List<Integer> values) {
            addCriterion("send_queue not in", values, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueBetween(Integer value1, Integer value2) {
            addCriterion("send_queue between", value1, value2, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andSendQueueNotBetween(Integer value1, Integer value2) {
            addCriterion("send_queue not between", value1, value2, "sendQueue");
            return (Criteria) this;
        }

        public Criteria andTxlevelIsNull() {
            addCriterion("txlevel is null");
            return (Criteria) this;
        }

        public Criteria andTxlevelIsNotNull() {
            addCriterion("txlevel is not null");
            return (Criteria) this;
        }

        public Criteria andTxlevelEqualTo(String value) {
            addCriterion("txlevel =", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelNotEqualTo(String value) {
            addCriterion("txlevel <>", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelGreaterThan(String value) {
            addCriterion("txlevel >", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelGreaterThanOrEqualTo(String value) {
            addCriterion("txlevel >=", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelLessThan(String value) {
            addCriterion("txlevel <", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelLessThanOrEqualTo(String value) {
            addCriterion("txlevel <=", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelLike(String value) {
            addCriterion("txlevel like", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelNotLike(String value) {
            addCriterion("txlevel not like", value, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelIn(List<String> values) {
            addCriterion("txlevel in", values, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelNotIn(List<String> values) {
            addCriterion("txlevel not in", values, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelBetween(String value1, String value2) {
            addCriterion("txlevel between", value1, value2, "txlevel");
            return (Criteria) this;
        }

        public Criteria andTxlevelNotBetween(String value1, String value2) {
            addCriterion("txlevel not between", value1, value2, "txlevel");
            return (Criteria) this;
        }

        public Criteria andAutocommitIsNull() {
            addCriterion("autocommit is null");
            return (Criteria) this;
        }

        public Criteria andAutocommitIsNotNull() {
            addCriterion("autocommit is not null");
            return (Criteria) this;
        }

        public Criteria andAutocommitEqualTo(String value) {
            addCriterion("autocommit =", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitNotEqualTo(String value) {
            addCriterion("autocommit <>", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitGreaterThan(String value) {
            addCriterion("autocommit >", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitGreaterThanOrEqualTo(String value) {
            addCriterion("autocommit >=", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitLessThan(String value) {
            addCriterion("autocommit <", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitLessThanOrEqualTo(String value) {
            addCriterion("autocommit <=", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitLike(String value) {
            addCriterion("autocommit like", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitNotLike(String value) {
            addCriterion("autocommit not like", value, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitIn(List<String> values) {
            addCriterion("autocommit in", values, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitNotIn(List<String> values) {
            addCriterion("autocommit not in", values, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitBetween(String value1, String value2) {
            addCriterion("autocommit between", value1, value2, "autocommit");
            return (Criteria) this;
        }

        public Criteria andAutocommitNotBetween(String value1, String value2) {
            addCriterion("autocommit not between", value1, value2, "autocommit");
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