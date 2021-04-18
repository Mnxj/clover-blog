package com.clover.common.domain;

/**
 * @ClassName: BusinessException
 * @Description: 自定义的异常类型
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }
    public BusinessException() {
        super();
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
