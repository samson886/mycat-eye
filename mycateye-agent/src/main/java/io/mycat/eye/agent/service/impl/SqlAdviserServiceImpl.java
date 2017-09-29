/**
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  SqlAdviserServiceImpl.java
 * @Package cn.bqjr.dbeye.agent.service
 * @Description:    TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月22日 上午8:47:56
 * @version V1.0
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
package io.mycat.eye.agent.service.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLAggregateExpr;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat.Column;
import com.alibaba.druid.stat.TableStat.Condition;
import com.alibaba.druid.util.JdbcConstants;

import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MysqlServerMapper;
import io.mycat.eye.agent.service.JdbcService;
import io.mycat.eye.agent.service.SqlAdviserService;

/**
 * @ClassName: SqlAdviserServiceImpl
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月22日 上午8:47:56
 *
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@Service
public class SqlAdviserServiceImpl extends AbstractService implements SqlAdviserService
{
    private final static Integer MAX_LIMIT_START = 100000;
    
    private final static Long MAX_EXPLAIN_ROWS = 100000L;
    
    @Resource
    private MysqlServerMapper mysqlServerMapper;
    
    @Resource
    protected JdbcService jdbcService;
    
    @Override
    public String getAdvice(Long serverId, String schema, String sql)
    {
        String dbType = JdbcConstants.MYSQL;
        
        // 格式化输出
        String sqlFormat = SQLUtils.format(sql, dbType);
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTime() + " 第一步：格式化输出：\n" + sqlFormat + "\n");
        
        // 判断是否为单表查询
        if (stmtList.size() == 1)
        {
            SQLStatement stmt = stmtList.get(0);
            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);
            
            List<Condition> conditions = visitor.getConditions();
            String schemaTable = schema + "." + visitor.getCurrentTable();
            
            // 查看执行计划
            List<Map<Object, Object>> explainList = getExplain(serverId, schema, sql);
            stringBuilder.append(currentTime() + " 第二步：分析检查行数...\n");
            
            Map<Object, Object> explainMap = explainList.get(0);
            Long rows = 0L;
            if (explainMap.get("rows") != null)
            {
                rows = ((BigInteger)explainMap.get("rows")).longValue();
            }
            stringBuilder
                .append(currentTime() + " 检查行数：" + rows + ",查询类型为：" + (String)explainMap.get("select_type") + "\n");
            
            if (rows > MAX_EXPLAIN_ROWS)
            {
                stringBuilder.append(currentTime() + " 检查行数过多，扫描需要较长时间，建议通过过滤条件，缩小查询范围\n");
                
            }
            stringBuilder.append(currentTime() + " 第三步：分析LIMIT语句...\n");
            // 如果行数较少，则没有必要对limit进行检查
            if (rows > MAX_EXPLAIN_ROWS)
            {
                // 分析limit语句
                stringBuilder.append(analyzeLimit(sql));
            }
            
            stringBuilder.append(currentTime() + " 第四步：分析WHERE条件...\n");
            
            // WHERE条件不为空
            if (!conditions.isEmpty())
            {
                String where = "";
                
                // 提取条件字段，去重
                Set<String> whereColumnsSet = new HashSet<String>();
                
                for (Condition condition : conditions)
                {
                    where += (condition.toString() + ";");
                    whereColumnsSet.add(condition.getColumn().getName());
                }
                
                stringBuilder.append(currentTime() + " SQL语句WHERE条件：" + where + "\n");
                
                String whereColumns = "";
                
                for (String column : whereColumnsSet)
                {
                    whereColumns += (column + ",");
                }
                
                whereColumns = whereColumns.substring(0, whereColumns.lastIndexOf(","));
                
                // 分析索引字段
                stringBuilder.append(currentTime() + " 分析最左前缀字段的索引情况...\n");
                
                stringBuilder.append(currentTime() + " 可能使用的索引：" + (String)explainMap.get("possible_keys") + "，实际使用索引："
                    + (String)explainMap.get("key") + "\n");
                
                // 如果没有使用索引
                if (explainMap.get("key") == null)
                {
                    // 查看第一个条件字段
                    String firstColumn = whereColumnsSet.iterator().next();
                    stringBuilder.append(currentTime() + " 检查字段" + firstColumn + "是否有索引\n");
                    
                    List<Map<Object, Object>> indexList = getIndexFromTable(serverId, schemaTable, firstColumn);
                    
                    if (!indexList.isEmpty())
                    {
                        Long sqlIndex = (Long)indexList.get(0).get("SEQ_IN_INDEX");
                        String indexName = (String)indexList.get(0).get("INDEX_NAME");
                        stringBuilder.append(currentTime() + " 字段：" + firstColumn + "存在索引" + indexName + "\n");
                        
                        if (sqlIndex > 1)
                        {
                            stringBuilder.append(currentTime() + " 不能使用索引" + indexName + "，因为索引的最左前缀字段不是" + firstColumn
                                + "，建议按照最左前缀原则修改查询条件\n");
                        }
                        else
                        {
                            String firstColumnLike = firstColumn + " like '%";
                            
                            if (sql.indexOf(firstColumnLike) != -1)
                            {
                                stringBuilder.append(currentTime() + " 不能使用索引，因为字段" + firstColumn
                                    + " 使用了 like '%**'，like的前缀为%时不能使用索引，建议不适用like进行查询或使用like后缀匹配,like '**%'\n");
                            }
                            else
                            {
                                stringBuilder
                                    .append(currentTime() + " 没有使用索引，因为MySQL优化器判断即使使用索引不会比不使用效率高，这可能因为你的索引区分度较低所致\n");
                            }
                        }
                    }
                    else
                    {
                        stringBuilder.append(currentTime() + " SQL语句没有使用索引，建议在条件字段：" + whereColumns + "上增加索引\n");
                    }
                }
            }
            else
            {
                stringBuilder.append(currentTime() + " SQL语句不存在WHERE条件，暂无建议\n");
            }
            // 检查聚合函数
            stringBuilder.append(currentTime() + " 第五步：分析聚合函数...\n");
            
            List<SQLAggregateExpr> aggregateFunctions = visitor.getAggregateFunctions();
            
            if (!aggregateFunctions.isEmpty())
            {
                for (SQLAggregateExpr sqlAggregateExpr : aggregateFunctions)
                {
                    String methodName = sqlAggregateExpr.getMethodName();
                    
                    if ("COUNT".equals(methodName))
                    {
                        // WHERE条件不为空
                        if (!conditions.isEmpty())
                        {
                            stringBuilder.append(currentTime() + " SQL语句使用了COUNT函数，通过WHERE条件的进行过滤，暂无建议\n");
                        }
                        else
                        {
                            stringBuilder.append(currentTime()
                                + " SQL语句使用了COUNT函数，MySQL对缺少WHERE条件的COUNT语句进行了优化：Select tables optimized away\n");
                        }
                    }
                    else
                    {
                        
                        stringBuilder.append(currentTime() + " SQL语句使用了" + methodName + "函数,检查参数是否为索引字段...\n");
                        
                        SQLExpr sqlExpr = sqlAggregateExpr.getArguments().get(0);
                        List<Map<Object, Object>> indexFromTable =
                            getIndexFromTableByPrefix(serverId, schemaTable, sqlExpr.toString());
                        
                        if (indexFromTable.isEmpty())
                        {
                            stringBuilder.append(currentTime() + " " + methodName + "函数,参数" + sqlExpr
                                + "不是索引字段，执行效率较低，建议在该字段上增加索引或将其他索引字段作为参数\n");
                        }
                        else
                        {
                            stringBuilder
                                .append(currentTime() + " " + methodName + "函数,参数" + sqlExpr + "是索引字段，暂无严重性能问题\n");
                        }
                    }
                }
            }
            else
            {
                stringBuilder.append(currentTime() + " SQL语句不存在聚合函数，暂无建议\n");
            }
            //获取执行计划的额外项
            String extra = (String)explainMap.get("Extra");
            // 分析ORDER BY语句
            stringBuilder.append(currentTime() + " 第六步：分析ORDER BY语句...\n");
            List<Column> orderByColumns = visitor.getOrderByColumns();
            if (!orderByColumns.isEmpty())
            {
                String orderByStr = "order by ";
                for (Column column : orderByColumns)
                {
                    orderByStr += column + ";";
                }
                stringBuilder.append(currentTime() + " ORDER BY语句： " + orderByStr + "\n");
                String firstOrderByColumn = orderByColumns.get(0).getName();
                if (extra.indexOf("filesort") != -1)
                {
                    if (orderByColumns.size() > 1)
                    {
                        stringBuilder.append(currentTime() + " ORDER BY语句使用了filesort（文件排序），建议检查字段" + orderByStr
                            + "是否在同一个索引当中，字段顺序务必和索引字段的顺序一致，排序规则是否一致（要么升序,要么降序）\n");
                    }
                    else
                    {
                        stringBuilder.append(
                            currentTime() + " ORDER BY语句使用了filesort（文件排序），建议检查字段" + firstOrderByColumn + "是否在索引当中\n");
                    }
                }
                else
                {
                    stringBuilder.append(currentTime() + " ORDER BY语句无异常，暂无建议\n");
                }
            }
            else
            {
                stringBuilder.append(currentTime() + " SQL语句不存在ORDER BY，暂无建议\n");
            }
            // 对ORDERBY GROUPBY进行分析
            stringBuilder.append(currentTime() + " 第七步：分析GROUP BY语句...\n");
            Set<Column> groupByColumns = visitor.getGroupByColumns();
            if (groupByColumns.isEmpty())
            {
                stringBuilder.append(currentTime() + " SQL语句不存在GROUP BY，暂无建议\n");
            }
            else
            {
                String firstGroupByColumn = groupByColumns.iterator().next().getName();
                if (extra.indexOf("temporary") != -1)
                {
                    stringBuilder
                        .append(currentTime() + " GROUP BY使用了temporary（临时表），请检查字段" + firstGroupByColumn + "是否在索引中\n");
                }
            }
            
        }
        else
        {
            stringBuilder.append(currentTime() + " SQL Adviser暂不支持对连接、子查询进行分析");
        }
        
        stringBuilder.append(currentTime() + " DBEYE SQLHelper分析完毕");
        
        return stringBuilder.toString();
    }
    
    /**
     * 获取执行计划 @Title: getExplain @param serverId @param schema @param
     * sql @return @throws
     */
    private List<Map<Object, Object>> getExplain(Long serverId, String schema, String sql)
    {
        String explainSql = "explain " + sql;
        QueryResult<List<Map<Object, Object>>> explainQueryResult = getQueryResult(serverId, schema, explainSql);
        
        return explainQueryResult.getData();
    }
    
    /**
     * 根据表获取索引 @Title: getIndexFromTable @param serverId @param schema @param
     * table @return @throws
     */
    private List<Map<Object, Object>> getIndexFromTable(Long serverId, String schemaTable, String column)
    {
        String sql = "show index from " + schemaTable + " where Column_name like '" + column + "'";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        
        return queryResult.getData();
    }
    
    /**
     * 根据表以及最左前缀字段获取索引 @Title: getIndexFromTableByPrefix @param serverId @param
     * schemaTable @param column @return @throws
     */
    private List<Map<Object, Object>> getIndexFromTableByPrefix(Long serverId, String schemaTable, String column)
    {
        String sql =
            "show index from " + schemaTable + " where Column_name like '" + column + "' and Seq_in_index like '1'";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        
        return queryResult.getData();
    }
    
    private String currentTime()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
    }
    
    /**
     * 分析LIMIT语句 @Title: analyzeLimit @param sql @return @throws
     */
    private String analyzeLimit(String sql)
    {
        StringBuffer stringBuffer = new StringBuffer();
        String sqlLowerCase = sql.toLowerCase();
        int indexOfLimit = sqlLowerCase.indexOf("limit");
        
        if (indexOfLimit != -1)
        {
            String limit = sql.substring(indexOfLimit + 6);
            stringBuffer.append(currentTime() + " SQL语句含有LIMIT条件,LIMIT " + limit + "\n");
            
            Integer start = Integer.valueOf(limit.split(",")[0].trim());
            
            if (start > MAX_LIMIT_START)
            {
                stringBuffer.append(currentTime() + " SQL语句的LIMIT起始值较大,扫描成本增加，建议减小该值 \n");
            }
            else
            {
                stringBuffer.append(currentTime() + " SQL语句中的LIMIT起始位置和偏移量无异常，暂无建议\n");
            }
        }
        else
        {
            stringBuffer.append(currentTime() + " SQL语句不存在LIMIT，暂无建议\n");
        }
        
        return stringBuffer.toString();
    }
}
