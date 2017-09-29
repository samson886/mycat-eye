/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  ChatDataDto.java   
 * @Package cn.bqjr.mysqleye.dto   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年3月20日 上午10:16:47   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.web.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ChatDataDto
 * @Description:图表对象
 * @author: 李平(360841519@qq.com)
 * @date: 2017年3月20日 上午10:16:47
 * 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
public class ChatDataDto {
	private Status status;
	private String[] xAxisData;
	private String[] seriesData;
	private Map<String, String[]> seriesDatas = new HashMap<>();

	private Long maxId;


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String[] getxAxisData() {
		return xAxisData;
	}

	public void setxAxisData(String[] xAxisData) {
		this.xAxisData = xAxisData;
	}

	public String[] getSeriesData() {
		return seriesData;
	}

	public void setSeriesData(String[] seriesData) {
		this.seriesData = seriesData;
	}

	public Map<String, String[]> getSeriesDatas() {
		return seriesDatas;
	}

	public void setSeriesDatas(Map<String, String[]> seriesDatas) {
		this.seriesDatas = seriesDatas;
	}


	public Long getMaxId() {
		return maxId;
	}

	public void setMaxId(Long maxId) {
		this.maxId = maxId;
	}
}
