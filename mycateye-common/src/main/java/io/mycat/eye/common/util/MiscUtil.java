/**
 * All rights Reserved, Designed By www.openwork.org.cn
 *
 * @Title: MiscUtil.java
 * @Package cn.org.openwork.nosql.util
 * @Description: 常用工具类
 * @author: 李平(360841519 @ qq.com)
 * @date: 2017年7月21日 下午2:53:20
 * @version V1.0
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
package io.mycat.eye.common.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MiscUtil
 * @Description:常用工具类
 * @author: 李平(360841519 @ qq.com)
 * @date: 2017年7月21日 下午2:53:20
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class MiscUtil {
    /**
     * 字节数转换为MB格式
     *
     * @param bytes
     * @return
     * @throws
     * @Title: bytesToMb
     */
    public static String bytesToMb(String bytes) {
        BigDecimal bytesBigDecimal = new BigDecimal(bytes);
        BigDecimal mbBigDecimal = bytesBigDecimal.divide(new BigDecimal(1024 * 1024), 1, BigDecimal.ROUND_HALF_UP);
        return mbBigDecimal.toString();
    }

    /**
     * 根据偏移量获取时间
     *
     * @param addHours
     * @return
     * @throws
     * @Title: getDateTimeByOffsetHours
     */
    public static Date getDateTimeByOffsetHours(int addHours) {
        Calendar cal = Calendar.getInstance();
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        cal.add(Calendar.HOUR_OF_DAY, addHours);
        Date date = cal.getTime();
        return date;
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     * @throws
     * @Title: getDateTimeByFormat
     */
    public static String getFormatDateTime(Date date) {
        return new SimpleDateFormat("MM-dd HH:mm:ss").format(date);
    }

    /**
     * 字节转KB MB GB
     *
     * @param size
     * @return
     * @throws
     * @Title: getHumanSize
     */
    public static String getHumanSizeByBytes(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义  
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位  
        //因为还没有到达要使用另一个单位的时候  
        //接下去以此类推  
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，  
            //因此，把此数乘以100之后再取余  
            size = size * 100;
            return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理  
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
        }
    }

    /**
     * 秒转为易读的时间
     *
     * @param sec
     * @return
     * @throws
     * @Title: getHumanTimeBySeconds
     */
    public static String getHumanTimeBySeconds(long sec) {
        long mss = sec * 1000;
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
    }

    /**
     * 获取两数相除的百分比
     *
     * @param a
     * @param b
     * @return
     * @throws
     * @Title: getPercentage
     */
    public static String getPercentage(Long a, Long b) {
        BigDecimal divide = new BigDecimal(a).divide(new BigDecimal(b), 1, BigDecimal.ROUND_HALF_UP);
        BigDecimal percentage = divide.multiply(new BigDecimal(100)).setScale(1, BigDecimal.ROUND_HALF_UP);
        return percentage + "%";
    }


    public static Map<String, String> mapOf(String key, String value) {
        HashMap<String, String> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static Map<String, String> mapOf(String key, String value, String key2, String value2) {
        HashMap<String, String> map = new HashMap<>(2);
        map.put(key, value);
        map.put(key2, value2);
        return map;
    }
}
