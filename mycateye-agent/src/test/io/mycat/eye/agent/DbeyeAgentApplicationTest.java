package io.mycat.eye.agent;

import io.mycat.eye.agent.bean.MycatSqlExecute;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.Assert.*;

/**
 * Created by xqy on 18/4/28.
 */
public class DbeyeAgentApplicationTest {
    public static void main(String[] args){
        String pwd = "123456";
        byte[] encode = Base64.getEncoder().encode(pwd.getBytes());
        System.out.println(Arrays.toString(encode));
        System.out.println(new String(encode));
        System.out.println(Arrays.toString(Base64.getDecoder().decode(encode)));
        System.out.println(new String(Base64.getDecoder().decode(encode)));
        System.out.println(System.currentTimeMillis());

        List<MycatSqlExecute> executeList = new ArrayList<>();
        LongStream.range(0,10).forEach(i->{
            MycatSqlExecute m = new MycatSqlExecute();
            m.setSqlId(i);
            m.setSqlExecute(i);
            executeList.add(m);

        });
        long[] exes = executeList.stream().mapToLong(a -> a.getSqlId()).toArray();
        System.out.println(Arrays.toString(exes));
        char[] cs = {'f','a','l','s','e'};
        System.out.println(new String(cs)+" "+new String(cs).equals("false"));
    }

}