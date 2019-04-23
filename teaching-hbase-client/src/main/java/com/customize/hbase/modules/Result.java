package com.customize.hbase.modules;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private static final int success = 0;
    private static final int fail = -1;
    private static final String success_msg = "操作成功";
    private static final String fail_msg = "操作失败";

    private Integer state;

    private String message;

    private Object data;

    private Result(Integer state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(success, success_msg, data);
    }

    public static Result success() {
        return new Result(success, success_msg, null);
    }

    public static Result error() {
        return new Result(fail, fail_msg, null);
    }

    public static Result error(String msg) {
        return new Result(fail, msg, null);
    }
}
