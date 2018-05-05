package io.mycat.eye.web.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatSqlSumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatSqlSumExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
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

        public Criteria andRIsNull() {
            addCriterion("r is null");
            return (Criteria) this;
        }

        public Criteria andRIsNotNull() {
            addCriterion("r is not null");
            return (Criteria) this;
        }

        public Criteria andREqualTo(Integer value) {
            addCriterion("r =", value, "r");
            return (Criteria) this;
        }

        public Criteria andRNotEqualTo(Integer value) {
            addCriterion("r <>", value, "r");
            return (Criteria) this;
        }

        public Criteria andRGreaterThan(Integer value) {
            addCriterion("r >", value, "r");
            return (Criteria) this;
        }

        public Criteria andRGreaterThanOrEqualTo(Integer value) {
            addCriterion("r >=", value, "r");
            return (Criteria) this;
        }

        public Criteria andRLessThan(Integer value) {
            addCriterion("r <", value, "r");
            return (Criteria) this;
        }

        public Criteria andRLessThanOrEqualTo(Integer value) {
            addCriterion("r <=", value, "r");
            return (Criteria) this;
        }

        public Criteria andRIn(List<Integer> values) {
            addCriterion("r in", values, "r");
            return (Criteria) this;
        }

        public Criteria andRNotIn(List<Integer> values) {
            addCriterion("r not in", values, "r");
            return (Criteria) this;
        }

        public Criteria andRBetween(Integer value1, Integer value2) {
            addCriterion("r between", value1, value2, "r");
            return (Criteria) this;
        }

        public Criteria andRNotBetween(Integer value1, Integer value2) {
            addCriterion("r not between", value1, value2, "r");
            return (Criteria) this;
        }

        public Criteria andWIsNull() {
            addCriterion("w is null");
            return (Criteria) this;
        }

        public Criteria andWIsNotNull() {
            addCriterion("w is not null");
            return (Criteria) this;
        }

        public Criteria andWEqualTo(Integer value) {
            addCriterion("w =", value, "w");
            return (Criteria) this;
        }

        public Criteria andWNotEqualTo(Integer value) {
            addCriterion("w <>", value, "w");
            return (Criteria) this;
        }

        public Criteria andWGreaterThan(Integer value) {
            addCriterion("w >", value, "w");
            return (Criteria) this;
        }

        public Criteria andWGreaterThanOrEqualTo(Integer value) {
            addCriterion("w >=", value, "w");
            return (Criteria) this;
        }

        public Criteria andWLessThan(Integer value) {
            addCriterion("w <", value, "w");
            return (Criteria) this;
        }

        public Criteria andWLessThanOrEqualTo(Integer value) {
            addCriterion("w <=", value, "w");
            return (Criteria) this;
        }

        public Criteria andWIn(List<Integer> values) {
            addCriterion("w in", values, "w");
            return (Criteria) this;
        }

        public Criteria andWNotIn(List<Integer> values) {
            addCriterion("w not in", values, "w");
            return (Criteria) this;
        }

        public Criteria andWBetween(Integer value1, Integer value2) {
            addCriterion("w between", value1, value2, "w");
            return (Criteria) this;
        }

        public Criteria andWNotBetween(Integer value1, Integer value2) {
            addCriterion("w not between", value1, value2, "w");
            return (Criteria) this;
        }

        public Criteria andRPIsNull() {
            addCriterion("r_p is null");
            return (Criteria) this;
        }

        public Criteria andRPIsNotNull() {
            addCriterion("r_p is not null");
            return (Criteria) this;
        }

        public Criteria andRPEqualTo(Float value) {
            addCriterion("r_p =", value, "rP");
            return (Criteria) this;
        }

        public Criteria andRPNotEqualTo(Float value) {
            addCriterion("r_p <>", value, "rP");
            return (Criteria) this;
        }

        public Criteria andRPGreaterThan(Float value) {
            addCriterion("r_p >", value, "rP");
            return (Criteria) this;
        }

        public Criteria andRPGreaterThanOrEqualTo(Float value) {
            addCriterion("r_p >=", value, "rP");
            return (Criteria) this;
        }

        public Criteria andRPLessThan(Float value) {
            addCriterion("r_p <", value, "rP");
            return (Criteria) this;
        }

        public Criteria andRPLessThanOrEqualTo(Float value) {
            addCriterion("r_p <=", value, "rP");
            return (Criteria) this;
        }

        public Criteria andRPIn(List<Float> values) {
            addCriterion("r_p in", values, "rP");
            return (Criteria) this;
        }

        public Criteria andRPNotIn(List<Float> values) {
            addCriterion("r_p not in", values, "rP");
            return (Criteria) this;
        }

        public Criteria andRPBetween(Float value1, Float value2) {
            addCriterion("r_p between", value1, value2, "rP");
            return (Criteria) this;
        }

        public Criteria andRPNotBetween(Float value1, Float value2) {
            addCriterion("r_p not between", value1, value2, "rP");
            return (Criteria) this;
        }

        public Criteria andSqlMaxIsNull() {
            addCriterion("sql_max is null");
            return (Criteria) this;
        }

        public Criteria andSqlMaxIsNotNull() {
            addCriterion("sql_max is not null");
            return (Criteria) this;
        }

        public Criteria andSqlMaxEqualTo(Integer value) {
            addCriterion("sql_max =", value, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxNotEqualTo(Integer value) {
            addCriterion("sql_max <>", value, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxGreaterThan(Integer value) {
            addCriterion("sql_max >", value, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("sql_max >=", value, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxLessThan(Integer value) {
            addCriterion("sql_max <", value, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxLessThanOrEqualTo(Integer value) {
            addCriterion("sql_max <=", value, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxIn(List<Integer> values) {
            addCriterion("sql_max in", values, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxNotIn(List<Integer> values) {
            addCriterion("sql_max not in", values, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxBetween(Integer value1, Integer value2) {
            addCriterion("sql_max between", value1, value2, "sqlMax");
            return (Criteria) this;
        }

        public Criteria andSqlMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("sql_max not between", value1, value2, "sqlMax");
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

        public Criteria andNetInEqualTo(Integer value) {
            addCriterion("net_in =", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotEqualTo(Integer value) {
            addCriterion("net_in <>", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInGreaterThan(Integer value) {
            addCriterion("net_in >", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_in >=", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInLessThan(Integer value) {
            addCriterion("net_in <", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInLessThanOrEqualTo(Integer value) {
            addCriterion("net_in <=", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInIn(List<Integer> values) {
            addCriterion("net_in in", values, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotIn(List<Integer> values) {
            addCriterion("net_in not in", values, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInBetween(Integer value1, Integer value2) {
            addCriterion("net_in between", value1, value2, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotBetween(Integer value1, Integer value2) {
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

        public Criteria andNetOutEqualTo(Integer value) {
            addCriterion("net_out =", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotEqualTo(Integer value) {
            addCriterion("net_out <>", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutGreaterThan(Integer value) {
            addCriterion("net_out >", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_out >=", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutLessThan(Integer value) {
            addCriterion("net_out <", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutLessThanOrEqualTo(Integer value) {
            addCriterion("net_out <=", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutIn(List<Integer> values) {
            addCriterion("net_out in", values, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotIn(List<Integer> values) {
            addCriterion("net_out not in", values, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutBetween(Integer value1, Integer value2) {
            addCriterion("net_out between", value1, value2, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotBetween(Integer value1, Integer value2) {
            addCriterion("net_out not between", value1, value2, "netOut");
            return (Criteria) this;
        }

        public Criteria andTimeCountIsNull() {
            addCriterion("time_count is null");
            return (Criteria) this;
        }

        public Criteria andTimeCountIsNotNull() {
            addCriterion("time_count is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCountEqualTo(String value) {
            addCriterion("time_count =", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountNotEqualTo(String value) {
            addCriterion("time_count <>", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountGreaterThan(String value) {
            addCriterion("time_count >", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountGreaterThanOrEqualTo(String value) {
            addCriterion("time_count >=", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountLessThan(String value) {
            addCriterion("time_count <", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountLessThanOrEqualTo(String value) {
            addCriterion("time_count <=", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountLike(String value) {
            addCriterion("time_count like", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountNotLike(String value) {
            addCriterion("time_count not like", value, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountIn(List<String> values) {
            addCriterion("time_count in", values, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountNotIn(List<String> values) {
            addCriterion("time_count not in", values, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountBetween(String value1, String value2) {
            addCriterion("time_count between", value1, value2, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTimeCountNotBetween(String value1, String value2) {
            addCriterion("time_count not between", value1, value2, "timeCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountIsNull() {
            addCriterion("ttl_count is null");
            return (Criteria) this;
        }

        public Criteria andTtlCountIsNotNull() {
            addCriterion("ttl_count is not null");
            return (Criteria) this;
        }

        public Criteria andTtlCountEqualTo(String value) {
            addCriterion("ttl_count =", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountNotEqualTo(String value) {
            addCriterion("ttl_count <>", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountGreaterThan(String value) {
            addCriterion("ttl_count >", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountGreaterThanOrEqualTo(String value) {
            addCriterion("ttl_count >=", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountLessThan(String value) {
            addCriterion("ttl_count <", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountLessThanOrEqualTo(String value) {
            addCriterion("ttl_count <=", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountLike(String value) {
            addCriterion("ttl_count like", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountNotLike(String value) {
            addCriterion("ttl_count not like", value, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountIn(List<String> values) {
            addCriterion("ttl_count in", values, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountNotIn(List<String> values) {
            addCriterion("ttl_count not in", values, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountBetween(String value1, String value2) {
            addCriterion("ttl_count between", value1, value2, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andTtlCountNotBetween(String value1, String value2) {
            addCriterion("ttl_count not between", value1, value2, "ttlCount");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNull() {
            addCriterion("last_time is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNotNull() {
            addCriterion("last_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeEqualTo(Long value) {
            addCriterion("last_time =", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotEqualTo(Long value) {
            addCriterion("last_time <>", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThan(Long value) {
            addCriterion("last_time >", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_time >=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThan(Long value) {
            addCriterion("last_time <", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_time <=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIn(List<Long> values) {
            addCriterion("last_time in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotIn(List<Long> values) {
            addCriterion("last_time not in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeBetween(Long value1, Long value2) {
            addCriterion("last_time between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_time not between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andSqlTableIsNull() {
            addCriterion("sql_table is null");
            return (Criteria) this;
        }

        public Criteria andSqlTableIsNotNull() {
            addCriterion("sql_table is not null");
            return (Criteria) this;
        }

        public Criteria andSqlTableEqualTo(String value) {
            addCriterion("sql_table =", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableNotEqualTo(String value) {
            addCriterion("sql_table <>", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableGreaterThan(String value) {
            addCriterion("sql_table >", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableGreaterThanOrEqualTo(String value) {
            addCriterion("sql_table >=", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableLessThan(String value) {
            addCriterion("sql_table <", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableLessThanOrEqualTo(String value) {
            addCriterion("sql_table <=", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableLike(String value) {
            addCriterion("sql_table like", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableNotLike(String value) {
            addCriterion("sql_table not like", value, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableIn(List<String> values) {
            addCriterion("sql_table in", values, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableNotIn(List<String> values) {
            addCriterion("sql_table not in", values, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableBetween(String value1, String value2) {
            addCriterion("sql_table between", value1, value2, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andSqlTableNotBetween(String value1, String value2) {
            addCriterion("sql_table not between", value1, value2, "sqlTable");
            return (Criteria) this;
        }

        public Criteria andRelatableIsNull() {
            addCriterion("relatable is null");
            return (Criteria) this;
        }

        public Criteria andRelatableIsNotNull() {
            addCriterion("relatable is not null");
            return (Criteria) this;
        }

        public Criteria andRelatableEqualTo(String value) {
            addCriterion("relatable =", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableNotEqualTo(String value) {
            addCriterion("relatable <>", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableGreaterThan(String value) {
            addCriterion("relatable >", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableGreaterThanOrEqualTo(String value) {
            addCriterion("relatable >=", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableLessThan(String value) {
            addCriterion("relatable <", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableLessThanOrEqualTo(String value) {
            addCriterion("relatable <=", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableLike(String value) {
            addCriterion("relatable like", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableNotLike(String value) {
            addCriterion("relatable not like", value, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableIn(List<String> values) {
            addCriterion("relatable in", values, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableNotIn(List<String> values) {
            addCriterion("relatable not in", values, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableBetween(String value1, String value2) {
            addCriterion("relatable between", value1, value2, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelatableNotBetween(String value1, String value2) {
            addCriterion("relatable not between", value1, value2, "relatable");
            return (Criteria) this;
        }

        public Criteria andRelacountIsNull() {
            addCriterion("relacount is null");
            return (Criteria) this;
        }

        public Criteria andRelacountIsNotNull() {
            addCriterion("relacount is not null");
            return (Criteria) this;
        }

        public Criteria andRelacountEqualTo(String value) {
            addCriterion("relacount =", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountNotEqualTo(String value) {
            addCriterion("relacount <>", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountGreaterThan(String value) {
            addCriterion("relacount >", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountGreaterThanOrEqualTo(String value) {
            addCriterion("relacount >=", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountLessThan(String value) {
            addCriterion("relacount <", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountLessThanOrEqualTo(String value) {
            addCriterion("relacount <=", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountLike(String value) {
            addCriterion("relacount like", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountNotLike(String value) {
            addCriterion("relacount not like", value, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountIn(List<String> values) {
            addCriterion("relacount in", values, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountNotIn(List<String> values) {
            addCriterion("relacount not in", values, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountBetween(String value1, String value2) {
            addCriterion("relacount between", value1, value2, "relacount");
            return (Criteria) this;
        }

        public Criteria andRelacountNotBetween(String value1, String value2) {
            addCriterion("relacount not between", value1, value2, "relacount");
            return (Criteria) this;
        }

        public Criteria andCollectTypeIsNull() {
            addCriterion("collect_type is null");
            return (Criteria) this;
        }

        public Criteria andCollectTypeIsNotNull() {
            addCriterion("collect_type is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTypeEqualTo(String value) {
            addCriterion("collect_type =", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeNotEqualTo(String value) {
            addCriterion("collect_type <>", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeGreaterThan(String value) {
            addCriterion("collect_type >", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("collect_type >=", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeLessThan(String value) {
            addCriterion("collect_type <", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeLessThanOrEqualTo(String value) {
            addCriterion("collect_type <=", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeLike(String value) {
            addCriterion("collect_type like", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeNotLike(String value) {
            addCriterion("collect_type not like", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeIn(List<String> values) {
            addCriterion("collect_type in", values, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeNotIn(List<String> values) {
            addCriterion("collect_type not in", values, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeBetween(String value1, String value2) {
            addCriterion("collect_type between", value1, value2, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeNotBetween(String value1, String value2) {
            addCriterion("collect_type not between", value1, value2, "collectType");
            return (Criteria) this;
        }

        public Criteria andTimeCount0IsNull() {
            addCriterion("time_count0 is null");
            return (Criteria) this;
        }

        public Criteria andTimeCount0IsNotNull() {
            addCriterion("time_count0 is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCount0EqualTo(Integer value) {
            addCriterion("time_count0 =", value, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0NotEqualTo(Integer value) {
            addCriterion("time_count0 <>", value, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0GreaterThan(Integer value) {
            addCriterion("time_count0 >", value, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0GreaterThanOrEqualTo(Integer value) {
            addCriterion("time_count0 >=", value, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0LessThan(Integer value) {
            addCriterion("time_count0 <", value, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0LessThanOrEqualTo(Integer value) {
            addCriterion("time_count0 <=", value, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0In(List<Integer> values) {
            addCriterion("time_count0 in", values, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0NotIn(List<Integer> values) {
            addCriterion("time_count0 not in", values, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0Between(Integer value1, Integer value2) {
            addCriterion("time_count0 between", value1, value2, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount0NotBetween(Integer value1, Integer value2) {
            addCriterion("time_count0 not between", value1, value2, "timeCount0");
            return (Criteria) this;
        }

        public Criteria andTimeCount1IsNull() {
            addCriterion("time_count1 is null");
            return (Criteria) this;
        }

        public Criteria andTimeCount1IsNotNull() {
            addCriterion("time_count1 is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCount1EqualTo(Integer value) {
            addCriterion("time_count1 =", value, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1NotEqualTo(Integer value) {
            addCriterion("time_count1 <>", value, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1GreaterThan(Integer value) {
            addCriterion("time_count1 >", value, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1GreaterThanOrEqualTo(Integer value) {
            addCriterion("time_count1 >=", value, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1LessThan(Integer value) {
            addCriterion("time_count1 <", value, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1LessThanOrEqualTo(Integer value) {
            addCriterion("time_count1 <=", value, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1In(List<Integer> values) {
            addCriterion("time_count1 in", values, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1NotIn(List<Integer> values) {
            addCriterion("time_count1 not in", values, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1Between(Integer value1, Integer value2) {
            addCriterion("time_count1 between", value1, value2, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount1NotBetween(Integer value1, Integer value2) {
            addCriterion("time_count1 not between", value1, value2, "timeCount1");
            return (Criteria) this;
        }

        public Criteria andTimeCount2IsNull() {
            addCriterion("time_count2 is null");
            return (Criteria) this;
        }

        public Criteria andTimeCount2IsNotNull() {
            addCriterion("time_count2 is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCount2EqualTo(Integer value) {
            addCriterion("time_count2 =", value, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2NotEqualTo(Integer value) {
            addCriterion("time_count2 <>", value, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2GreaterThan(Integer value) {
            addCriterion("time_count2 >", value, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2GreaterThanOrEqualTo(Integer value) {
            addCriterion("time_count2 >=", value, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2LessThan(Integer value) {
            addCriterion("time_count2 <", value, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2LessThanOrEqualTo(Integer value) {
            addCriterion("time_count2 <=", value, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2In(List<Integer> values) {
            addCriterion("time_count2 in", values, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2NotIn(List<Integer> values) {
            addCriterion("time_count2 not in", values, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2Between(Integer value1, Integer value2) {
            addCriterion("time_count2 between", value1, value2, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount2NotBetween(Integer value1, Integer value2) {
            addCriterion("time_count2 not between", value1, value2, "timeCount2");
            return (Criteria) this;
        }

        public Criteria andTimeCount3IsNull() {
            addCriterion("time_count3 is null");
            return (Criteria) this;
        }

        public Criteria andTimeCount3IsNotNull() {
            addCriterion("time_count3 is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCount3EqualTo(Integer value) {
            addCriterion("time_count3 =", value, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3NotEqualTo(Integer value) {
            addCriterion("time_count3 <>", value, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3GreaterThan(Integer value) {
            addCriterion("time_count3 >", value, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3GreaterThanOrEqualTo(Integer value) {
            addCriterion("time_count3 >=", value, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3LessThan(Integer value) {
            addCriterion("time_count3 <", value, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3LessThanOrEqualTo(Integer value) {
            addCriterion("time_count3 <=", value, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3In(List<Integer> values) {
            addCriterion("time_count3 in", values, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3NotIn(List<Integer> values) {
            addCriterion("time_count3 not in", values, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3Between(Integer value1, Integer value2) {
            addCriterion("time_count3 between", value1, value2, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTimeCount3NotBetween(Integer value1, Integer value2) {
            addCriterion("time_count3 not between", value1, value2, "timeCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount0IsNull() {
            addCriterion("ttl_count0 is null");
            return (Criteria) this;
        }

        public Criteria andTtlCount0IsNotNull() {
            addCriterion("ttl_count0 is not null");
            return (Criteria) this;
        }

        public Criteria andTtlCount0EqualTo(Integer value) {
            addCriterion("ttl_count0 =", value, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0NotEqualTo(Integer value) {
            addCriterion("ttl_count0 <>", value, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0GreaterThan(Integer value) {
            addCriterion("ttl_count0 >", value, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0GreaterThanOrEqualTo(Integer value) {
            addCriterion("ttl_count0 >=", value, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0LessThan(Integer value) {
            addCriterion("ttl_count0 <", value, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0LessThanOrEqualTo(Integer value) {
            addCriterion("ttl_count0 <=", value, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0In(List<Integer> values) {
            addCriterion("ttl_count0 in", values, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0NotIn(List<Integer> values) {
            addCriterion("ttl_count0 not in", values, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0Between(Integer value1, Integer value2) {
            addCriterion("ttl_count0 between", value1, value2, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount0NotBetween(Integer value1, Integer value2) {
            addCriterion("ttl_count0 not between", value1, value2, "ttlCount0");
            return (Criteria) this;
        }

        public Criteria andTtlCount1IsNull() {
            addCriterion("ttl_count1 is null");
            return (Criteria) this;
        }

        public Criteria andTtlCount1IsNotNull() {
            addCriterion("ttl_count1 is not null");
            return (Criteria) this;
        }

        public Criteria andTtlCount1EqualTo(Integer value) {
            addCriterion("ttl_count1 =", value, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1NotEqualTo(Integer value) {
            addCriterion("ttl_count1 <>", value, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1GreaterThan(Integer value) {
            addCriterion("ttl_count1 >", value, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1GreaterThanOrEqualTo(Integer value) {
            addCriterion("ttl_count1 >=", value, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1LessThan(Integer value) {
            addCriterion("ttl_count1 <", value, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1LessThanOrEqualTo(Integer value) {
            addCriterion("ttl_count1 <=", value, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1In(List<Integer> values) {
            addCriterion("ttl_count1 in", values, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1NotIn(List<Integer> values) {
            addCriterion("ttl_count1 not in", values, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1Between(Integer value1, Integer value2) {
            addCriterion("ttl_count1 between", value1, value2, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount1NotBetween(Integer value1, Integer value2) {
            addCriterion("ttl_count1 not between", value1, value2, "ttlCount1");
            return (Criteria) this;
        }

        public Criteria andTtlCount2IsNull() {
            addCriterion("ttl_count2 is null");
            return (Criteria) this;
        }

        public Criteria andTtlCount2IsNotNull() {
            addCriterion("ttl_count2 is not null");
            return (Criteria) this;
        }

        public Criteria andTtlCount2EqualTo(Integer value) {
            addCriterion("ttl_count2 =", value, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2NotEqualTo(Integer value) {
            addCriterion("ttl_count2 <>", value, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2GreaterThan(Integer value) {
            addCriterion("ttl_count2 >", value, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2GreaterThanOrEqualTo(Integer value) {
            addCriterion("ttl_count2 >=", value, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2LessThan(Integer value) {
            addCriterion("ttl_count2 <", value, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2LessThanOrEqualTo(Integer value) {
            addCriterion("ttl_count2 <=", value, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2In(List<Integer> values) {
            addCriterion("ttl_count2 in", values, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2NotIn(List<Integer> values) {
            addCriterion("ttl_count2 not in", values, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2Between(Integer value1, Integer value2) {
            addCriterion("ttl_count2 between", value1, value2, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount2NotBetween(Integer value1, Integer value2) {
            addCriterion("ttl_count2 not between", value1, value2, "ttlCount2");
            return (Criteria) this;
        }

        public Criteria andTtlCount3IsNull() {
            addCriterion("ttl_count3 is null");
            return (Criteria) this;
        }

        public Criteria andTtlCount3IsNotNull() {
            addCriterion("ttl_count3 is not null");
            return (Criteria) this;
        }

        public Criteria andTtlCount3EqualTo(Integer value) {
            addCriterion("ttl_count3 =", value, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3NotEqualTo(Integer value) {
            addCriterion("ttl_count3 <>", value, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3GreaterThan(Integer value) {
            addCriterion("ttl_count3 >", value, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3GreaterThanOrEqualTo(Integer value) {
            addCriterion("ttl_count3 >=", value, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3LessThan(Integer value) {
            addCriterion("ttl_count3 <", value, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3LessThanOrEqualTo(Integer value) {
            addCriterion("ttl_count3 <=", value, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3In(List<Integer> values) {
            addCriterion("ttl_count3 in", values, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3NotIn(List<Integer> values) {
            addCriterion("ttl_count3 not in", values, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3Between(Integer value1, Integer value2) {
            addCriterion("ttl_count3 between", value1, value2, "ttlCount3");
            return (Criteria) this;
        }

        public Criteria andTtlCount3NotBetween(Integer value1, Integer value2) {
            addCriterion("ttl_count3 not between", value1, value2, "ttlCount3");
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