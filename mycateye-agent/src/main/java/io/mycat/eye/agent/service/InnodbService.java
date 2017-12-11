package io.mycat.eye.agent.service;

import java.util.List;

import io.mycat.eye.agent.bean.InnodbLockWaits;
import io.mycat.eye.agent.bean.InnodbTrx;
import io.mycat.eye.agent.dto.PagedDto;

public interface InnodbService {
	/**
	 * 获取innodb状态
	 * @param serverId
	 * @return
	 */
	String getStatus(Long serverId);
	
	/**
	 * 获取innodb事务信息
	 * @param serverId
	 * @return
	 */
	PagedDto<InnodbTrx> getInnodbTrxs(Long serverId);
	
	/**
	 * 获取innodb锁等待信息
	 * @param serverId
	 * @return
	 */
	PagedDto<InnodbLockWaits> getInnodbLockWaits(Long serverId);
	
	
}
