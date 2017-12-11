package io.mycat.eye.agent.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.agent.bean.InnodbLockWaits;
import io.mycat.eye.agent.bean.InnodbTrx;
import io.mycat.eye.agent.dto.PagedDto;
import io.mycat.eye.agent.service.InnodbService;


@RestController
@RequestMapping("/innodb")
public class InnodbController {
	@Autowired
	private InnodbService innodbService;
	
	@RequestMapping("/status/{serverId}")
    @CrossOrigin(origins = "*")
    public String getStatus(@PathVariable Long serverId) {
        return innodbService.getStatus(serverId);
    }
	
	@RequestMapping("/trx/{serverId}")
    @CrossOrigin(origins = "*")
    public PagedDto<InnodbTrx> getTrxs(@PathVariable Long serverId) {
        return innodbService.getInnodbTrxs(serverId);
    }
	
	@RequestMapping("/lockwaits/{serverId}")
    @CrossOrigin(origins = "*")
    public PagedDto<InnodbLockWaits> getLockWaits(@PathVariable Long serverId) {
        return innodbService.getInnodbLockWaits(serverId);
    }
}
