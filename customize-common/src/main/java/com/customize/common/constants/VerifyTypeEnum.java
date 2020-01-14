package com.customize.common.constants;

public enum VerifyTypeEnum {
    /**
     * 通常验证
     * 1、非空验证
     */
    USUALLY,
    /**
     * 手机号
     * 1、大陆手机号格式验证
     * 2、需要由其他条件判断是否非空
     */
    MOBILE_PHONE,
    /**
     * 邮箱
     * 1、国际邮箱格式验证
     * 2、需要由其他条件判断是否非空
     */
    EMAIL,
    /**
     * 身份证
     * 1、大陆身份证格式验证
     * 2、需要由其他条件判断是否非空
     */
    IDENTITY_CARD
}
