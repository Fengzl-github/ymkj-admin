package com.ym.admin.util;

/**
 * @Author Fengzl
 * @Date 2022/7/25 9:41
 * @Desc
 **/
public class UnCodeUtil {

    /**
     * 获取唯一编码
     * @param prefix 前缀字符
     * @return
     */
    public static String getUncode(String prefix) {
        String ran = RandomUtil.getRandomNum(2);
        String timeMill = "" + tilNextMillis(timeGen());
        return prefix + timeMill.substring(timeMill.length() - 6) + ran;
    }


    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成的时间截
     * @return 当前时间戳
     */
    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    private static long timeGen() {
        return System.currentTimeMillis();
    }
}
