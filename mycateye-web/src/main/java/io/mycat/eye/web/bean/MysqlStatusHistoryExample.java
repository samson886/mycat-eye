package io.mycat.eye.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MysqlStatusHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public MysqlStatusHistoryExample() {
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

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Long value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Long value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Long value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Long value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Long value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Long> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Long> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Long value1, Long value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Long value1, Long value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
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

        public Criteria andOpenTablesIsNull() {
            addCriterion("open_tables is null");
            return (Criteria) this;
        }

        public Criteria andOpenTablesIsNotNull() {
            addCriterion("open_tables is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTablesEqualTo(Integer value) {
            addCriterion("open_tables =", value, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesNotEqualTo(Integer value) {
            addCriterion("open_tables <>", value, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesGreaterThan(Integer value) {
            addCriterion("open_tables >", value, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_tables >=", value, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesLessThan(Integer value) {
            addCriterion("open_tables <", value, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesLessThanOrEqualTo(Integer value) {
            addCriterion("open_tables <=", value, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesIn(List<Integer> values) {
            addCriterion("open_tables in", values, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesNotIn(List<Integer> values) {
            addCriterion("open_tables not in", values, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesBetween(Integer value1, Integer value2) {
            addCriterion("open_tables between", value1, value2, "openTables");
            return (Criteria) this;
        }

        public Criteria andOpenTablesNotBetween(Integer value1, Integer value2) {
            addCriterion("open_tables not between", value1, value2, "openTables");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedIsNull() {
            addCriterion("threads_connected is null");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedIsNotNull() {
            addCriterion("threads_connected is not null");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedEqualTo(Integer value) {
            addCriterion("threads_connected =", value, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedNotEqualTo(Integer value) {
            addCriterion("threads_connected <>", value, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedGreaterThan(Integer value) {
            addCriterion("threads_connected >", value, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedGreaterThanOrEqualTo(Integer value) {
            addCriterion("threads_connected >=", value, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedLessThan(Integer value) {
            addCriterion("threads_connected <", value, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedLessThanOrEqualTo(Integer value) {
            addCriterion("threads_connected <=", value, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedIn(List<Integer> values) {
            addCriterion("threads_connected in", values, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedNotIn(List<Integer> values) {
            addCriterion("threads_connected not in", values, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedBetween(Integer value1, Integer value2) {
            addCriterion("threads_connected between", value1, value2, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsConnectedNotBetween(Integer value1, Integer value2) {
            addCriterion("threads_connected not between", value1, value2, "threadsConnected");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningIsNull() {
            addCriterion("threads_running is null");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningIsNotNull() {
            addCriterion("threads_running is not null");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningEqualTo(Integer value) {
            addCriterion("threads_running =", value, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningNotEqualTo(Integer value) {
            addCriterion("threads_running <>", value, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningGreaterThan(Integer value) {
            addCriterion("threads_running >", value, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningGreaterThanOrEqualTo(Integer value) {
            addCriterion("threads_running >=", value, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningLessThan(Integer value) {
            addCriterion("threads_running <", value, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningLessThanOrEqualTo(Integer value) {
            addCriterion("threads_running <=", value, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningIn(List<Integer> values) {
            addCriterion("threads_running in", values, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningNotIn(List<Integer> values) {
            addCriterion("threads_running not in", values, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningBetween(Integer value1, Integer value2) {
            addCriterion("threads_running between", value1, value2, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsRunningNotBetween(Integer value1, Integer value2) {
            addCriterion("threads_running not between", value1, value2, "threadsRunning");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedIsNull() {
            addCriterion("threads_created is null");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedIsNotNull() {
            addCriterion("threads_created is not null");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedEqualTo(Integer value) {
            addCriterion("threads_created =", value, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedNotEqualTo(Integer value) {
            addCriterion("threads_created <>", value, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedGreaterThan(Integer value) {
            addCriterion("threads_created >", value, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("threads_created >=", value, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedLessThan(Integer value) {
            addCriterion("threads_created <", value, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("threads_created <=", value, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedIn(List<Integer> values) {
            addCriterion("threads_created in", values, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedNotIn(List<Integer> values) {
            addCriterion("threads_created not in", values, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedBetween(Integer value1, Integer value2) {
            addCriterion("threads_created between", value1, value2, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("threads_created not between", value1, value2, "threadsCreated");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedIsNull() {
            addCriterion("threads_cached is null");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedIsNotNull() {
            addCriterion("threads_cached is not null");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedEqualTo(Integer value) {
            addCriterion("threads_cached =", value, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedNotEqualTo(Integer value) {
            addCriterion("threads_cached <>", value, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedGreaterThan(Integer value) {
            addCriterion("threads_cached >", value, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedGreaterThanOrEqualTo(Integer value) {
            addCriterion("threads_cached >=", value, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedLessThan(Integer value) {
            addCriterion("threads_cached <", value, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedLessThanOrEqualTo(Integer value) {
            addCriterion("threads_cached <=", value, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedIn(List<Integer> values) {
            addCriterion("threads_cached in", values, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedNotIn(List<Integer> values) {
            addCriterion("threads_cached not in", values, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedBetween(Integer value1, Integer value2) {
            addCriterion("threads_cached between", value1, value2, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andThreadsCachedNotBetween(Integer value1, Integer value2) {
            addCriterion("threads_cached not between", value1, value2, "threadsCached");
            return (Criteria) this;
        }

        public Criteria andConnectionsIsNull() {
            addCriterion("connections is null");
            return (Criteria) this;
        }

        public Criteria andConnectionsIsNotNull() {
            addCriterion("connections is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionsEqualTo(Integer value) {
            addCriterion("connections =", value, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsNotEqualTo(Integer value) {
            addCriterion("connections <>", value, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsGreaterThan(Integer value) {
            addCriterion("connections >", value, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("connections >=", value, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsLessThan(Integer value) {
            addCriterion("connections <", value, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsLessThanOrEqualTo(Integer value) {
            addCriterion("connections <=", value, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsIn(List<Integer> values) {
            addCriterion("connections in", values, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsNotIn(List<Integer> values) {
            addCriterion("connections not in", values, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsBetween(Integer value1, Integer value2) {
            addCriterion("connections between", value1, value2, "connections");
            return (Criteria) this;
        }

        public Criteria andConnectionsNotBetween(Integer value1, Integer value2) {
            addCriterion("connections not between", value1, value2, "connections");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsIsNull() {
            addCriterion("aborted_clients is null");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsIsNotNull() {
            addCriterion("aborted_clients is not null");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsEqualTo(Integer value) {
            addCriterion("aborted_clients =", value, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsNotEqualTo(Integer value) {
            addCriterion("aborted_clients <>", value, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsGreaterThan(Integer value) {
            addCriterion("aborted_clients >", value, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsGreaterThanOrEqualTo(Integer value) {
            addCriterion("aborted_clients >=", value, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsLessThan(Integer value) {
            addCriterion("aborted_clients <", value, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsLessThanOrEqualTo(Integer value) {
            addCriterion("aborted_clients <=", value, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsIn(List<Integer> values) {
            addCriterion("aborted_clients in", values, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsNotIn(List<Integer> values) {
            addCriterion("aborted_clients not in", values, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsBetween(Integer value1, Integer value2) {
            addCriterion("aborted_clients between", value1, value2, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedClientsNotBetween(Integer value1, Integer value2) {
            addCriterion("aborted_clients not between", value1, value2, "abortedClients");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsIsNull() {
            addCriterion("aborted_connects is null");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsIsNotNull() {
            addCriterion("aborted_connects is not null");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsEqualTo(Integer value) {
            addCriterion("aborted_connects =", value, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsNotEqualTo(Integer value) {
            addCriterion("aborted_connects <>", value, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsGreaterThan(Integer value) {
            addCriterion("aborted_connects >", value, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsGreaterThanOrEqualTo(Integer value) {
            addCriterion("aborted_connects >=", value, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsLessThan(Integer value) {
            addCriterion("aborted_connects <", value, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsLessThanOrEqualTo(Integer value) {
            addCriterion("aborted_connects <=", value, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsIn(List<Integer> values) {
            addCriterion("aborted_connects in", values, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsNotIn(List<Integer> values) {
            addCriterion("aborted_connects not in", values, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsBetween(Integer value1, Integer value2) {
            addCriterion("aborted_connects between", value1, value2, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andAbortedConnectsNotBetween(Integer value1, Integer value2) {
            addCriterion("aborted_connects not between", value1, value2, "abortedConnects");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedIsNull() {
            addCriterion("bytes_received is null");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedIsNotNull() {
            addCriterion("bytes_received is not null");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedEqualTo(Long value) {
            addCriterion("bytes_received =", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedNotEqualTo(Long value) {
            addCriterion("bytes_received <>", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedGreaterThan(Long value) {
            addCriterion("bytes_received >", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedGreaterThanOrEqualTo(Long value) {
            addCriterion("bytes_received >=", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedLessThan(Long value) {
            addCriterion("bytes_received <", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedLessThanOrEqualTo(Long value) {
            addCriterion("bytes_received <=", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedIn(List<Long> values) {
            addCriterion("bytes_received in", values, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedNotIn(List<Long> values) {
            addCriterion("bytes_received not in", values, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedBetween(Long value1, Long value2) {
            addCriterion("bytes_received between", value1, value2, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedNotBetween(Long value1, Long value2) {
            addCriterion("bytes_received not between", value1, value2, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondIsNull() {
            addCriterion("bytes_received_persecond is null");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondIsNotNull() {
            addCriterion("bytes_received_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondEqualTo(String value) {
            addCriterion("bytes_received_persecond =", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondNotEqualTo(String value) {
            addCriterion("bytes_received_persecond <>", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondGreaterThan(String value) {
            addCriterion("bytes_received_persecond >", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("bytes_received_persecond >=", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondLessThan(String value) {
            addCriterion("bytes_received_persecond <", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondLessThanOrEqualTo(String value) {
            addCriterion("bytes_received_persecond <=", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondLike(String value) {
            addCriterion("bytes_received_persecond like", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondNotLike(String value) {
            addCriterion("bytes_received_persecond not like", value, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondIn(List<String> values) {
            addCriterion("bytes_received_persecond in", values, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondNotIn(List<String> values) {
            addCriterion("bytes_received_persecond not in", values, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondBetween(String value1, String value2) {
            addCriterion("bytes_received_persecond between", value1, value2, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedPersecondNotBetween(String value1, String value2) {
            addCriterion("bytes_received_persecond not between", value1, value2, "bytesReceivedPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentIsNull() {
            addCriterion("bytes_sent is null");
            return (Criteria) this;
        }

        public Criteria andBytesSentIsNotNull() {
            addCriterion("bytes_sent is not null");
            return (Criteria) this;
        }

        public Criteria andBytesSentEqualTo(Long value) {
            addCriterion("bytes_sent =", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotEqualTo(Long value) {
            addCriterion("bytes_sent <>", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentGreaterThan(Long value) {
            addCriterion("bytes_sent >", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentGreaterThanOrEqualTo(Long value) {
            addCriterion("bytes_sent >=", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentLessThan(Long value) {
            addCriterion("bytes_sent <", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentLessThanOrEqualTo(Long value) {
            addCriterion("bytes_sent <=", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentIn(List<Long> values) {
            addCriterion("bytes_sent in", values, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotIn(List<Long> values) {
            addCriterion("bytes_sent not in", values, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentBetween(Long value1, Long value2) {
            addCriterion("bytes_sent between", value1, value2, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotBetween(Long value1, Long value2) {
            addCriterion("bytes_sent not between", value1, value2, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondIsNull() {
            addCriterion("bytes_sent_persecond is null");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondIsNotNull() {
            addCriterion("bytes_sent_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondEqualTo(String value) {
            addCriterion("bytes_sent_persecond =", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondNotEqualTo(String value) {
            addCriterion("bytes_sent_persecond <>", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondGreaterThan(String value) {
            addCriterion("bytes_sent_persecond >", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("bytes_sent_persecond >=", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondLessThan(String value) {
            addCriterion("bytes_sent_persecond <", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondLessThanOrEqualTo(String value) {
            addCriterion("bytes_sent_persecond <=", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondLike(String value) {
            addCriterion("bytes_sent_persecond like", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondNotLike(String value) {
            addCriterion("bytes_sent_persecond not like", value, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondIn(List<String> values) {
            addCriterion("bytes_sent_persecond in", values, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondNotIn(List<String> values) {
            addCriterion("bytes_sent_persecond not in", values, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondBetween(String value1, String value2) {
            addCriterion("bytes_sent_persecond between", value1, value2, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andBytesSentPersecondNotBetween(String value1, String value2) {
            addCriterion("bytes_sent_persecond not between", value1, value2, "bytesSentPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectIsNull() {
            addCriterion("com_select is null");
            return (Criteria) this;
        }

        public Criteria andComSelectIsNotNull() {
            addCriterion("com_select is not null");
            return (Criteria) this;
        }

        public Criteria andComSelectEqualTo(Long value) {
            addCriterion("com_select =", value, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectNotEqualTo(Long value) {
            addCriterion("com_select <>", value, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectGreaterThan(Long value) {
            addCriterion("com_select >", value, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectGreaterThanOrEqualTo(Long value) {
            addCriterion("com_select >=", value, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectLessThan(Long value) {
            addCriterion("com_select <", value, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectLessThanOrEqualTo(Long value) {
            addCriterion("com_select <=", value, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectIn(List<Long> values) {
            addCriterion("com_select in", values, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectNotIn(List<Long> values) {
            addCriterion("com_select not in", values, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectBetween(Long value1, Long value2) {
            addCriterion("com_select between", value1, value2, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectNotBetween(Long value1, Long value2) {
            addCriterion("com_select not between", value1, value2, "comSelect");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondIsNull() {
            addCriterion("com_select_persecond is null");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondIsNotNull() {
            addCriterion("com_select_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondEqualTo(String value) {
            addCriterion("com_select_persecond =", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondNotEqualTo(String value) {
            addCriterion("com_select_persecond <>", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondGreaterThan(String value) {
            addCriterion("com_select_persecond >", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("com_select_persecond >=", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondLessThan(String value) {
            addCriterion("com_select_persecond <", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondLessThanOrEqualTo(String value) {
            addCriterion("com_select_persecond <=", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondLike(String value) {
            addCriterion("com_select_persecond like", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondNotLike(String value) {
            addCriterion("com_select_persecond not like", value, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondIn(List<String> values) {
            addCriterion("com_select_persecond in", values, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondNotIn(List<String> values) {
            addCriterion("com_select_persecond not in", values, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondBetween(String value1, String value2) {
            addCriterion("com_select_persecond between", value1, value2, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComSelectPersecondNotBetween(String value1, String value2) {
            addCriterion("com_select_persecond not between", value1, value2, "comSelectPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertIsNull() {
            addCriterion("com_insert is null");
            return (Criteria) this;
        }

        public Criteria andComInsertIsNotNull() {
            addCriterion("com_insert is not null");
            return (Criteria) this;
        }

        public Criteria andComInsertEqualTo(Long value) {
            addCriterion("com_insert =", value, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertNotEqualTo(Long value) {
            addCriterion("com_insert <>", value, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertGreaterThan(Long value) {
            addCriterion("com_insert >", value, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertGreaterThanOrEqualTo(Long value) {
            addCriterion("com_insert >=", value, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertLessThan(Long value) {
            addCriterion("com_insert <", value, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertLessThanOrEqualTo(Long value) {
            addCriterion("com_insert <=", value, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertIn(List<Long> values) {
            addCriterion("com_insert in", values, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertNotIn(List<Long> values) {
            addCriterion("com_insert not in", values, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertBetween(Long value1, Long value2) {
            addCriterion("com_insert between", value1, value2, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertNotBetween(Long value1, Long value2) {
            addCriterion("com_insert not between", value1, value2, "comInsert");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondIsNull() {
            addCriterion("com_insert_persecond is null");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondIsNotNull() {
            addCriterion("com_insert_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondEqualTo(String value) {
            addCriterion("com_insert_persecond =", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondNotEqualTo(String value) {
            addCriterion("com_insert_persecond <>", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondGreaterThan(String value) {
            addCriterion("com_insert_persecond >", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("com_insert_persecond >=", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondLessThan(String value) {
            addCriterion("com_insert_persecond <", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondLessThanOrEqualTo(String value) {
            addCriterion("com_insert_persecond <=", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondLike(String value) {
            addCriterion("com_insert_persecond like", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondNotLike(String value) {
            addCriterion("com_insert_persecond not like", value, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondIn(List<String> values) {
            addCriterion("com_insert_persecond in", values, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondNotIn(List<String> values) {
            addCriterion("com_insert_persecond not in", values, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondBetween(String value1, String value2) {
            addCriterion("com_insert_persecond between", value1, value2, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComInsertPersecondNotBetween(String value1, String value2) {
            addCriterion("com_insert_persecond not between", value1, value2, "comInsertPersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdateIsNull() {
            addCriterion("com_update is null");
            return (Criteria) this;
        }

        public Criteria andComUpdateIsNotNull() {
            addCriterion("com_update is not null");
            return (Criteria) this;
        }

        public Criteria andComUpdateEqualTo(Long value) {
            addCriterion("com_update =", value, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateNotEqualTo(Long value) {
            addCriterion("com_update <>", value, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateGreaterThan(Long value) {
            addCriterion("com_update >", value, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateGreaterThanOrEqualTo(Long value) {
            addCriterion("com_update >=", value, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateLessThan(Long value) {
            addCriterion("com_update <", value, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateLessThanOrEqualTo(Long value) {
            addCriterion("com_update <=", value, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateIn(List<Long> values) {
            addCriterion("com_update in", values, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateNotIn(List<Long> values) {
            addCriterion("com_update not in", values, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateBetween(Long value1, Long value2) {
            addCriterion("com_update between", value1, value2, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdateNotBetween(Long value1, Long value2) {
            addCriterion("com_update not between", value1, value2, "comUpdate");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondIsNull() {
            addCriterion("com_update_persecond is null");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondIsNotNull() {
            addCriterion("com_update_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondEqualTo(String value) {
            addCriterion("com_update_persecond =", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondNotEqualTo(String value) {
            addCriterion("com_update_persecond <>", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondGreaterThan(String value) {
            addCriterion("com_update_persecond >", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondGreaterThanOrEqualTo(String value) {
            addCriterion("com_update_persecond >=", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondLessThan(String value) {
            addCriterion("com_update_persecond <", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondLessThanOrEqualTo(String value) {
            addCriterion("com_update_persecond <=", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondLike(String value) {
            addCriterion("com_update_persecond like", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondNotLike(String value) {
            addCriterion("com_update_persecond not like", value, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondIn(List<String> values) {
            addCriterion("com_update_persecond in", values, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondNotIn(List<String> values) {
            addCriterion("com_update_persecond not in", values, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondBetween(String value1, String value2) {
            addCriterion("com_update_persecond between", value1, value2, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComUpdatePersecondNotBetween(String value1, String value2) {
            addCriterion("com_update_persecond not between", value1, value2, "comUpdatePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeleteIsNull() {
            addCriterion("com_delete is null");
            return (Criteria) this;
        }

        public Criteria andComDeleteIsNotNull() {
            addCriterion("com_delete is not null");
            return (Criteria) this;
        }

        public Criteria andComDeleteEqualTo(Long value) {
            addCriterion("com_delete =", value, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteNotEqualTo(Long value) {
            addCriterion("com_delete <>", value, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteGreaterThan(Long value) {
            addCriterion("com_delete >", value, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteGreaterThanOrEqualTo(Long value) {
            addCriterion("com_delete >=", value, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteLessThan(Long value) {
            addCriterion("com_delete <", value, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteLessThanOrEqualTo(Long value) {
            addCriterion("com_delete <=", value, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteIn(List<Long> values) {
            addCriterion("com_delete in", values, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteNotIn(List<Long> values) {
            addCriterion("com_delete not in", values, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteBetween(Long value1, Long value2) {
            addCriterion("com_delete between", value1, value2, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeleteNotBetween(Long value1, Long value2) {
            addCriterion("com_delete not between", value1, value2, "comDelete");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondIsNull() {
            addCriterion("com_delete_persecond is null");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondIsNotNull() {
            addCriterion("com_delete_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondEqualTo(String value) {
            addCriterion("com_delete_persecond =", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondNotEqualTo(String value) {
            addCriterion("com_delete_persecond <>", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondGreaterThan(String value) {
            addCriterion("com_delete_persecond >", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondGreaterThanOrEqualTo(String value) {
            addCriterion("com_delete_persecond >=", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondLessThan(String value) {
            addCriterion("com_delete_persecond <", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondLessThanOrEqualTo(String value) {
            addCriterion("com_delete_persecond <=", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondLike(String value) {
            addCriterion("com_delete_persecond like", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondNotLike(String value) {
            addCriterion("com_delete_persecond not like", value, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondIn(List<String> values) {
            addCriterion("com_delete_persecond in", values, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondNotIn(List<String> values) {
            addCriterion("com_delete_persecond not in", values, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondBetween(String value1, String value2) {
            addCriterion("com_delete_persecond between", value1, value2, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComDeletePersecondNotBetween(String value1, String value2) {
            addCriterion("com_delete_persecond not between", value1, value2, "comDeletePersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitIsNull() {
            addCriterion("com_commit is null");
            return (Criteria) this;
        }

        public Criteria andComCommitIsNotNull() {
            addCriterion("com_commit is not null");
            return (Criteria) this;
        }

        public Criteria andComCommitEqualTo(Long value) {
            addCriterion("com_commit =", value, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitNotEqualTo(Long value) {
            addCriterion("com_commit <>", value, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitGreaterThan(Long value) {
            addCriterion("com_commit >", value, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitGreaterThanOrEqualTo(Long value) {
            addCriterion("com_commit >=", value, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitLessThan(Long value) {
            addCriterion("com_commit <", value, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitLessThanOrEqualTo(Long value) {
            addCriterion("com_commit <=", value, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitIn(List<Long> values) {
            addCriterion("com_commit in", values, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitNotIn(List<Long> values) {
            addCriterion("com_commit not in", values, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitBetween(Long value1, Long value2) {
            addCriterion("com_commit between", value1, value2, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitNotBetween(Long value1, Long value2) {
            addCriterion("com_commit not between", value1, value2, "comCommit");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondIsNull() {
            addCriterion("com_commit_persecond is null");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondIsNotNull() {
            addCriterion("com_commit_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondEqualTo(String value) {
            addCriterion("com_commit_persecond =", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondNotEqualTo(String value) {
            addCriterion("com_commit_persecond <>", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondGreaterThan(String value) {
            addCriterion("com_commit_persecond >", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("com_commit_persecond >=", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondLessThan(String value) {
            addCriterion("com_commit_persecond <", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondLessThanOrEqualTo(String value) {
            addCriterion("com_commit_persecond <=", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondLike(String value) {
            addCriterion("com_commit_persecond like", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondNotLike(String value) {
            addCriterion("com_commit_persecond not like", value, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondIn(List<String> values) {
            addCriterion("com_commit_persecond in", values, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondNotIn(List<String> values) {
            addCriterion("com_commit_persecond not in", values, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondBetween(String value1, String value2) {
            addCriterion("com_commit_persecond between", value1, value2, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComCommitPersecondNotBetween(String value1, String value2) {
            addCriterion("com_commit_persecond not between", value1, value2, "comCommitPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackIsNull() {
            addCriterion("com_rollback is null");
            return (Criteria) this;
        }

        public Criteria andComRollbackIsNotNull() {
            addCriterion("com_rollback is not null");
            return (Criteria) this;
        }

        public Criteria andComRollbackEqualTo(Long value) {
            addCriterion("com_rollback =", value, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackNotEqualTo(Long value) {
            addCriterion("com_rollback <>", value, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackGreaterThan(Long value) {
            addCriterion("com_rollback >", value, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackGreaterThanOrEqualTo(Long value) {
            addCriterion("com_rollback >=", value, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackLessThan(Long value) {
            addCriterion("com_rollback <", value, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackLessThanOrEqualTo(Long value) {
            addCriterion("com_rollback <=", value, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackIn(List<Long> values) {
            addCriterion("com_rollback in", values, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackNotIn(List<Long> values) {
            addCriterion("com_rollback not in", values, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackBetween(Long value1, Long value2) {
            addCriterion("com_rollback between", value1, value2, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackNotBetween(Long value1, Long value2) {
            addCriterion("com_rollback not between", value1, value2, "comRollback");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondIsNull() {
            addCriterion("com_rollback_persecond is null");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondIsNotNull() {
            addCriterion("com_rollback_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondEqualTo(String value) {
            addCriterion("com_rollback_persecond =", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondNotEqualTo(String value) {
            addCriterion("com_rollback_persecond <>", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondGreaterThan(String value) {
            addCriterion("com_rollback_persecond >", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("com_rollback_persecond >=", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondLessThan(String value) {
            addCriterion("com_rollback_persecond <", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondLessThanOrEqualTo(String value) {
            addCriterion("com_rollback_persecond <=", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondLike(String value) {
            addCriterion("com_rollback_persecond like", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondNotLike(String value) {
            addCriterion("com_rollback_persecond not like", value, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondIn(List<String> values) {
            addCriterion("com_rollback_persecond in", values, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondNotIn(List<String> values) {
            addCriterion("com_rollback_persecond not in", values, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondBetween(String value1, String value2) {
            addCriterion("com_rollback_persecond between", value1, value2, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andComRollbackPersecondNotBetween(String value1, String value2) {
            addCriterion("com_rollback_persecond not between", value1, value2, "comRollbackPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsIsNull() {
            addCriterion("questions is null");
            return (Criteria) this;
        }

        public Criteria andQuestionsIsNotNull() {
            addCriterion("questions is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionsEqualTo(Long value) {
            addCriterion("questions =", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsNotEqualTo(Long value) {
            addCriterion("questions <>", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsGreaterThan(Long value) {
            addCriterion("questions >", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsGreaterThanOrEqualTo(Long value) {
            addCriterion("questions >=", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsLessThan(Long value) {
            addCriterion("questions <", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsLessThanOrEqualTo(Long value) {
            addCriterion("questions <=", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsIn(List<Long> values) {
            addCriterion("questions in", values, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsNotIn(List<Long> values) {
            addCriterion("questions not in", values, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsBetween(Long value1, Long value2) {
            addCriterion("questions between", value1, value2, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsNotBetween(Long value1, Long value2) {
            addCriterion("questions not between", value1, value2, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondIsNull() {
            addCriterion("questions_persecond is null");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondIsNotNull() {
            addCriterion("questions_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondEqualTo(String value) {
            addCriterion("questions_persecond =", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondNotEqualTo(String value) {
            addCriterion("questions_persecond <>", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondGreaterThan(String value) {
            addCriterion("questions_persecond >", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("questions_persecond >=", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondLessThan(String value) {
            addCriterion("questions_persecond <", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondLessThanOrEqualTo(String value) {
            addCriterion("questions_persecond <=", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondLike(String value) {
            addCriterion("questions_persecond like", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondNotLike(String value) {
            addCriterion("questions_persecond not like", value, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondIn(List<String> values) {
            addCriterion("questions_persecond in", values, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondNotIn(List<String> values) {
            addCriterion("questions_persecond not in", values, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondBetween(String value1, String value2) {
            addCriterion("questions_persecond between", value1, value2, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andQuestionsPersecondNotBetween(String value1, String value2) {
            addCriterion("questions_persecond not between", value1, value2, "questionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsIsNull() {
            addCriterion("transactions is null");
            return (Criteria) this;
        }

        public Criteria andTransactionsIsNotNull() {
            addCriterion("transactions is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionsEqualTo(Long value) {
            addCriterion("transactions =", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsNotEqualTo(Long value) {
            addCriterion("transactions <>", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsGreaterThan(Long value) {
            addCriterion("transactions >", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsGreaterThanOrEqualTo(Long value) {
            addCriterion("transactions >=", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsLessThan(Long value) {
            addCriterion("transactions <", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsLessThanOrEqualTo(Long value) {
            addCriterion("transactions <=", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsIn(List<Long> values) {
            addCriterion("transactions in", values, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsNotIn(List<Long> values) {
            addCriterion("transactions not in", values, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsBetween(Long value1, Long value2) {
            addCriterion("transactions between", value1, value2, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsNotBetween(Long value1, Long value2) {
            addCriterion("transactions not between", value1, value2, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondIsNull() {
            addCriterion("transactions_persecond is null");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondIsNotNull() {
            addCriterion("transactions_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondEqualTo(String value) {
            addCriterion("transactions_persecond =", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondNotEqualTo(String value) {
            addCriterion("transactions_persecond <>", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondGreaterThan(String value) {
            addCriterion("transactions_persecond >", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("transactions_persecond >=", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondLessThan(String value) {
            addCriterion("transactions_persecond <", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondLessThanOrEqualTo(String value) {
            addCriterion("transactions_persecond <=", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondLike(String value) {
            addCriterion("transactions_persecond like", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondNotLike(String value) {
            addCriterion("transactions_persecond not like", value, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondIn(List<String> values) {
            addCriterion("transactions_persecond in", values, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondNotIn(List<String> values) {
            addCriterion("transactions_persecond not in", values, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondBetween(String value1, String value2) {
            addCriterion("transactions_persecond between", value1, value2, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andTransactionsPersecondNotBetween(String value1, String value2) {
            addCriterion("transactions_persecond not between", value1, value2, "transactionsPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesIsNull() {
            addCriterion("created_tmp_tables is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesIsNotNull() {
            addCriterion("created_tmp_tables is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesEqualTo(Long value) {
            addCriterion("created_tmp_tables =", value, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesNotEqualTo(Long value) {
            addCriterion("created_tmp_tables <>", value, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesGreaterThan(Long value) {
            addCriterion("created_tmp_tables >", value, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesGreaterThanOrEqualTo(Long value) {
            addCriterion("created_tmp_tables >=", value, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesLessThan(Long value) {
            addCriterion("created_tmp_tables <", value, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesLessThanOrEqualTo(Long value) {
            addCriterion("created_tmp_tables <=", value, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesIn(List<Long> values) {
            addCriterion("created_tmp_tables in", values, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesNotIn(List<Long> values) {
            addCriterion("created_tmp_tables not in", values, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesBetween(Long value1, Long value2) {
            addCriterion("created_tmp_tables between", value1, value2, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesNotBetween(Long value1, Long value2) {
            addCriterion("created_tmp_tables not between", value1, value2, "createdTmpTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondIsNull() {
            addCriterion("created_tmp_tables_persecond is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondIsNotNull() {
            addCriterion("created_tmp_tables_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondEqualTo(String value) {
            addCriterion("created_tmp_tables_persecond =", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondNotEqualTo(String value) {
            addCriterion("created_tmp_tables_persecond <>", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondGreaterThan(String value) {
            addCriterion("created_tmp_tables_persecond >", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("created_tmp_tables_persecond >=", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondLessThan(String value) {
            addCriterion("created_tmp_tables_persecond <", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondLessThanOrEqualTo(String value) {
            addCriterion("created_tmp_tables_persecond <=", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondLike(String value) {
            addCriterion("created_tmp_tables_persecond like", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondNotLike(String value) {
            addCriterion("created_tmp_tables_persecond not like", value, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondIn(List<String> values) {
            addCriterion("created_tmp_tables_persecond in", values, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondNotIn(List<String> values) {
            addCriterion("created_tmp_tables_persecond not in", values, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondBetween(String value1, String value2) {
            addCriterion("created_tmp_tables_persecond between", value1, value2, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpTablesPersecondNotBetween(String value1, String value2) {
            addCriterion("created_tmp_tables_persecond not between", value1, value2, "createdTmpTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesIsNull() {
            addCriterion("created_tmp_disk_tables is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesIsNotNull() {
            addCriterion("created_tmp_disk_tables is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesEqualTo(Long value) {
            addCriterion("created_tmp_disk_tables =", value, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesNotEqualTo(Long value) {
            addCriterion("created_tmp_disk_tables <>", value, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesGreaterThan(Long value) {
            addCriterion("created_tmp_disk_tables >", value, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesGreaterThanOrEqualTo(Long value) {
            addCriterion("created_tmp_disk_tables >=", value, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesLessThan(Long value) {
            addCriterion("created_tmp_disk_tables <", value, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesLessThanOrEqualTo(Long value) {
            addCriterion("created_tmp_disk_tables <=", value, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesIn(List<Long> values) {
            addCriterion("created_tmp_disk_tables in", values, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesNotIn(List<Long> values) {
            addCriterion("created_tmp_disk_tables not in", values, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesBetween(Long value1, Long value2) {
            addCriterion("created_tmp_disk_tables between", value1, value2, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesNotBetween(Long value1, Long value2) {
            addCriterion("created_tmp_disk_tables not between", value1, value2, "createdTmpDiskTables");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondIsNull() {
            addCriterion("created_tmp_disk_tables_persecond is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondIsNotNull() {
            addCriterion("created_tmp_disk_tables_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondEqualTo(String value) {
            addCriterion("created_tmp_disk_tables_persecond =", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondNotEqualTo(String value) {
            addCriterion("created_tmp_disk_tables_persecond <>", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondGreaterThan(String value) {
            addCriterion("created_tmp_disk_tables_persecond >", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("created_tmp_disk_tables_persecond >=", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondLessThan(String value) {
            addCriterion("created_tmp_disk_tables_persecond <", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondLessThanOrEqualTo(String value) {
            addCriterion("created_tmp_disk_tables_persecond <=", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondLike(String value) {
            addCriterion("created_tmp_disk_tables_persecond like", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondNotLike(String value) {
            addCriterion("created_tmp_disk_tables_persecond not like", value, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondIn(List<String> values) {
            addCriterion("created_tmp_disk_tables_persecond in", values, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondNotIn(List<String> values) {
            addCriterion("created_tmp_disk_tables_persecond not in", values, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondBetween(String value1, String value2) {
            addCriterion("created_tmp_disk_tables_persecond between", value1, value2, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpDiskTablesPersecondNotBetween(String value1, String value2) {
            addCriterion("created_tmp_disk_tables_persecond not between", value1, value2, "createdTmpDiskTablesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesIsNull() {
            addCriterion("created_tmp_files is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesIsNotNull() {
            addCriterion("created_tmp_files is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesEqualTo(Long value) {
            addCriterion("created_tmp_files =", value, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesNotEqualTo(Long value) {
            addCriterion("created_tmp_files <>", value, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesGreaterThan(Long value) {
            addCriterion("created_tmp_files >", value, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesGreaterThanOrEqualTo(Long value) {
            addCriterion("created_tmp_files >=", value, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesLessThan(Long value) {
            addCriterion("created_tmp_files <", value, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesLessThanOrEqualTo(Long value) {
            addCriterion("created_tmp_files <=", value, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesIn(List<Long> values) {
            addCriterion("created_tmp_files in", values, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesNotIn(List<Long> values) {
            addCriterion("created_tmp_files not in", values, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesBetween(Long value1, Long value2) {
            addCriterion("created_tmp_files between", value1, value2, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesNotBetween(Long value1, Long value2) {
            addCriterion("created_tmp_files not between", value1, value2, "createdTmpFiles");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondIsNull() {
            addCriterion("created_tmp_files_persecond is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondIsNotNull() {
            addCriterion("created_tmp_files_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondEqualTo(String value) {
            addCriterion("created_tmp_files_persecond =", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondNotEqualTo(String value) {
            addCriterion("created_tmp_files_persecond <>", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondGreaterThan(String value) {
            addCriterion("created_tmp_files_persecond >", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("created_tmp_files_persecond >=", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondLessThan(String value) {
            addCriterion("created_tmp_files_persecond <", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondLessThanOrEqualTo(String value) {
            addCriterion("created_tmp_files_persecond <=", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondLike(String value) {
            addCriterion("created_tmp_files_persecond like", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondNotLike(String value) {
            addCriterion("created_tmp_files_persecond not like", value, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondIn(List<String> values) {
            addCriterion("created_tmp_files_persecond in", values, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondNotIn(List<String> values) {
            addCriterion("created_tmp_files_persecond not in", values, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondBetween(String value1, String value2) {
            addCriterion("created_tmp_files_persecond between", value1, value2, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andCreatedTmpFilesPersecondNotBetween(String value1, String value2) {
            addCriterion("created_tmp_files_persecond not between", value1, value2, "createdTmpFilesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsIsNull() {
            addCriterion("innodb_data_reads is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsIsNotNull() {
            addCriterion("innodb_data_reads is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsEqualTo(Long value) {
            addCriterion("innodb_data_reads =", value, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsNotEqualTo(Long value) {
            addCriterion("innodb_data_reads <>", value, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsGreaterThan(Long value) {
            addCriterion("innodb_data_reads >", value, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_data_reads >=", value, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsLessThan(Long value) {
            addCriterion("innodb_data_reads <", value, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsLessThanOrEqualTo(Long value) {
            addCriterion("innodb_data_reads <=", value, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsIn(List<Long> values) {
            addCriterion("innodb_data_reads in", values, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsNotIn(List<Long> values) {
            addCriterion("innodb_data_reads not in", values, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsBetween(Long value1, Long value2) {
            addCriterion("innodb_data_reads between", value1, value2, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsNotBetween(Long value1, Long value2) {
            addCriterion("innodb_data_reads not between", value1, value2, "innodbDataReads");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondIsNull() {
            addCriterion("innodb_data_reads_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondIsNotNull() {
            addCriterion("innodb_data_reads_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondEqualTo(String value) {
            addCriterion("innodb_data_reads_persecond =", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondNotEqualTo(String value) {
            addCriterion("innodb_data_reads_persecond <>", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondGreaterThan(String value) {
            addCriterion("innodb_data_reads_persecond >", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_data_reads_persecond >=", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondLessThan(String value) {
            addCriterion("innodb_data_reads_persecond <", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_data_reads_persecond <=", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondLike(String value) {
            addCriterion("innodb_data_reads_persecond like", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondNotLike(String value) {
            addCriterion("innodb_data_reads_persecond not like", value, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondIn(List<String> values) {
            addCriterion("innodb_data_reads_persecond in", values, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondNotIn(List<String> values) {
            addCriterion("innodb_data_reads_persecond not in", values, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondBetween(String value1, String value2) {
            addCriterion("innodb_data_reads_persecond between", value1, value2, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadsPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_data_reads_persecond not between", value1, value2, "innodbDataReadsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesIsNull() {
            addCriterion("innodb_data_writes is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesIsNotNull() {
            addCriterion("innodb_data_writes is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesEqualTo(Long value) {
            addCriterion("innodb_data_writes =", value, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesNotEqualTo(Long value) {
            addCriterion("innodb_data_writes <>", value, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesGreaterThan(Long value) {
            addCriterion("innodb_data_writes >", value, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_data_writes >=", value, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesLessThan(Long value) {
            addCriterion("innodb_data_writes <", value, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesLessThanOrEqualTo(Long value) {
            addCriterion("innodb_data_writes <=", value, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesIn(List<Long> values) {
            addCriterion("innodb_data_writes in", values, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesNotIn(List<Long> values) {
            addCriterion("innodb_data_writes not in", values, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesBetween(Long value1, Long value2) {
            addCriterion("innodb_data_writes between", value1, value2, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesNotBetween(Long value1, Long value2) {
            addCriterion("innodb_data_writes not between", value1, value2, "innodbDataWrites");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondIsNull() {
            addCriterion("innodb_data_writes_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondIsNotNull() {
            addCriterion("innodb_data_writes_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondEqualTo(String value) {
            addCriterion("innodb_data_writes_persecond =", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondNotEqualTo(String value) {
            addCriterion("innodb_data_writes_persecond <>", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondGreaterThan(String value) {
            addCriterion("innodb_data_writes_persecond >", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_data_writes_persecond >=", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondLessThan(String value) {
            addCriterion("innodb_data_writes_persecond <", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_data_writes_persecond <=", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondLike(String value) {
            addCriterion("innodb_data_writes_persecond like", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondNotLike(String value) {
            addCriterion("innodb_data_writes_persecond not like", value, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondIn(List<String> values) {
            addCriterion("innodb_data_writes_persecond in", values, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondNotIn(List<String> values) {
            addCriterion("innodb_data_writes_persecond not in", values, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondBetween(String value1, String value2) {
            addCriterion("innodb_data_writes_persecond between", value1, value2, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWritesPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_data_writes_persecond not between", value1, value2, "innodbDataWritesPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsIsNull() {
            addCriterion("innodb_data_fsyncs is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsIsNotNull() {
            addCriterion("innodb_data_fsyncs is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsEqualTo(Long value) {
            addCriterion("innodb_data_fsyncs =", value, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsNotEqualTo(Long value) {
            addCriterion("innodb_data_fsyncs <>", value, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsGreaterThan(Long value) {
            addCriterion("innodb_data_fsyncs >", value, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_data_fsyncs >=", value, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsLessThan(Long value) {
            addCriterion("innodb_data_fsyncs <", value, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsLessThanOrEqualTo(Long value) {
            addCriterion("innodb_data_fsyncs <=", value, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsIn(List<Long> values) {
            addCriterion("innodb_data_fsyncs in", values, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsNotIn(List<Long> values) {
            addCriterion("innodb_data_fsyncs not in", values, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsBetween(Long value1, Long value2) {
            addCriterion("innodb_data_fsyncs between", value1, value2, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsNotBetween(Long value1, Long value2) {
            addCriterion("innodb_data_fsyncs not between", value1, value2, "innodbDataFsyncs");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondIsNull() {
            addCriterion("innodb_data_fsyncs_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondIsNotNull() {
            addCriterion("innodb_data_fsyncs_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondEqualTo(String value) {
            addCriterion("innodb_data_fsyncs_persecond =", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondNotEqualTo(String value) {
            addCriterion("innodb_data_fsyncs_persecond <>", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondGreaterThan(String value) {
            addCriterion("innodb_data_fsyncs_persecond >", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_data_fsyncs_persecond >=", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondLessThan(String value) {
            addCriterion("innodb_data_fsyncs_persecond <", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_data_fsyncs_persecond <=", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondLike(String value) {
            addCriterion("innodb_data_fsyncs_persecond like", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondNotLike(String value) {
            addCriterion("innodb_data_fsyncs_persecond not like", value, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondIn(List<String> values) {
            addCriterion("innodb_data_fsyncs_persecond in", values, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondNotIn(List<String> values) {
            addCriterion("innodb_data_fsyncs_persecond not in", values, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondBetween(String value1, String value2) {
            addCriterion("innodb_data_fsyncs_persecond between", value1, value2, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataFsyncsPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_data_fsyncs_persecond not between", value1, value2, "innodbDataFsyncsPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadIsNull() {
            addCriterion("innodb_data_read is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadIsNotNull() {
            addCriterion("innodb_data_read is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadEqualTo(Long value) {
            addCriterion("innodb_data_read =", value, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadNotEqualTo(Long value) {
            addCriterion("innodb_data_read <>", value, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadGreaterThan(Long value) {
            addCriterion("innodb_data_read >", value, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_data_read >=", value, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadLessThan(Long value) {
            addCriterion("innodb_data_read <", value, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadLessThanOrEqualTo(Long value) {
            addCriterion("innodb_data_read <=", value, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadIn(List<Long> values) {
            addCriterion("innodb_data_read in", values, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadNotIn(List<Long> values) {
            addCriterion("innodb_data_read not in", values, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadBetween(Long value1, Long value2) {
            addCriterion("innodb_data_read between", value1, value2, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadNotBetween(Long value1, Long value2) {
            addCriterion("innodb_data_read not between", value1, value2, "innodbDataRead");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondIsNull() {
            addCriterion("innodb_data_read_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondIsNotNull() {
            addCriterion("innodb_data_read_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondEqualTo(String value) {
            addCriterion("innodb_data_read_persecond =", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondNotEqualTo(String value) {
            addCriterion("innodb_data_read_persecond <>", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondGreaterThan(String value) {
            addCriterion("innodb_data_read_persecond >", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_data_read_persecond >=", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondLessThan(String value) {
            addCriterion("innodb_data_read_persecond <", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_data_read_persecond <=", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondLike(String value) {
            addCriterion("innodb_data_read_persecond like", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondNotLike(String value) {
            addCriterion("innodb_data_read_persecond not like", value, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondIn(List<String> values) {
            addCriterion("innodb_data_read_persecond in", values, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondNotIn(List<String> values) {
            addCriterion("innodb_data_read_persecond not in", values, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondBetween(String value1, String value2) {
            addCriterion("innodb_data_read_persecond between", value1, value2, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataReadPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_data_read_persecond not between", value1, value2, "innodbDataReadPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenIsNull() {
            addCriterion("innodb_data_written is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenIsNotNull() {
            addCriterion("innodb_data_written is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenEqualTo(Long value) {
            addCriterion("innodb_data_written =", value, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenNotEqualTo(Long value) {
            addCriterion("innodb_data_written <>", value, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenGreaterThan(Long value) {
            addCriterion("innodb_data_written >", value, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_data_written >=", value, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenLessThan(Long value) {
            addCriterion("innodb_data_written <", value, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenLessThanOrEqualTo(Long value) {
            addCriterion("innodb_data_written <=", value, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenIn(List<Long> values) {
            addCriterion("innodb_data_written in", values, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenNotIn(List<Long> values) {
            addCriterion("innodb_data_written not in", values, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenBetween(Long value1, Long value2) {
            addCriterion("innodb_data_written between", value1, value2, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenNotBetween(Long value1, Long value2) {
            addCriterion("innodb_data_written not between", value1, value2, "innodbDataWritten");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondIsNull() {
            addCriterion("innodb_data_written_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondIsNotNull() {
            addCriterion("innodb_data_written_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondEqualTo(String value) {
            addCriterion("innodb_data_written_persecond =", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondNotEqualTo(String value) {
            addCriterion("innodb_data_written_persecond <>", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondGreaterThan(String value) {
            addCriterion("innodb_data_written_persecond >", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_data_written_persecond >=", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondLessThan(String value) {
            addCriterion("innodb_data_written_persecond <", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_data_written_persecond <=", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondLike(String value) {
            addCriterion("innodb_data_written_persecond like", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondNotLike(String value) {
            addCriterion("innodb_data_written_persecond not like", value, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondIn(List<String> values) {
            addCriterion("innodb_data_written_persecond in", values, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondNotIn(List<String> values) {
            addCriterion("innodb_data_written_persecond not in", values, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondBetween(String value1, String value2) {
            addCriterion("innodb_data_written_persecond between", value1, value2, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbDataWrittenPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_data_written_persecond not between", value1, value2, "innodbDataWrittenPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyIsNull() {
            addCriterion("innodb_buffer_pool_pages_dirty is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyIsNotNull() {
            addCriterion("innodb_buffer_pool_pages_dirty is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_dirty =", value, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyNotEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_dirty <>", value, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyGreaterThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_dirty >", value, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_dirty >=", value, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyLessThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_dirty <", value, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyLessThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_dirty <=", value, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_dirty in", values, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyNotIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_dirty not in", values, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_dirty between", value1, value2, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyNotBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_dirty not between", value1, value2, "innodbBufferPoolPagesDirty");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondIsNull() {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondIsNotNull() {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond =", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondNotEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond <>", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondGreaterThan(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond >", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond >=", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondLessThan(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond <", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond <=", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondLike(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond like", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondNotLike(String value) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond not like", value, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondIn(List<String> values) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond in", values, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondNotIn(List<String> values) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond not in", values, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondBetween(String value1, String value2) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond between", value1, value2, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesDirtyPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_buffer_pool_pages_dirty_persecond not between", value1, value2, "innodbBufferPoolPagesDirtyPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedIsNull() {
            addCriterion("innodb_buffer_pool_pages_flushed is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedIsNotNull() {
            addCriterion("innodb_buffer_pool_pages_flushed is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_flushed =", value, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedNotEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_flushed <>", value, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedGreaterThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_flushed >", value, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_flushed >=", value, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedLessThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_flushed <", value, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedLessThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_flushed <=", value, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_flushed in", values, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedNotIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_flushed not in", values, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_flushed between", value1, value2, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedNotBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_flushed not between", value1, value2, "innodbBufferPoolPagesFlushed");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondIsNull() {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondIsNotNull() {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond =", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondNotEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond <>", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondGreaterThan(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond >", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond >=", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondLessThan(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond <", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond <=", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondLike(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond like", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondNotLike(String value) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond not like", value, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondIn(List<String> values) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond in", values, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondNotIn(List<String> values) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond not in", values, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondBetween(String value1, String value2) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond between", value1, value2, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFlushedPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_buffer_pool_pages_flushed_persecond not between", value1, value2, "innodbBufferPoolPagesFlushedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioIsNull() {
            addCriterion("innodb_buffer_read_hit_ratio is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioIsNotNull() {
            addCriterion("innodb_buffer_read_hit_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioEqualTo(String value) {
            addCriterion("innodb_buffer_read_hit_ratio =", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioNotEqualTo(String value) {
            addCriterion("innodb_buffer_read_hit_ratio <>", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioGreaterThan(String value) {
            addCriterion("innodb_buffer_read_hit_ratio >", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_read_hit_ratio >=", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioLessThan(String value) {
            addCriterion("innodb_buffer_read_hit_ratio <", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioLessThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_read_hit_ratio <=", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioLike(String value) {
            addCriterion("innodb_buffer_read_hit_ratio like", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioNotLike(String value) {
            addCriterion("innodb_buffer_read_hit_ratio not like", value, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioIn(List<String> values) {
            addCriterion("innodb_buffer_read_hit_ratio in", values, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioNotIn(List<String> values) {
            addCriterion("innodb_buffer_read_hit_ratio not in", values, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioBetween(String value1, String value2) {
            addCriterion("innodb_buffer_read_hit_ratio between", value1, value2, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferReadHitRatioNotBetween(String value1, String value2) {
            addCriterion("innodb_buffer_read_hit_ratio not between", value1, value2, "innodbBufferReadHitRatio");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageIsNull() {
            addCriterion("innodb_buffer_usage is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageIsNotNull() {
            addCriterion("innodb_buffer_usage is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageEqualTo(String value) {
            addCriterion("innodb_buffer_usage =", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageNotEqualTo(String value) {
            addCriterion("innodb_buffer_usage <>", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageGreaterThan(String value) {
            addCriterion("innodb_buffer_usage >", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_usage >=", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageLessThan(String value) {
            addCriterion("innodb_buffer_usage <", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageLessThanOrEqualTo(String value) {
            addCriterion("innodb_buffer_usage <=", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageLike(String value) {
            addCriterion("innodb_buffer_usage like", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageNotLike(String value) {
            addCriterion("innodb_buffer_usage not like", value, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageIn(List<String> values) {
            addCriterion("innodb_buffer_usage in", values, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageNotIn(List<String> values) {
            addCriterion("innodb_buffer_usage not in", values, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageBetween(String value1, String value2) {
            addCriterion("innodb_buffer_usage between", value1, value2, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferUsageNotBetween(String value1, String value2) {
            addCriterion("innodb_buffer_usage not between", value1, value2, "innodbBufferUsage");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedIsNull() {
            addCriterion("innodb_rows_inserted is null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedIsNotNull() {
            addCriterion("innodb_rows_inserted is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedEqualTo(Long value) {
            addCriterion("innodb_rows_inserted =", value, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedNotEqualTo(Long value) {
            addCriterion("innodb_rows_inserted <>", value, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedGreaterThan(Long value) {
            addCriterion("innodb_rows_inserted >", value, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_rows_inserted >=", value, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedLessThan(Long value) {
            addCriterion("innodb_rows_inserted <", value, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedLessThanOrEqualTo(Long value) {
            addCriterion("innodb_rows_inserted <=", value, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedIn(List<Long> values) {
            addCriterion("innodb_rows_inserted in", values, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedNotIn(List<Long> values) {
            addCriterion("innodb_rows_inserted not in", values, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedBetween(Long value1, Long value2) {
            addCriterion("innodb_rows_inserted between", value1, value2, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedNotBetween(Long value1, Long value2) {
            addCriterion("innodb_rows_inserted not between", value1, value2, "innodbRowsInserted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondIsNull() {
            addCriterion("innodb_rows_inserted_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondIsNotNull() {
            addCriterion("innodb_rows_inserted_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondEqualTo(String value) {
            addCriterion("innodb_rows_inserted_persecond =", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondNotEqualTo(String value) {
            addCriterion("innodb_rows_inserted_persecond <>", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondGreaterThan(String value) {
            addCriterion("innodb_rows_inserted_persecond >", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_rows_inserted_persecond >=", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondLessThan(String value) {
            addCriterion("innodb_rows_inserted_persecond <", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_rows_inserted_persecond <=", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondLike(String value) {
            addCriterion("innodb_rows_inserted_persecond like", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondNotLike(String value) {
            addCriterion("innodb_rows_inserted_persecond not like", value, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondIn(List<String> values) {
            addCriterion("innodb_rows_inserted_persecond in", values, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondNotIn(List<String> values) {
            addCriterion("innodb_rows_inserted_persecond not in", values, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondBetween(String value1, String value2) {
            addCriterion("innodb_rows_inserted_persecond between", value1, value2, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsInsertedPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_rows_inserted_persecond not between", value1, value2, "innodbRowsInsertedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedIsNull() {
            addCriterion("innodb_rows_updated is null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedIsNotNull() {
            addCriterion("innodb_rows_updated is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedEqualTo(Long value) {
            addCriterion("innodb_rows_updated =", value, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedNotEqualTo(Long value) {
            addCriterion("innodb_rows_updated <>", value, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedGreaterThan(Long value) {
            addCriterion("innodb_rows_updated >", value, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_rows_updated >=", value, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedLessThan(Long value) {
            addCriterion("innodb_rows_updated <", value, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedLessThanOrEqualTo(Long value) {
            addCriterion("innodb_rows_updated <=", value, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedIn(List<Long> values) {
            addCriterion("innodb_rows_updated in", values, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedNotIn(List<Long> values) {
            addCriterion("innodb_rows_updated not in", values, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedBetween(Long value1, Long value2) {
            addCriterion("innodb_rows_updated between", value1, value2, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedNotBetween(Long value1, Long value2) {
            addCriterion("innodb_rows_updated not between", value1, value2, "innodbRowsUpdated");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondIsNull() {
            addCriterion("innodb_rows_updated_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondIsNotNull() {
            addCriterion("innodb_rows_updated_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondEqualTo(String value) {
            addCriterion("innodb_rows_updated_persecond =", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondNotEqualTo(String value) {
            addCriterion("innodb_rows_updated_persecond <>", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondGreaterThan(String value) {
            addCriterion("innodb_rows_updated_persecond >", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_rows_updated_persecond >=", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondLessThan(String value) {
            addCriterion("innodb_rows_updated_persecond <", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_rows_updated_persecond <=", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondLike(String value) {
            addCriterion("innodb_rows_updated_persecond like", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondNotLike(String value) {
            addCriterion("innodb_rows_updated_persecond not like", value, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondIn(List<String> values) {
            addCriterion("innodb_rows_updated_persecond in", values, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondNotIn(List<String> values) {
            addCriterion("innodb_rows_updated_persecond not in", values, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondBetween(String value1, String value2) {
            addCriterion("innodb_rows_updated_persecond between", value1, value2, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsUpdatedPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_rows_updated_persecond not between", value1, value2, "innodbRowsUpdatedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedIsNull() {
            addCriterion("innodb_rows_deleted is null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedIsNotNull() {
            addCriterion("innodb_rows_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedEqualTo(Long value) {
            addCriterion("innodb_rows_deleted =", value, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedNotEqualTo(Long value) {
            addCriterion("innodb_rows_deleted <>", value, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedGreaterThan(Long value) {
            addCriterion("innodb_rows_deleted >", value, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_rows_deleted >=", value, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedLessThan(Long value) {
            addCriterion("innodb_rows_deleted <", value, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedLessThanOrEqualTo(Long value) {
            addCriterion("innodb_rows_deleted <=", value, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedIn(List<Long> values) {
            addCriterion("innodb_rows_deleted in", values, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedNotIn(List<Long> values) {
            addCriterion("innodb_rows_deleted not in", values, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedBetween(Long value1, Long value2) {
            addCriterion("innodb_rows_deleted between", value1, value2, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedNotBetween(Long value1, Long value2) {
            addCriterion("innodb_rows_deleted not between", value1, value2, "innodbRowsDeleted");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondIsNull() {
            addCriterion("innodb_rows_deleted_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondIsNotNull() {
            addCriterion("innodb_rows_deleted_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondEqualTo(String value) {
            addCriterion("innodb_rows_deleted_persecond =", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondNotEqualTo(String value) {
            addCriterion("innodb_rows_deleted_persecond <>", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondGreaterThan(String value) {
            addCriterion("innodb_rows_deleted_persecond >", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("innodb_rows_deleted_persecond >=", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondLessThan(String value) {
            addCriterion("innodb_rows_deleted_persecond <", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondLessThanOrEqualTo(String value) {
            addCriterion("innodb_rows_deleted_persecond <=", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondLike(String value) {
            addCriterion("innodb_rows_deleted_persecond like", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondNotLike(String value) {
            addCriterion("innodb_rows_deleted_persecond not like", value, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondIn(List<String> values) {
            addCriterion("innodb_rows_deleted_persecond in", values, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondNotIn(List<String> values) {
            addCriterion("innodb_rows_deleted_persecond not in", values, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondBetween(String value1, String value2) {
            addCriterion("innodb_rows_deleted_persecond between", value1, value2, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbRowsDeletedPersecondNotBetween(String value1, String value2) {
            addCriterion("innodb_rows_deleted_persecond not between", value1, value2, "innodbRowsDeletedPersecond");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalIsNull() {
            addCriterion("innodb_buffer_pool_pages_total is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalIsNotNull() {
            addCriterion("innodb_buffer_pool_pages_total is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_total =", value, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalNotEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_total <>", value, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalGreaterThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_total >", value, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_total >=", value, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalLessThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_total <", value, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalLessThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_total <=", value, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_total in", values, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalNotIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_total not in", values, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_total between", value1, value2, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesTotalNotBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_total not between", value1, value2, "innodbBufferPoolPagesTotal");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeIsNull() {
            addCriterion("innodb_buffer_pool_pages_free is null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeIsNotNull() {
            addCriterion("innodb_buffer_pool_pages_free is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_free =", value, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeNotEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_free <>", value, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeGreaterThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_free >", value, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeGreaterThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_free >=", value, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeLessThan(Long value) {
            addCriterion("innodb_buffer_pool_pages_free <", value, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeLessThanOrEqualTo(Long value) {
            addCriterion("innodb_buffer_pool_pages_free <=", value, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_free in", values, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeNotIn(List<Long> values) {
            addCriterion("innodb_buffer_pool_pages_free not in", values, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_free between", value1, value2, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbBufferPoolPagesFreeNotBetween(Long value1, Long value2) {
            addCriterion("innodb_buffer_pool_pages_free not between", value1, value2, "innodbBufferPoolPagesFree");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeIsNull() {
            addCriterion("innodb_page_size is null");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeIsNotNull() {
            addCriterion("innodb_page_size is not null");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeEqualTo(Integer value) {
            addCriterion("innodb_page_size =", value, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeNotEqualTo(Integer value) {
            addCriterion("innodb_page_size <>", value, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeGreaterThan(Integer value) {
            addCriterion("innodb_page_size >", value, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("innodb_page_size >=", value, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeLessThan(Integer value) {
            addCriterion("innodb_page_size <", value, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeLessThanOrEqualTo(Integer value) {
            addCriterion("innodb_page_size <=", value, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeIn(List<Integer> values) {
            addCriterion("innodb_page_size in", values, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeNotIn(List<Integer> values) {
            addCriterion("innodb_page_size not in", values, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeBetween(Integer value1, Integer value2) {
            addCriterion("innodb_page_size between", value1, value2, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andInnodbPageSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("innodb_page_size not between", value1, value2, "innodbPageSize");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesIsNull() {
            addCriterion("slow_queries is null");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesIsNotNull() {
            addCriterion("slow_queries is not null");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesEqualTo(Integer value) {
            addCriterion("slow_queries =", value, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesNotEqualTo(Integer value) {
            addCriterion("slow_queries <>", value, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesGreaterThan(Integer value) {
            addCriterion("slow_queries >", value, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesGreaterThanOrEqualTo(Integer value) {
            addCriterion("slow_queries >=", value, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesLessThan(Integer value) {
            addCriterion("slow_queries <", value, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesLessThanOrEqualTo(Integer value) {
            addCriterion("slow_queries <=", value, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesIn(List<Integer> values) {
            addCriterion("slow_queries in", values, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesNotIn(List<Integer> values) {
            addCriterion("slow_queries not in", values, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesBetween(Integer value1, Integer value2) {
            addCriterion("slow_queries between", value1, value2, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlowQueriesNotBetween(Integer value1, Integer value2) {
            addCriterion("slow_queries not between", value1, value2, "slowQueries");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayIsNull() {
            addCriterion("slave_delay is null");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayIsNotNull() {
            addCriterion("slave_delay is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayEqualTo(Long value) {
            addCriterion("slave_delay =", value, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayNotEqualTo(Long value) {
            addCriterion("slave_delay <>", value, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayGreaterThan(Long value) {
            addCriterion("slave_delay >", value, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayGreaterThanOrEqualTo(Long value) {
            addCriterion("slave_delay >=", value, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayLessThan(Long value) {
            addCriterion("slave_delay <", value, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayLessThanOrEqualTo(Long value) {
            addCriterion("slave_delay <=", value, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayIn(List<Long> values) {
            addCriterion("slave_delay in", values, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayNotIn(List<Long> values) {
            addCriterion("slave_delay not in", values, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayBetween(Long value1, Long value2) {
            addCriterion("slave_delay between", value1, value2, "slaveDelay");
            return (Criteria) this;
        }

        public Criteria andSlaveDelayNotBetween(Long value1, Long value2) {
            addCriterion("slave_delay not between", value1, value2, "slaveDelay");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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