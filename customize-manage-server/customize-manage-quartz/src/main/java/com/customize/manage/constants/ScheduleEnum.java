package com.customize.manage.constants;

public enum ScheduleEnum {
    TASK_SOURCE_KEY("TASK_SOURCE_KEY"),
    TASK_RUN_SUCCESS("0"),
    TASK_RUN_FAIL("1"),
    ;

    private String code;

    ScheduleEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
