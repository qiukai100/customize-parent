package com.customize.component.modules;

import com.customize.common.constants.ResultCodeEnum;
import com.customize.component.sources.MsgSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private static final int success = 0;
    private static final int fail = -1;

    private Integer state;

    private String resultCode;

    private String message;

    private Object data;

    private Result(Integer state, ResultCodeEnum resultCodeEnum, Object data, Object...objects) {
        this.state = state;
        this.resultCode = resultCodeEnum.name();
        this.message = MsgSource.getMessage(resultCodeEnum, objects);
        this.data = data;
    }

    private Result(Integer state, String resultCode, String message, Object data) {
        this.state = state;
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(success, ResultCodeEnum.SUCCESS, data);
    }

    public static Result success() {
        return new Result(success, ResultCodeEnum.SUCCESS, null);
    }

    public static Result error(ResultCodeEnum resultCodeEnum, Object...objects) {
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
}
