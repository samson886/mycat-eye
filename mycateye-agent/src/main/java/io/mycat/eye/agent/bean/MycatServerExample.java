package io.mycat.eye.agent.bean;

import java.util.ArrayList;
import java.util.List;

public class MycatServerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MycatServerExample() {
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

        public Criteria andServerNameIsNull() {
            addCriterion("server_name is null");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNotNull() {
            addCriterion("server_name is not null");
            return (Criteria) this;
        }

        public Criteria andServerNameEqualTo(String value) {
            addCriterion("server_name =", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotEqualTo(String value) {
            addCriterion("server_name <>", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThan(String value) {
            addCriterion("server_name >", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("server_name >=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThan(String value) {
            addCriterion("server_name <", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThanOrEqualTo(String value) {
            addCriterion("server_name <=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLike(String value) {
            addCriterion("server_name like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotLike(String value) {
            addCriterion("server_name not like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameIn(List<String> values) {
            addCriterion("server_name in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotIn(List<String> values) {
            addCriterion("server_name not in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameBetween(String value1, String value2) {
            addCriterion("server_name between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotBetween(String value1, String value2) {
            addCriterion("server_name not between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerHostIsNull() {
            addCriterion("server_host is null");
            return (Criteria) this;
        }

        public Criteria andServerHostIsNotNull() {
            addCriterion("server_host is not null");
            return (Criteria) this;
        }

        public Criteria andServerHostEqualTo(String value) {
            addCriterion("server_host =", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostNotEqualTo(String value) {
            addCriterion("server_host <>", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostGreaterThan(String value) {
            addCriterion("server_host >", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostGreaterThanOrEqualTo(String value) {
            addCriterion("server_host >=", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostLessThan(String value) {
            addCriterion("server_host <", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostLessThanOrEqualTo(String value) {
            addCriterion("server_host <=", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostLike(String value) {
            addCriterion("server_host like", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostNotLike(String value) {
            addCriterion("server_host not like", value, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostIn(List<String> values) {
            addCriterion("server_host in", values, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostNotIn(List<String> values) {
            addCriterion("server_host not in", values, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostBetween(String value1, String value2) {
            addCriterion("server_host between", value1, value2, "serverHost");
            return (Criteria) this;
        }

        public Criteria andServerHostNotBetween(String value1, String value2) {
            addCriterion("server_host not between", value1, value2, "serverHost");
            return (Criteria) this;
        }

        public Criteria andManagerPortIsNull() {
            addCriterion("manager_port is null");
            return (Criteria) this;
        }

        public Criteria andManagerPortIsNotNull() {
            addCriterion("manager_port is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPortEqualTo(Integer value) {
            addCriterion("manager_port =", value, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortNotEqualTo(Integer value) {
            addCriterion("manager_port <>", value, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortGreaterThan(Integer value) {
            addCriterion("manager_port >", value, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_port >=", value, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortLessThan(Integer value) {
            addCriterion("manager_port <", value, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortLessThanOrEqualTo(Integer value) {
            addCriterion("manager_port <=", value, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortIn(List<Integer> values) {
            addCriterion("manager_port in", values, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortNotIn(List<Integer> values) {
            addCriterion("manager_port not in", values, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortBetween(Integer value1, Integer value2) {
            addCriterion("manager_port between", value1, value2, "managerPort");
            return (Criteria) this;
        }

        public Criteria andManagerPortNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_port not between", value1, value2, "managerPort");
            return (Criteria) this;
        }

        public Criteria andServerPortIsNull() {
            addCriterion("server_port is null");
            return (Criteria) this;
        }

        public Criteria andServerPortIsNotNull() {
            addCriterion("server_port is not null");
            return (Criteria) this;
        }

        public Criteria andServerPortEqualTo(Integer value) {
            addCriterion("server_port =", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortNotEqualTo(Integer value) {
            addCriterion("server_port <>", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortGreaterThan(Integer value) {
            addCriterion("server_port >", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_port >=", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortLessThan(Integer value) {
            addCriterion("server_port <", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortLessThanOrEqualTo(Integer value) {
            addCriterion("server_port <=", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortIn(List<Integer> values) {
            addCriterion("server_port in", values, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortNotIn(List<Integer> values) {
            addCriterion("server_port not in", values, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortBetween(Integer value1, Integer value2) {
            addCriterion("server_port between", value1, value2, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortNotBetween(Integer value1, Integer value2) {
            addCriterion("server_port not between", value1, value2, "serverPort");
            return (Criteria) this;
        }

        public Criteria andStartupIsNull() {
            addCriterion("startup is null");
            return (Criteria) this;
        }

        public Criteria andStartupIsNotNull() {
            addCriterion("startup is not null");
            return (Criteria) this;
        }

        public Criteria andStartupEqualTo(Long value) {
            addCriterion("startup =", value, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupNotEqualTo(Long value) {
            addCriterion("startup <>", value, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupGreaterThan(Long value) {
            addCriterion("startup >", value, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupGreaterThanOrEqualTo(Long value) {
            addCriterion("startup >=", value, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupLessThan(Long value) {
            addCriterion("startup <", value, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupLessThanOrEqualTo(Long value) {
            addCriterion("startup <=", value, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupIn(List<Long> values) {
            addCriterion("startup in", values, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupNotIn(List<Long> values) {
            addCriterion("startup not in", values, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupBetween(Long value1, Long value2) {
            addCriterion("startup between", value1, value2, "startup");
            return (Criteria) this;
        }

        public Criteria andStartupNotBetween(Long value1, Long value2) {
            addCriterion("startup not between", value1, value2, "startup");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNull() {
            addCriterion("cluster_id is null");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNotNull() {
            addCriterion("cluster_id is not null");
            return (Criteria) this;
        }

        public Criteria andClusterIdEqualTo(Integer value) {
            addCriterion("cluster_id =", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotEqualTo(Integer value) {
            addCriterion("cluster_id <>", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThan(Integer value) {
            addCriterion("cluster_id >", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_id >=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThan(Integer value) {
            addCriterion("cluster_id <", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_id <=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdIn(List<Integer> values) {
            addCriterion("cluster_id in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotIn(List<Integer> values) {
            addCriterion("cluster_id not in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdBetween(Integer value1, Integer value2) {
            addCriterion("cluster_id between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_id not between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeIsNull() {
            addCriterion("is_cluster_node is null");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeIsNotNull() {
            addCriterion("is_cluster_node is not null");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeEqualTo(Byte value) {
            addCriterion("is_cluster_node =", value, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeNotEqualTo(Byte value) {
            addCriterion("is_cluster_node <>", value, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeGreaterThan(Byte value) {
            addCriterion("is_cluster_node >", value, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_cluster_node >=", value, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeLessThan(Byte value) {
            addCriterion("is_cluster_node <", value, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeLessThanOrEqualTo(Byte value) {
            addCriterion("is_cluster_node <=", value, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeIn(List<Byte> values) {
            addCriterion("is_cluster_node in", values, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeNotIn(List<Byte> values) {
            addCriterion("is_cluster_node not in", values, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeBetween(Byte value1, Byte value2) {
            addCriterion("is_cluster_node between", value1, value2, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andIsClusterNodeNotBetween(Byte value1, Byte value2) {
            addCriterion("is_cluster_node not between", value1, value2, "isClusterNode");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Long value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Long value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Long value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Long value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Long> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Long> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryIsNull() {
            addCriterion("startup_history is null");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryIsNotNull() {
            addCriterion("startup_history is not null");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryEqualTo(String value) {
            addCriterion("startup_history =", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryNotEqualTo(String value) {
            addCriterion("startup_history <>", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryGreaterThan(String value) {
            addCriterion("startup_history >", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("startup_history >=", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryLessThan(String value) {
            addCriterion("startup_history <", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryLessThanOrEqualTo(String value) {
            addCriterion("startup_history <=", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryLike(String value) {
            addCriterion("startup_history like", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryNotLike(String value) {
            addCriterion("startup_history not like", value, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryIn(List<String> values) {
            addCriterion("startup_history in", values, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryNotIn(List<String> values) {
            addCriterion("startup_history not in", values, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryBetween(String value1, String value2) {
            addCriterion("startup_history between", value1, value2, "startupHistory");
            return (Criteria) this;
        }

        public Criteria andStartupHistoryNotBetween(String value1, String value2) {
            addCriterion("startup_history not between", value1, value2, "startupHistory");
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