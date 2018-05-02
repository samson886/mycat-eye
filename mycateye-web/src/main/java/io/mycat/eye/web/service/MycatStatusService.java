package io.mycat.eye.web.service;

import com.alibaba.fastjson.JSON;
import io.mycat.eye.web.bean.MycatServerStatus;
import io.mycat.eye.web.bean.MycatServerStatusExample;
import io.mycat.eye.web.dto.ChatDataDto;
import io.mycat.eye.web.mapper.MycatServerStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xqy on 18/5/1.
 */
@Service
public class MycatStatusService {
    @Autowired
    MycatServerStatusMapper mapper;

    public ChatDataDto getServerStatus(int server_id, String beginTime, String endTime){
        MycatServerStatusExample example = new MycatServerStatusExample();
        MycatServerStatusExample.Criteria criteria = example.createCriteria();
        criteria.andMycatIdEqualTo(server_id);
//        String beginTime = timeRange.split("-")[0].trim().replaceAll("/", "-");
//        String endTime = timeRange.split("-")[1].trim().replaceAll("/", "-");
        criteria.andCollectTimeBetween(Timestamp.valueOf(beginTime).getTime(),Timestamp.valueOf(endTime).getTime());
        List<MycatServerStatus> list = mapper.selectByExample(example);
        int size = list.size();
        Map<String,String[]> series = new HashMap<>();
        String[] xAxis = new String[size];
        String[] useMemory = new String[size],
                totalMemory = new String[size],
                maxMemory = new String[size];
        MycatServerStatus s = new MycatServerStatus();
        Format format = new SimpleDateFormat("yy MM dd HH:mm");
        for(int i=0;i<size;i++){
            s = list.get(i);

            xAxis[i] = format.format(s.getCollectTime());//String.valueOf(s.getCollectTime());
            useMemory[i] = String.valueOf(s.getUsedMemory()/1024);
            totalMemory[i] = String.valueOf(s.getTotalMemory()/1024);
            maxMemory[i] = String.valueOf(s.getMaxMemory()/1024);
        }
        series.put("useMemory",useMemory);
        series.put("totalMemory",totalMemory);
        series.put("maxMemory",maxMemory);
        ChatDataDto chatDataDto = new ChatDataDto();
        chatDataDto.setxAxisData(xAxis);
        chatDataDto.setSeriesDatas(series);
        return chatDataDto;
    }
}
