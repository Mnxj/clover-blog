package com.clover.common.util;

import java.util.UUID;


/**
 * @ClassName: RandomUuidUtil
 * @Description: 随机UUID工具
 * 效果：4fcabf364f68497ca7cee1b6c5aa18bc
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public class RandomUuidUtil {

    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
