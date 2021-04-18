package com.clover.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: PhoneUtil
 * @Description:    校验用户手机号是否合法
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public class PhoneUtil {
    public static Boolean isMatches(String phone){
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
