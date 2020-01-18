package com.customize.web.core;

import com.customize.common.component.CommonResult;
import com.customize.common.constants.ResultCodeEnum;
import com.customize.web.component.MsgSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result extends CommonResult {

    private Result(Integer state, ResultCodeEnum resultCodeEnum, Object data, Object... objects) {
        super(state, resultCodeEnum.name(), MsgSource.getMessage(resultCodeEnum, objects), data);
    }

    private Result(Integer state, String resultCode, String message, Object data) {
        super(state, resultCode, message, data);
    }

    public static Result success(Object data) {
        return new Result(success, ResultCodeEnum.SUCCESS, data);
    }

    public static Result success() {
        return new Result(success, ResultCodeEnum.SUCCESS, null);
    }

    public static Result error(ResultCodeEnum resultCodeEnum, Object... objects) {
        return new Result(fail, resultCodeEnum, null, objects);
    }

    public static Result error(ResultCodeEnum resultCodeEnum) {
        return new Result(fail, resultCodeEnum, null);
    }

    public static Result error() {
        return new Result(fail, ResultCodeEnum.ERROR, null);
    }

    public static Result error(String msg) {
        return new Result(fail, ResultCodeEnum.ERROR.name(), msg, null);
    }

    public static Result error(String code, String msg) {
        return new Result(fail, code, msg, null);
    }
}
