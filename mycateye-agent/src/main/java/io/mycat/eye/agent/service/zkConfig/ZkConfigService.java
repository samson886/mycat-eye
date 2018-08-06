package io.mycat.eye.agent.service.zkConfig;

import com.alibaba.fastjson.JSON;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * cjw qq:294712221
 */
public class ZkConfigService {
    String path;
    String serviceName;
    CuratorFramework client;
    final static String templeate = "/mycat/%s/%s";
    protected Logger logger;

    public void setData(String path,String str)throws Exception{
        client.transactionOp().setData().forPath(path,str.getBytes());
    }

    /**
     * 根据绝对路径获取字符串数据
     * @param path
     * @return
     * @throws Exception
     */
    public String getData(String path)throws Exception{
       return new String(client.getData().forPath(path));
    }

    /**
     * 根据模板拼接集群路径获取字符串数据
     * @param cluster
     * @return
     * @throws Exception
     */
    public String getDataInCluster(String cluster) throws Exception {
        return new String(client.getData().forPath(String.format(templeate, cluster, path)));
    }

    /**
     * 根据模板拼接集群路径设置字符串数据
     * @param cluster
     * @param data
     * @throws Exception
     */
    public void saveDataInCluster(String cluster, String data) throws Exception {
//        CuratorOp t = client.transactionOp().setData().forPath(String.format(templeate, cluster, path), data.getBytes());
        client.setData().forPath(String.format(templeate, cluster, path), data.getBytes());

    }

    /**
     * 根据模板拼接集群路径设置子节点
     * @param cluster
     * @return
     * @throws Exception
     */
    public List<String> getChildrenInCluster(String cluster) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format);
    }

    /**
     * 根据模板拼接集群路径获取带有子节点的路径
     * @param cluster
     * @return
     * @throws Exception
     */
    public List<String> getChildrenInClusterWithPath(String cluster) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format)
                .stream()
                .map(i -> format + "/" + i)
                .collect(Collectors.toList());
    }

    /**
     * 根据模板拼接集群路径获取唯一的带有子节点的路径,使用predicate过滤
     * @param cluster
     * @param predicate
     * @return
     * @throws Exception
     */
    public Optional<String> getChildrenInClusterWithPath(String cluster, Predicate<String> predicate) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format)
                .stream()
                .filter(predicate)
                .map(i -> format + "/" + i)
                .findFirst();
    }

    /**
     * 根据模板拼接集群路径设置子节点
     * @param key
     * @param text
     * @throws Exception
     */
    public void setChildrenInCluster(String key, String text) throws Exception {
        String format = String.format(templeate, client, path);
        client.transactionOp().setData().forPath(format + "/" + key, text.getBytes());
    }

    /**
     * 根据模板拼接集群路径获取唯一的带有不带有路径的子节点,使用predicate过滤
     * @param cluster
     * @param predicate
     * @return
     * @throws Exception
     */
    public Optional<String> getChildrenInCluster(String cluster, Predicate<String> predicate) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format)
                .stream()
                .filter(predicate)
                .findFirst();
    }

    /**
     * 获取该服务的路径
     * @return
     */
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public ZkConfigService(String k, String path, CuratorFramework client) {
        this.path = path;
        this.serviceName = k;
        this.client = client;
        this.logger = LoggerFactory.getLogger(serviceName);
    }

    /**
     * 根据模板拼接集群路径设置json
     * @param cluster
     * @param json
     * @throws Exception
     */
    public void updateAsJson(String cluster, JSON json) throws Exception {
        this.saveDataInCluster(cluster, json.toJSONString());
    }
    /**
     * 根据模板拼接集群路径设置字符串
     * @param cluster
     * @param str
     * @throws Exception
     */
    public void updateAsString(String cluster, String str) throws Exception {
        this.saveDataInCluster(cluster, str);
    }

    /**
     * 根据模板拼接集群路径获取字符串
     * @param cluster
     * @return
     * @throws Exception
     */
    public String getAsString(String cluster) throws Exception {
        return getDataInCluster(cluster);
    }

    public CuratorFramework getClient() {
        return client;
    }
}
