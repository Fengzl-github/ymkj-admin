package com.ym.admin.util;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import static com.aventrix.jnanoid.jnanoid.NanoIdUtils.DEFAULT_ALPHABET;

/**
 * @Author Fengzl
 * @Date 2022/7/25 13:13
 * @Desc
 **/
public class RandomUtil {

    public static final char[] DEFAULT_ALPHABET_NUMBER = "0123456789".toCharArray();

    /**
     * 获取n位随机数字(09)
     * @param n
     * @return
     */
    public static String getRandomNum(int n) {
        return NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, DEFAULT_ALPHABET_NUMBER, n);
    }


    /**
     * 获取n位随机数(_-09az)
     * @param n
     * @return
     */
    public static String getRandomStr(int n) {
        return NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, DEFAULT_ALPHABET, n);
    }
}
