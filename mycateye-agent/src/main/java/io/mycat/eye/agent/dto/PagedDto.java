/**
 * 
 */
package io.mycat.eye.agent.dto;

import java.util.List;

/**
 * @author liping
 * @param <T>
 *
 */
public class PagedDto<T>
{
    private Integer draw;
    
    private Integer recordsTotal;
    
    private Integer recordsFiltered;
    
    private List<T> data;
    
    public Integer getDraw()
    {
        return draw;
    }
    
    public void setDraw(Integer draw)
    {
        this.draw = draw;
    }
    
    public Integer getRecordsTotal()
    {
        return recordsTotal;
    }
    
    public void setRecordsTotal(Integer recordsTotal)
    {
        this.recordsTotal = recordsTotal;
    }
    
    public Integer getRecordsFiltered()
    {
        return recordsFiltered;
    }
    
    public void setRecordsFiltered(Integer recordsFiltered)
    {
        this.recordsFiltered = recordsFiltered;
    }
    
    public List<T> getData()
    {
        return data;
    }
    
    public void setData(List<T> data)
    {
        this.data = data;
    }
}
