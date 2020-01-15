package com.customize.common.constants;

public enum ResultCodeEnum {
    SUCCESS("操作成功"),
    ERROR("操作失败");

    private String message;

    ResultCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
