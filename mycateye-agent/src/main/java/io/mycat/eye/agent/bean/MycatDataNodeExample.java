package io.mycat.eye.agent.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatDataNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatDataNodeExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDatahostIsNull() {
            addCriterion("datahost is null");
            return (Criteria) this;
        }

        public Criteria andDatahostIsNotNull() {
            addCriterion("datahost is not null");
            return (Criteria) this;
        }

        public Criteria andDatahostEqualTo(String value) {
            addCriterion("datahost =", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostNotEqualTo(String value) {
            addCriterion("datahost <>", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostGreaterThan(String value) {
            addCriterion("datahost >", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostGreaterThanOrEqualTo(String value) {
            addCriterion("datahost >=", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostLessThan(String value) {
            addCriterion("datahost <", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostLessThanOrEqualTo(String value) {
            addCriterion("datahost <=", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostLike(String value) {
            addCriterion("datahost like", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostNotLike(String value) {
            addCriterion("datahost not like", value, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostIn(List<String> values) {
            addCriterion("datahost in", values, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostNotIn(List<String> values) {
            addCriterion("datahost not in", values, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostBetween(String value1, String value2) {
            addCriterion("datahost between", value1, value2, "datahost");
            return (Criteria) this;
        }

        public Criteria andDatahostNotBetween(String value1, String value2) {
            addCriterion("datahost not between", value1, value2, "datahost");
            return (Criteria) this;
        }

        public Criteria andDIndexIsNull() {
            addCriterion("d_index is null");
            return (Criteria) this;
        }

        public Criteria andDIndexIsNotNull() {
            addCriterion("d_index is not null");
            return (Criteria) this;
        }

        public Criteria andDIndexEqualTo(Integer value) {
            addCriterion("d_index =", value, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexNotEqualTo(Integer value) {
            addCriterion("d_index <>", value, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexGreaterThan(Integer value) {
            addCriterion("d_index >", value, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_index >=", value, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexLessThan(Integer value) {
            addCriterion("d_index <", value, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexLessThanOrEqualTo(Integer value) {
            addCriterion("d_index <=", value, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexIn(List<Integer> values) {
            addCriterion("d_index in", values, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexNotIn(List<Integer> values) {
            addCriterion("d_index not in", values, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexBetween(Integer value1, Integer value2) {
            addCriterion("d_index between", value1, value2, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("d_index not between", value1, value2, "dIndex");
            return (Criteria) this;
        }

        public Criteria andDTypeIsNull() {
            addCriterion("d_type is null");
            return (Criteria) this;
        }

        public Criteria andDTypeIsNotNull() {
            addCriterion("d_type is not null");
            return (Criteria) this;
        }

        public Criteria andDTypeEqualTo(String value) {
            addCriterion("d_type =", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeNotEqualTo(String value) {
            addCriterion("d_type <>", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeGreaterThan(String value) {
            addCriterion("d_type >", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeGreaterThanOrEqualTo(String value) {
            addCriterion("d_type >=", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeLessThan(String value) {
            addCriterion("d_type <", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeLessThanOrEqualTo(String value) {
            addCriterion("d_type <=", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeLike(String value) {
            addCriterion("d_type like", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeNotLike(String value) {
            addCriterion("d_type not like", value, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeIn(List<String> values) {
            addCriterion("d_type in", values, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeNotIn(List<String> values) {
            addCriterion("d_type not in", values, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeBetween(String value1, String value2) {
            addCriterion("d_type between", value1, value2, "dType");
            return (Criteria) this;
        }

        public Criteria andDTypeNotBetween(String value1, String value2) {
            addCriterion("d_type not between", value1, value2, "dType");
            return (Criteria) this;
        }

        public Criteria andDActiveIsNull() {
            addCriterion("d_active is null");
            return (Criteria) this;
        }

        public Criteria andDActiveIsNotNull() {
            addCriterion("d_active is not null");
            return (Criteria) this;
        }

        public Criteria andDActiveEqualTo(Integer value) {
            addCriterion("d_active =", value, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveNotEqualTo(Integer value) {
            addCriterion("d_active <>", value, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveGreaterThan(Integer value) {
            addCriterion("d_active >", value, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_active >=", value, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveLessThan(Integer value) {
            addCriterion("d_active <", value, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveLessThanOrEqualTo(Integer value) {
            addCriterion("d_active <=", value, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveIn(List<Integer> values) {
            addCriterion("d_active in", values, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveNotIn(List<Integer> values) {
            addCriterion("d_active not in", values, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveBetween(Integer value1, Integer value2) {
            addCriterion("d_active between", value1, value2, "dActive");
            return (Criteria) this;
        }

        public Criteria andDActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("d_active not between", value1, value2, "dActive");
            return (Criteria) this;
        }

        public Criteria andDIdleIsNull() {
            addCriterion("d_idle is null");
            return (Criteria) this;
        }

        public Criteria andDIdleIsNotNull() {
            addCriterion("d_idle is not null");
            return (Criteria) this;
        }

        public Criteria andDIdleEqualTo(Integer value) {
            addCriterion("d_idle =", value, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleNotEqualTo(Integer value) {
            addCriterion("d_idle <>", value, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleGreaterThan(Integer value) {
            addCriterion("d_idle >", value, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_idle >=", value, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleLessThan(Integer value) {
            addCriterion("d_idle <", value, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleLessThanOrEqualTo(Integer value) {
            addCriterion("d_idle <=", value, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleIn(List<Integer> values) {
            addCriterion("d_idle in", values, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleNotIn(List<Integer> values) {
            addCriterion("d_idle not in", values, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleBetween(Integer value1, Integer value2) {
            addCriterion("d_idle between", value1, value2, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDIdleNotBetween(Integer value1, Integer value2) {
            addCriterion("d_idle not between", value1, value2, "dIdle");
            return (Criteria) this;
        }

        public Criteria andDSizeIsNull() {
            addCriterion("d_size is null");
            return (Criteria) this;
        }

        public Criteria andDSizeIsNotNull() {
            addCriterion("d_size is not null");
            return (Criteria) this;
        }

        public Criteria andDSizeEqualTo(Integer value) {
            addCriterion("d_size =", value, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeNotEqualTo(Integer value) {
            addCriterion("d_size <>", value, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeGreaterThan(Integer value) {
            addCriterion("d_size >", value, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_size >=", value, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeLessThan(Integer value) {
            addCriterion("d_size <", value, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeLessThanOrEqualTo(Integer value) {
            addCriterion("d_size <=", value, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeIn(List<Integer> values) {
            addCriterion("d_size in", values, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeNotIn(List<Integer> values) {
            addCriterion("d_size not in", values, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeBetween(Integer value1, Integer value2) {
            addCriterion("d_size between", value1, value2, "dSize");
            return (Criteria) this;
        }

        public Criteria andDSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("d_size not between", value1, value2, "dSize");
            return (Criteria) this;
        }

        public Criteria andDExecuteIsNull() {
            addCriterion("d_execute is null");
            return (Criteria) this;
        }

        public Criteria andDExecuteIsNotNull() {
            addCriterion("d_execute is not null");
            return (Criteria) this;
        }

        public Criteria andDExecuteEqualTo(Long value) {
            addCriterion("d_execute =", value, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteNotEqualTo(Long value) {
            addCriterion("d_execute <>", value, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteGreaterThan(Long value) {
            addCriterion("d_execute >", value, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteGreaterThanOrEqualTo(Long value) {
            addCriterion("d_execute >=", value, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteLessThan(Long value) {
            addCriterion("d_execute <", value, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteLessThanOrEqualTo(Long value) {
            addCriterion("d_execute <=", value, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteIn(List<Long> values) {
            addCriterion("d_execute in", values, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteNotIn(List<Long> values) {
            addCriterion("d_execute not in", values, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteBetween(Long value1, Long value2) {
            addCriterion("d_execute between", value1, value2, "dExecute");
            return (Criteria) this;
        }

        public Criteria andDExecuteNotBetween(Long value1, Long value2) {
            addCriterion("d_execute not between", value1, value2, "dExecute");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("total_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("total_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(Double value) {
            addCriterion("total_time =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(Double value) {
            addCriterion("total_time <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(Double value) {
            addCriterion("total_time >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("total_time >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(Double value) {
            addCriterion("total_time <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(Double value) {
            addCriterion("total_time <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<Double> values) {
            addCriterion("total_time in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<Double> values) {
            addCriterion("total_time not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(Double value1, Double value2) {
            addCriterion("total_time between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(Double value1, Double value2) {
            addCriterion("total_time not between", value1, value2, "totalTime");
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

        public Criteria andMaxSqlIsNull() {
            addCriterion("max_sql is null");
            return (Criteria) this;
        }

        public Criteria andMaxSqlIsNotNull() {
            addCriterion("max_sql is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSqlEqualTo(Long value) {
            addCriterion("max_sql =", value, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlNotEqualTo(Long value) {
            addCriterion("max_sql <>", value, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlGreaterThan(Long value) {
            addCriterion("max_sql >", value, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlGreaterThanOrEqualTo(Long value) {
            addCriterion("max_sql >=", value, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlLessThan(Long value) {
            addCriterion("max_sql <", value, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlLessThanOrEqualTo(Long value) {
            addCriterion("max_sql <=", value, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlIn(List<Long> values) {
            addCriterion("max_sql in", values, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlNotIn(List<Long> values) {
            addCriterion("max_sql not in", values, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlBetween(Long value1, Long value2) {
            addCriterion("max_sql between", value1, value2, "maxSql");
            return (Criteria) this;
        }

        public Criteria andMaxSqlNotBetween(Long value1, Long value2) {
            addCriterion("max_sql not between", value1, value2, "maxSql");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeIsNull() {
            addCriterion("recovery_time is null");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeIsNotNull() {
            addCriterion("recovery_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeEqualTo(Long value) {
            addCriterion("recovery_time =", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeNotEqualTo(Long value) {
            addCriterion("recovery_time <>", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeGreaterThan(Long value) {
            addCriterion("recovery_time >", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("recovery_time >=", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeLessThan(Long value) {
            addCriterion("recovery_time <", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeLessThanOrEqualTo(Long value) {
            addCriterion("recovery_time <=", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeIn(List<Long> values) {
            addCriterion("recovery_time in", values, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeNotIn(List<Long> values) {
            addCriterion("recovery_time not in", values, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeBetween(Long value1, Long value2) {
            addCriterion("recovery_time between", value1, value2, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeNotBetween(Long value1, Long value2) {
            addCriterion("recovery_time not between", value1, value2, "recoveryTime");
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