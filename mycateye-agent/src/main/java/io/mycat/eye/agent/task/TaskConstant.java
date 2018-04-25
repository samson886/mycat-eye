package io.mycat.eye.agent.task;

/**
 * Created by xqy on 18/4/25.
 */
public class TaskConstant {

    public final static long DELAY_TIME = 2000;
    public static final String SHOW_SERVER = "show @@server";
    public static final String SHOW_CONNECTION = "show @@connection";
    public static final String SHOW_BACKEND = "show @@backend";
    public static final String SHOW_EXECUTE = "show @@sql.execute";
    public static final String SHOW_DETAIL = "show @@sql.detail where id = ";
    public static final String SHOW_SQL = "show @@sql";
    public static final String SHOW_SQL_HIGH = "show @@sql.high";
    public static final String SHOW_SQL_SLOW = "show @@sql.slow";
    public static final String SHOW_SQL_SUM = "show @@sql.sum";
    public static final String SHOW_SQL_SUM_USER = "show @@sql.sum.user";
    public static final String SHOW_SQL_SUM_TABLE = "show @@sql.sum.table";

}
