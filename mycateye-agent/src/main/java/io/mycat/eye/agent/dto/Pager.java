/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  Pager.java   
 * @Package cn.bqjr.dbeye.agent.dto   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年5月22日 上午10:04:37   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

/**
 * @ClassName: Pager
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月22日 上午10:04:37
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class Pager<T> {
    private T rows;
    private Integer total;

    /**
     * @return the rows
     */
    public T getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(T rows) {
        this.rows = rows;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
	return total;
    }

    /**
     * @param total
     *            the total to set
     */
    public void setTotal(Integer total) {
	this.total = total;
    }

}
