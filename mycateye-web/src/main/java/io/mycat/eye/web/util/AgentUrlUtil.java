package io.mycat.eye.web.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AgentUrlUtil {
    @Value("${agent.url}")
    private String agentUrl;

    public String getMySqlExplain() {
        return agentUrl + "/get/explain?serverId={serverId}&schema={schema}&sql={sql}";
    }

    public String getMysqlServerVerify() {
        return agentUrl + "/mysql/verify/{host}/{port}/{username}/{password}";
    }

    public String getOsServerVerify() {
        return agentUrl + "/ssh/verify/{host}/{port}/{username}/{password}";
    }

    public String getStatement() {
        return agentUrl + "/statement/history/{serverId}/{orderBy}";
    }

    public String getAgentZkUrl() {
        return agentUrl + "/zk";
    }

    public String getZkClusterAll() {
        return getAgentZkUrl() + "/{cluster}/server/cluster/all";
    }

    public String getZkCluster() {
        return getAgentZkUrl() + "/{cluster}/server/cluster/{clusterName}";
    }

    public String updateZkCluster() {
        return getAgentZkUrl() + "/{cluster}/server/cluster/{clusterName}";
    }

    public String getDefault() {
        return getAgentZkUrl() + "/{cluster}/server/default";
    }

    public String updateDefault() {
        return getAgentZkUrl() + "/{cluster}/server/default";
    }

    public String getUser() {
        return getAgentZkUrl() + "/{cluster}/server/user";
    }

    public String updateUser() {
        return getAgentZkUrl() + "/{cluster}/server/user";
    }

    public String getCharset() {
        return getAgentZkUrl() + "/{cluster}/server/charset";
    }
    public String getSchema() {
        return getAgentZkUrl() + "/{cluster}/schema/schema";
    }
    public String getDataHost() {
        return getAgentZkUrl() + "/{cluster}/schema/dataHost";
    }
    public String getDataNode() {
        return getAgentZkUrl() + "/{cluster}/schema/dataNode";
    }
    public String updateCharset() {
        return getAgentZkUrl() + "/{cluster}/server/charset";
    }

    public String getCreateTable() {
        return agentUrl + "/statement/show-create-table/{serverId}/{schema}/{table}";
    }

    public String getTableIndex() {
        return agentUrl + "/statement/show-index-from-table/{serverId}/{schema}/{table}";
    }

    public String getTableStatus() {
        return agentUrl + "/statement/show-table-status/{serverId}/{schema}/{table}";
    }

    public String getSqlAdvisor() {
        return agentUrl + "/statement/sql-advisor?serverId={serverId}&schema={schema}&sql={sql}";
    }

    public String getSlowStatement() {
        return agentUrl + "/statement/slow/{serverId}/{orderBy}/{pageIndex}/{pageSize}";
    }

    public String getDatabases() {
        return agentUrl + "/mysql/{serverId}/databases";
    }

    public String getTables() {
        return agentUrl + "/mysql/{serverId}/{schema}/tables";
    }

    public String getPriv() {
        return agentUrl + "/mysql/{serverId}/{schema}/priv";
    }

    public String userAdd() {
        return agentUrl + "/mysql/add/user/{serverId}/{schema}/{user}/{host}/{password}/{createRepUser}";
    }

    public String executeSql() {
        return agentUrl + "/statement/execute?serverId={serverId}&schema={schema}&sql={sql}";
    }

    public String getStatus() {
        return agentUrl + "/mysql/get/status/{serverId}";
    }

    public String getNewSqlAdvisor() {
        return agentUrl + "/sql-adviser/advice?serverId={serverId}&schema={schema}&sql={sql}";
    }

    public String getIndexCardinality() {
        return agentUrl + "/index/{serverId}/{pageIndex}/{pageSize}/index-cardinality";
    }

    public String getRedundantIndexes() {
        return agentUrl + "/index/{serverId}/{pageIndex}/{pageSize}/redundant-indexes";
    }

    public String getUnusedIndexes() {
        return agentUrl + "/index/{serverId}/{pageIndex}/{pageSize}/unused-indexes";
    }

    public String getAllNodesByAgent() {
        return agentUrl + "/replication/status";
    }

    public String getReplicationAdd() {
        return agentUrl + "/replication/addMasterSlave/{masterServerId}/{masterUser}/{masterPassword}/{slaveServerId}";
    }

    public String getReplicationAddDouble() {
        return agentUrl
                + "/replication/addDoubleMaster/{master1ServerId}/{master1User}/{master1Password}/{master2ServerId}/{master2User}/{master2Password}";
    }

    public String getRelieveReplication() {
        return agentUrl + "/replication/remove/slave/{serverId}";
    }

}
