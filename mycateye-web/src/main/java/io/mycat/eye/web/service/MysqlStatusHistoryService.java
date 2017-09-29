package io.mycat.eye.web.service;

public interface MysqlStatusHistoryService {

	String performanceMonitor(Long server_id, String beginTime, String endTime);
	
	String performanceMonitor(Long server_id, String timeRange);
}
