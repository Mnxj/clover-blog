package com.clover.common.util;


import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

/**
 * @ClassName: RandomStringUtil
 * @Description: 随机字符串工具
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public class RandomStringUtil {
    /**
     * 获取指定长度随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append((char) result);
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append((char) result);
                    break;
                case 2:
                    sb.append(new Random().nextInt(10));
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * 测试验证
     *
     * @param args
     */
    public static void main(String[] args) {
        //for (int i = 0; i < 8; i++) {
            System.out.println(RandomStringUtil.getRandomString(10));
     //   }
    }


}
