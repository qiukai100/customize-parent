package com.customize.common.exception;

import com.customize.common.constants.ResultCodeEnum;

/**
 * 自定义异常
 * 继承至RuntimeException，可回滚事务
 */
public class CustomException extends RuntimeException {

    private String code;

    public CustomException(ResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum.name(), resultCodeEnum.getMessage());
    }

    public CustomException(String message) {
        this(ResultCodeEnum.ERROR.name(), message);
    }

    private CustomException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
