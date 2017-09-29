package io.mycat.eye.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import org.springframework.cache.annotation.EnableCaching;

import org.springframework.context.annotation.ImportResource;

import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@ImportResource(locations = {"classpath:druid-bean.xml"})
@EnableCaching
public class MycatEyeApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MycatEyeApplication.class, args);
    }
}
