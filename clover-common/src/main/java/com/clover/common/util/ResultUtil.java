package com.clover.common.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ResultUtil
 * @Description:
 * @Author: Clover
 * @Date: 2021.04.14
 * Version: 1.0
 */
@Data
public class ResultUtil {


    public static Result<Map<String, Object>> success(String data) {
        Result<Map<String, Object>> result = new Result<>();
        result.setSuccess(data.equals("请求成功"));
        result.setMessage(data);
        return result;
    }
}
