/**
 * All rights Reserved, Designed By www.openwork.org.cn
 *
 * @Title: JdbcServiceImpl.java
 * @Package cn.bqjr.mysqleye.service.impl
 * @Description: TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年4月1日 下午5:20:25
 * @version V1.0
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
package io.mycat.eye.agent.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.service.JdbcService;

/**
 * @ClassName: JdbcServiceImpl
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年4月1日 下午5:20:25
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@Service
public class JdbcServiceImpl implements JdbcService {
    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcServiceImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see cn.bqjr.mysqleye.service.JdbcService#queryForList(java.lang.String,
     * java.lang.String)
     */
    @Override
    public QueryResult<List<Map<Object, Object>>> queryForList(String url, String sql, String user, String password) {
        QueryResult<List<Map<Object, Object>>> queryResult = new QueryResult<List<Map<Object, Object>>>();
        Connection conn = null;
        try {
            conn = getConnection(url,user,password);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                List<Map<Object, Object>> list = resultSetToList(rs);
                // 操作成功，则将数据放入查询结果中
                queryResult.setSuccess(true);
                queryResult.setData(list);
                LOGGER.info("url:" + url + ",sql:" + sql);
            }
        } catch (Exception e) {
            // 数据操作异常，则将异常信息放入查询结果中
            queryResult.setSuccess(false);
            queryResult.setException(e.getMessage());
            // 打印日志
            String message = "url:" + url + ",sql:" + sql + ",exception:" + e.getMessage();
            LOGGER.error(message);
        } finally {
            closeConnection(conn);
        }
        return queryResult;
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.bqjr.mysqleye.service.JdbcService#queryForCount(java.lang.String,
     * java.lang.String)
     */
    @Override
    public QueryResult<Integer> queryForCount(String url, String sql, String user, String password) {
        QueryResult<Integer> queryResult = new QueryResult<Integer>();
        Integer count = 0;
        Connection conn = null;
        try {
            conn = getConnection(url,user,password);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                count = Integer.valueOf(rs.getInt(1));
                queryResult.setSuccess(true);
                queryResult.setData(count);
                LOGGER.info("url:" + url + ",sql:" + sql);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            queryResult.setSuccess(false);
            queryResult.setException(e.getMessage());
        } finally {
            closeConnection(conn);
        }

        return queryResult;
    }



    @Override
    public QueryResult<Integer> executeSqlForBoolean(String url, String sql, String user, String password) {
        QueryResult<Integer> queryResult = new QueryResult<Integer>();
        Connection conn = null;
        try {
            conn = getConnection(url,user,password);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                Integer executeResult = stmt.executeUpdate(sql);
                queryResult.setSuccess(true);
                queryResult.setData(executeResult);
                LOGGER.info("url:" + url + ",sql:" + sql);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            queryResult.setSuccess(false);
            queryResult.setException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return queryResult;

    }
    
    @Override
    public void executeSql(String url, String sql, String user, String password) {
        Connection conn = null;
        try {
            conn = getConnection(url,user,password);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                Integer executeResult = stmt.executeUpdate(sql);
                LOGGER.info("url:" + url + ",sql:" + sql+",executeResult:"+executeResult);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * Result转List @Title: resultSetToList @param rs @return @throws
     * java.sql.SQLException @throws
     */
    private List<Map<Object, Object>> resultSetToList(ResultSet rs) throws java.sql.SQLException {
        if (rs == null) {
            return Collections.emptyList();
        }

        ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

        while (rs.next()) {
            Map<Object, Object> rowData = new HashMap<Object, Object>();

            for (int i = 1; i <= columnCount; i++) {
                if (!rowData.containsKey(md.getColumnName(i))) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
            }

            list.add(rowData);
        }

        return list;
    }

    /**
     * 获取连接 @Title: getConnection @param url @return @throws Exception @throws
     */
    private Connection getConnection1(String url) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url);
        LOGGER.info("create a data connection");

        return conn;
    }
    
    private Connection getConnection(String url,String uname ,String upass) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,uname,upass);
        LOGGER.info("create a data connection");
        return conn;
    }
    /**
     * 关闭连接 @Title: closeConnection @param conn @throws
     */
    private void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
            LOGGER.info("close a data connection");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
