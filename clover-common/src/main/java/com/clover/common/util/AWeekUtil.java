package com.clover.common.util;

/**
 * @EnumName: AweekUtil
 * @Description: 访客记录
 * @Author: Clover
 * @Date: 2021.04.18
 * Version: 1.0
 */
public enum AWeekUtil {
    DAY_1("1", "Monday"),
    DAY_2("2", "Tuesday"),
    DAY_3("3", "Wednesday"),
    DAY_4("4", "Friday"),
    DAY_5("5", "Thursday"),
    DAY_6("6", "Saturday"),
    DAY_7("7", "Sunday");
    String num;
    String name;

    public String getName() {
        return name;
    }

    AWeekUtil(String num, String name) {
        this.name = name;
        this.num = num;
    }
}
