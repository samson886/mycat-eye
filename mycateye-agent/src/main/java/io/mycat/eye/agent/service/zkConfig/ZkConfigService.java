package io.mycat.eye.agent.service.zkConfig;

import com.alibaba.fastjson.JSON;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ZkConfigService {
    String path;
    String serviceName;
    CuratorFramework client;
    final static String templeate = "/mycat/%s/%s";
    protected Logger logger;

   public byte[] getData(String cluster) throws Exception {
        return client.getData().forPath(String.format(templeate, cluster, path));
    }

    public void saveData(String cluster, String data) throws Exception {
        client.setData().forPath(String.format(templeate, cluster, path),data.getBytes());
    }

    public List<String> getChildren(String cluster) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format);
    }
    public List<String> getChildrenWithPath(String cluster) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format)
                .stream()
                .map(i -> format + "/" + i)
                .collect(Collectors.toList());
    }
    public Optional<String> getChildrenWithPath(String cluster, Predicate<String> predicate) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format)
                .stream()
                .filter(predicate)
                .map(i -> format + "/" + i)
                .findFirst();
    }
    public void setChildren(String key, String text) throws Exception {
        String format = String.format(templeate, client, path);
        client.setData().forPath(format + "\\" + key, text.getBytes());
    }

    public Optional<String> getChildren(String cluster,Predicate<String> predicate) throws Exception {
        String format = String.format(templeate, cluster, path);
        return client.getChildren()
                .forPath(format)
                .stream()
                .filter(predicate)
                .map(i -> format + "/" + i)
                .findFirst();
    }

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


    public void updateServerConfigAsJson(String cluster, JSON json) throws Exception {
        this.saveData(cluster, json.toJSONString());
    }
    public void updateServerConfigAsString(String cluster, String str) throws Exception {
        this.saveData(cluster, str);
    }
    public String getServerConfigAsString(String cluster) throws Exception {
        return new String(getData(cluster));
    }

    public CuratorFramework getClient() {
        return client;
    }
}
