package com.customize.common.component;

import com.customize.common.constants.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用结果集
 */
@Getter
@Setter
public class CommonResult {

    protected static final int success = 0;
    protected static final int fail = -1;

    private Integer state;

    private String resultCode;

    private String message;

    private Object data;

    protected CommonResult(Integer state, ResultCodeEnum resultCodeEnum, Object data) {
        this.state = state;
        this.resultCode = resultCodeEnum.name();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }

    protected CommonResult(Integer state, String resultCode, String message, Object data) {
        this.state = state;
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public static CommonResult success(Object data) {
        return new CommonResult(success, ResultCodeEnum.SUCCESS, data);
    }

    public static CommonResult success() {
        return new CommonResult(success, ResultCodeEnum.SUCCESS, null);
    }

    public static CommonResult error(ResultCodeEnum resultCodeEnum) {
        return new CommonResult(fail, resultCodeEnum, null);
    }

    public static CommonResult error() {
        return new CommonResult(fail, ResultCodeEnum.ERROR, null);
    }

    public static CommonResult error(String msg) {
        return new CommonResult(fail, ResultCodeEnum.ERROR.name(), msg, null);
    }

    public static CommonResult error(String code, String msg) {
        return new CommonResult(fail, code, msg, null);
    }

    public boolean isSuccess() {
        return state != null && state.equals(success);
    }
}
