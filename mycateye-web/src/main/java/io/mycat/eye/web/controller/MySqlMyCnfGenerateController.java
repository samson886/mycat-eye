package io.mycat.eye.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mycat.eye.web.dto.MyCnfGenerateSettingsDto;
import io.mycat.eye.web.service.MySqlMyCnfGenerateService;

@Controller
public class MySqlMyCnfGenerateController
{
    private final static Logger LOGGER=LoggerFactory.getLogger(MySqlMyCnfGenerateController.class);
    @Autowired
    private MySqlMyCnfGenerateService generateService;
    /**
     * 生成my.cnf配置文件
     * @Title: generate   
     * @param request
     * @param response        
     * @throws
     */
    @RequestMapping("/mysql/mycnf/generate")
    public void generate(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            MyCnfGenerateSettingsDto generateSettingsDto = new MyCnfGenerateSettingsDto();
            generateSettingsDto.setServerHostName(request.getParameter("serverHostName"));
            generateSettingsDto.setServerId(request.getParameter("serverId"));
            generateSettingsDto.setPhysicalMemory(Integer.valueOf(request.getParameter("physicalMemory")));
            generateSettingsDto.setInstallPath(request.getParameter("installPath"));
            generateSettingsDto.setDataFilePath(request.getParameter("dataFilePath"));
            generateSettingsDto.setListenPort(Integer.valueOf(request.getParameter("listenPort")));
            generateSettingsDto.setExpectedMaxConnect(Integer.valueOf(request.getParameter("expectedMaxConnect")));
            generateSettingsDto.setBinlogExpireDays(Integer.valueOf(request.getParameter("binlogExpireDays")));
            String sortAndJoinQuery = request.getParameter("sortAndJoinQuery");
            if ("true".equals(sortAndJoinQuery))
            {
                generateSettingsDto.setSortAndJoinQuery(Boolean.TRUE);
            }
            String recoverData = request.getParameter("recoverData");
            if ("true".equals(recoverData))
            {
                generateSettingsDto.setRecoverData(Boolean.TRUE);
            }
            
            String content = generateService.generate(generateSettingsDto);
            response.setContentType("text/html;charset=UTF-8");
            response.setStatus(HttpStatus.SC_OK);
            response.setHeader("Content-disposition", "attachment; filename=my.cnf");
            PrintWriter writer = response.getWriter();
            writer.print(content);
            writer.close();
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }
    }
}
