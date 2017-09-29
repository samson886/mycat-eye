package io.mycat.eye.web.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import io.mycat.eye.web.bean.MysqlStatusHistory;
import io.mycat.eye.web.bean.MysqlStatusHistoryExample;
import io.mycat.eye.web.dto.ChatDataDto;
import io.mycat.eye.web.dto.Status;
import io.mycat.eye.web.mapper.MysqlStatusHistoryMapper;
import io.mycat.eye.web.service.MysqlStatusHistoryService;
import io.mycat.eye.web.util.MiscUtil;
import io.mycat.eye.web.util.SysSampleUtil;

@CacheConfig(cacheNames = "mysqlStatusHistoryCache")
@Service
public class MysqlStatusHistoryServiceImpl implements MysqlStatusHistoryService
{
    public final static int SAMPLE_COUNT = 100;
    
    //qps
    public final static String QPS = "qps";
    
    //文件同步
    public final static String FSYNC = "fsync";
    
    //innodb 读
    public final static String READ = "read";
    
    //innodb 写
    public final static String WRITE = "write";
    
    //innodb 脏page 生成 
    public final static String DIRTY = "dirty";
    
    //innodb 脏page 刷新
    public final static String FLUSHED = "flushed";
    
    //innodb 插入
    public final static String INSERTED = "inserted";
    
    //innodb 更新
    public final static String UPDATED = "updated";
    
    //innodb 删除
    public final static String DELETED = "deleted";
    
    public final static String THREADS_RUNNING = "threads_running";
    
    public final static String THREADS_CONNECTED = "threads_connected";
    
    public final static String BYTE_SEND = "byte_send";
    
    public final static String BYTE_RECEIVED = "byte_received";
    
    public final static String COM_SELECT = "com_select";
    
    public final static String COM_INSERT = "com_insert";
    
    public final static String COM_UPDATE = "com_update";
    
    public final static String COM_DELETE = "com_delete";
    
    public final static String COM_COMMIT = "com_commit";
    
    public final static String COM_ROLLBACK = "com_rollback";
    
    @Autowired
    private MysqlStatusHistoryMapper mysqlStatusHistoryMapper;
    
    @Override
    public String performanceMonitor(Long server_id, String beginTime, String endTime)
    {
        String type[] = {QPS, COM_SELECT, COM_INSERT, COM_UPDATE, COM_DELETE, THREADS_RUNNING, THREADS_CONNECTED,
            BYTE_SEND, BYTE_RECEIVED, COM_COMMIT, COM_ROLLBACK,FSYNC,DIRTY,FLUSHED,INSERTED,UPDATED,DELETED};
        return getMonitorData(server_id, type, beginTime, endTime);
    }
    
    public String getMonitorData(Long nodeId, String[] type, int time, long max_id)
    {
        MysqlStatusHistoryExample example = new MysqlStatusHistoryExample();
        example.setOrderByClause("create_time");
        MysqlStatusHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(nodeId);
        criteria.andIdGreaterThanOrEqualTo(max_id);
        criteria.andCreateTimeBetween(org.apache.commons.lang3.time.DateUtils.addSeconds(new Date(), time), new Date());
        String content = getData(type, example);
        return content;
    }
    
    public String getMonitorData(Long nodeId, String[] type)
    {
        return getMonitorData(nodeId, type, null, null);
    }
    
    public String getMonitorData(Long nodeId, String[] type, String beginTime, String endTime)
    {
        MysqlStatusHistoryExample example = new MysqlStatusHistoryExample();
        example.setOrderByClause("create_time");
        MysqlStatusHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(nodeId);
        if (StringUtils.isNotBlank(beginTime) && StringUtils.isNotBlank(endTime))
        {
            try
            {
                criteria.andCreateTimeBetween(
                    org.apache.commons.lang3.time.DateUtils.parseDate(beginTime, "yyyy-MM-dd HH:mm:ss"),
                    org.apache.commons.lang3.time.DateUtils.parseDate(endTime, "yyyy-MM-dd HH:mm:ss"));
            }
            catch (ParseException e)
            {
                //获取30分钟的数据
                criteria.andCreateTimeBetween(org.apache.commons.lang3.time.DateUtils.addMinutes(new Date(), -180),
                    new Date());
                e.printStackTrace();
            }
        }
        else
        {
            //获取30分钟的数据
            criteria.andCreateTimeBetween(org.apache.commons.lang3.time.DateUtils.addMinutes(new Date(), -180),
                new Date());
        }
        String content = getData(type, example);
        return content;
    }
    
