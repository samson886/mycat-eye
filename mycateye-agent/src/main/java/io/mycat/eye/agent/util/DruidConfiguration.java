package io.mycat.eye.agent.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <druid 配置类>
 * 
 * @author 李平(360841519@qq.com)
 * @version V1.0
 */
@Configuration
public class DruidConfiguration
{
    
    @ConditionalOnClass(DruidDataSource.class)
    @ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true)
    static class Druid extends DruidConfiguration
    {
        @Bean
        @ConfigurationProperties("spring.datasource.druid")
        public DruidDataSource dataSource(DataSourceProperties properties)
        {
            DruidDataSource druidDataSource =
                (DruidDataSource)properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
            // DruidDataSource
            // druidDataSource=(DruidDataSource)DataSourceBuilder.create().url(properties.getUrl()).username(properties.getUsername()).password(properties.getPassword()).build();
            DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
            String validationQuery = databaseDriver.getValidationQuery();
            if (validationQuery != null)
            {
                druidDataSource.setValidationQuery(validationQuery);
            }
            return druidDataSource;
        }
        
    }
}
