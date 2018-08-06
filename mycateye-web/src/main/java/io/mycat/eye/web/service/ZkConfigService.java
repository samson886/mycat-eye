package io.mycat.eye.web.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZkConfigService {
    //db
    private static Map<String , Map<String, String>> db = new ConcurrentHashMap<>();
    /*
    *
    * @param cluster 集群名称
    * @return 某个集群的配置
    * */
    public static Map<String, String> getCluster(String cluster) {
        Map<String, String> config = null;
        if(!db.containsKey(cluster)){
            db.putIfAbsent(cluster, new ConcurrentHashMap<>());
        }
        return db.get(cluster);
    }

    public static String getData(String cluster, String path) {
        Map<String, String> config = getCluster(cluster);
        return config.get(path);
    }

    public static void putData(String cluster, String path, String body) {
        Map<String, String> config = getCluster(cluster);
        config.put(path, body);
    }


}
