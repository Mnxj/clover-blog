package com.clover.common.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName: RestErrorResponse
 * @Description: 错误响应参数包装
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
@ApiModel(value = "RestErrorResponse", description = "错误响应参数包装")
@Data
public class RestErrorResponse {

    private String errCode;

    private String errMessage;

    public RestErrorResponse(String errCode,String errMessage){
        this.errCode = errCode;
        this.errMessage= errMessage;
    }


}
