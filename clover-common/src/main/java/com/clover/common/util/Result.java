package com.clover.common.util;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @Description: 返回格式
 * @Author: Clover
 * @Date: 2021.04.12
 * Version: 1.0
 */
@ApiModel(value = "RestErrorResponse", description = "返回格式参数包装")
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;
}
