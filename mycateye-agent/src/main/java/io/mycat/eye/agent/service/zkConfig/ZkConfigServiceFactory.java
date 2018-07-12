package io.mycat.eye.agent.service.zkConfig;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZkConfigServiceFactory {
    CuratorFramework client;

    @Autowired
    public ZkConfigServiceFactory() {
        String connectString = "localhost:2181";
        int sessionTimeoutMs = 5000;
        //ExponentialBackoffRetry:重试指定的次数, 且每一次重试之间停顿的时间逐渐增加.
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(sessionTimeoutMs)
                .retryPolicy(retryPolicy)
                .build();
        client.start();
    }

   public ZkConfigService create(String k, String path) {
        ZkConfigService service = new ZkConfigService(k, path, client);
        return service;
    }

    public CuratorFramework getClient() {
        return client;
    }

    public void setClient(CuratorFramework client) {
        this.client = client;
    }

}
