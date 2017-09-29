package io.mycat.eye.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class DbeyeAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbeyeAgentApplication.class, args);
	}
}
