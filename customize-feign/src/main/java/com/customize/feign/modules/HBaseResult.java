package com.customize.feign.modules;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HBaseResult {

    private static final int success = 0;
    private static final int fail = -1;

    private Integer state;

    private String message;

    private Object data;

    public HBaseResult(Integer state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static HBaseResult error(String msg) {
        return new HBaseResult(fail, msg, null);
    }

    public boolean isSuccess() {
        return state.equals(success);
    }
}
