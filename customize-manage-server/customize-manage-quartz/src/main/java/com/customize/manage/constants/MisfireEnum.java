package com.customize.manage.constants;

public enum MisfireEnum {
    /**
     * 默认策略
     */
    MISFIRE_DEFAULT,
    /**
     * 立即触发执行
     */
    MISFIRE_IGNORE_MISFIRES,
    /**
     * 触发一次执行
     */
    MISFIRE_FIRE_AND_PROCEED,
    /**
     * 不触发立即执行
     */
    MISFIRE_DO_NOTHING

}
