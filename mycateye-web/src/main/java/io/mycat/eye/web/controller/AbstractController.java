package io.mycat.eye.web.controller;

/**
 * The type Abstract controller.
 *
 * @ClassName: AbstractController
 * @Description:controller 控制类的父类,抽象一些公共方法及常量
 * @author: 李平(360841519@qq.com)
 * @date: 2017年4月13日 下午2:57:06
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
public class AbstractController
{
    /** 页面限制大小*/
    public static final String LIMIT_NAME = "limit";
    
    /** 当前条数角标*/
    public static final String OFFSET_NAME = "offset";
    
    /** 当前服务器node 节点server_id*/
    public static final String SERVER_ID = "server_id";
    
    /**图表数据的时间范围*/
    public static final String TIME_RANGE = "time_range";
}