    private String getData(String[] type, MysqlStatusHistoryExample example)
    {
        List<MysqlStatusHistory> selectByExample = mysqlStatusHistoryMapper.selectByExample(example);
        long maxId = 0;
        if (!selectByExample.isEmpty())
        {
            maxId = selectByExample.get(selectByExample.size() - 1).getId();
        }
        //获取系统采样样本
        List<MysqlStatusHistory> sampleList = SysSampleUtil.getSysSample(selectByExample, SAMPLE_COUNT);
        
        List<String> xDataList = new ArrayList<String>();
        //qps
        List<String> qpsDataList = new ArrayList<String>();
        //fsync
        List<String> fsyncDataList = new ArrayList<String>();
        
        List<String> readDataList = new ArrayList<String>();
        
        List<String> writeDataList = new ArrayList<String>();
        
        List<String> dirtyDataList = new ArrayList<String>();
        
        List<String> flushedDataList = new ArrayList<String>();
        
        List<String> insertedDataList = new ArrayList<String>();
        
        List<String> updatedDataList = new ArrayList<String>();
        
        List<String> deletedDataList = new ArrayList<String>();
        
        List<String> threadsRunningDataList = new ArrayList<String>();
        List<String> threadsConnectedDataList = new ArrayList<String>();
        List<String> byteSendDataList = new ArrayList<String>();
        List<String> byteReceivedDataList = new ArrayList<String>();
        List<String> comSelectDataList = new ArrayList<String>();
        List<String> comInsertDataList = new ArrayList<String>();
        List<String> comUpdateDataList = new ArrayList<String>();
        List<String> comDeleteDataList = new ArrayList<String>();
        List<String> comCommitDataList = new ArrayList<String>();
        List<String> comRollbackDataList = new ArrayList<String>();
        
        for (MysqlStatusHistory mysqlStatusHistory : sampleList)
        {
            xDataList.add(MiscUtil.getFormatDateTime(mysqlStatusHistory.getCreateTime()));
            qpsDataList.add(mysqlStatusHistory.getQuestionsPersecond());
            fsyncDataList.add(mysqlStatusHistory.getInnodbDataFsyncsPersecond());
            readDataList.add(mysqlStatusHistory.getInnodbDataReadPersecond());
            writeDataList.add(mysqlStatusHistory.getInnodbDataWrittenPersecond());
            dirtyDataList.add(mysqlStatusHistory.getInnodbBufferPoolPagesDirtyPersecond());
            flushedDataList.add(mysqlStatusHistory.getInnodbBufferPoolPagesFlushedPersecond());
            insertedDataList.add(mysqlStatusHistory.getInnodbRowsInsertedPersecond());
            updatedDataList.add(mysqlStatusHistory.getInnodbRowsInsertedPersecond());
            insertedDataList.add(mysqlStatusHistory.getInnodbRowsInsertedPersecond());
            deletedDataList.add(mysqlStatusHistory.getInnodbRowsDeletedPersecond());
            
            threadsRunningDataList.add(String.valueOf(mysqlStatusHistory.getThreadsRunning()));
            threadsConnectedDataList.add(String.valueOf(mysqlStatusHistory.getThreadsConnected()));
            byteSendDataList.add(mysqlStatusHistory.getBytesSentPersecond());
            byteReceivedDataList.add(mysqlStatusHistory.getBytesReceivedPersecond());
            comSelectDataList.add(mysqlStatusHistory.getComSelectPersecond());
            comInsertDataList.add(mysqlStatusHistory.getComInsertPersecond());
            comUpdateDataList.add(mysqlStatusHistory.getComUpdatePersecond());
            comDeleteDataList.add(mysqlStatusHistory.getComDeletePersecond());
            comCommitDataList.add(mysqlStatusHistory.getComCommitPersecond());
            comRollbackDataList.add(mysqlStatusHistory.getComRollbackPersecond());
        }
        
        ChatDataDto dataDto = new ChatDataDto();
        dataDto.setMaxId(maxId);
        
        dataDto.setStatus(Status.NORMAL);
        String[] xAxisData = new String[xDataList.size()];
        
        Map<String, String[]> seriesDatas = new HashMap<String, String[]>();
        
        for (String key : type)
        {
            String[] seriesData = null;
            switch (key)
            {
                case QPS:
                    seriesData = new String[qpsDataList.size()];
                    qpsDataList.toArray(seriesData);
                    break;
                case FSYNC:
                    seriesData = new String[fsyncDataList.size()];
                    fsyncDataList.toArray(seriesData);
                    break;
                case READ:
                    seriesData = new String[readDataList.size()];
                    readDataList.toArray(seriesData);
                    break;
                case WRITE:
                    seriesData = new String[writeDataList.size()];
                    writeDataList.toArray(seriesData);
                    break;
                case DIRTY:
                    seriesData = new String[dirtyDataList.size()];
                    dirtyDataList.toArray(seriesData);
                    break;
                case FLUSHED:
                    seriesData = new String[flushedDataList.size()];
                    flushedDataList.toArray(seriesData);
                    break;
                case INSERTED:
                    seriesData = new String[insertedDataList.size()];
                    insertedDataList.toArray(seriesData);
                    break;
                case UPDATED:
                    seriesData = new String[updatedDataList.size()];
                    updatedDataList.toArray(seriesData);
                    break;
                case DELETED:
                    seriesData = new String[deletedDataList.size()];
                    deletedDataList.toArray(seriesData);
                    break;
                case THREADS_RUNNING:
                    seriesData = new String[threadsRunningDataList.size()];
                    threadsRunningDataList.toArray(seriesData);
                    break;
                case THREADS_CONNECTED:
                    seriesData = new String[threadsConnectedDataList.size()];
                    threadsConnectedDataList.toArray(seriesData);
                    break;
                case BYTE_SEND:
                    seriesData = new String[byteSendDataList.size()];
                    byteSendDataList.toArray(seriesData);
                    break;
                case BYTE_RECEIVED:
                    seriesData = new String[byteReceivedDataList.size()];
                    byteReceivedDataList.toArray(seriesData);
                    break;
                case COM_SELECT:
                    seriesData = new String[comSelectDataList.size()];
                    comSelectDataList.toArray(seriesData);
                    break;
                case COM_INSERT:
                    seriesData = new String[comInsertDataList.size()];
                    comInsertDataList.toArray(seriesData);
                    break;
                case COM_UPDATE:
                    seriesData = new String[comUpdateDataList.size()];
                    comUpdateDataList.toArray(seriesData);
                    break;
                case COM_DELETE:
                    seriesData = new String[comDeleteDataList.size()];
                    comDeleteDataList.toArray(seriesData);
                    break;
                case COM_COMMIT:
                    seriesData = new String[comCommitDataList.size()];
                    comCommitDataList.toArray(seriesData);
                    break;
                case COM_ROLLBACK:
                    seriesData = new String[comRollbackDataList.size()];
                    comRollbackDataList.toArray(seriesData);
                    break;
                default:
                    break;
            }
            seriesDatas.put(key, seriesData);
        }
        
        dataDto.setxAxisData(xDataList.toArray(xAxisData));
        dataDto.setSeriesDatas(seriesDatas);
        return JSON.toJSONString(dataDto);
    }
    
    /**
     * 启用缓存，保证在短时间内（3分钟）数据直接从缓存中获取
     */
    @Cacheable
    @Override
    public String performanceMonitor(Long server_id, String timeRange)
    {
        String beginTime = timeRange.split("-")[0].trim().replaceAll("/", "-");
        String endTime = timeRange.split("-")[1].trim().replaceAll("/", "-");
        return performanceMonitor(server_id, beginTime, endTime);
    }
}
