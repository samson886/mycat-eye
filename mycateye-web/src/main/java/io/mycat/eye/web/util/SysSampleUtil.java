/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  SysSampleUtil.java   
 * @Package io.mycat.eye.web.util   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月8日 上午10:47:06   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.web.util;

import java.util.ArrayList;
import java.util.List;

import io.mycat.eye.web.bean.MysqlStatusHistory;

/**   
 * @ClassName:  SysSampleUtil   
 * @Description:系统采样
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月8日 上午10:47:06   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class  SysSampleUtil<T>
{
    /**
     * 在传入的MySQL状态指标中，进行系统采样，获取指定数量的样本数据
     * @Title: sysSample   
     * @param list
     * @param count 样本数量
     * @return        
     * @throws
     */
    public static List<MysqlStatusHistory> getSysSample(List<MysqlStatusHistory> list,int count){
        List<MysqlStatusHistory> sampleList=null;
        int size = list.size();
        if (size<=count)
        {
            sampleList=list;
        }
        else{
            //计算现有数据量与样本数量的倍数
            int multiple=size/count;
            sampleList=new ArrayList<>();
            //以倍数作为步长，从原数据集合中取样
            for(int i=0;i<size;i=i+multiple){
                sampleList.add(list.get(i));
            } 
        }
       
        return sampleList;
    }
}
