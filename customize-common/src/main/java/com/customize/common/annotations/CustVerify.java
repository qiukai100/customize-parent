package com.customize.common.annotations;

import com.customize.common.constants.RegexEnum;
import com.customize.common.constants.VerifyTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证字段注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustVerify {

    /**
     * 验证类型
     * 1、默认通常验证
     *
     * @return
     */
    VerifyTypeEnum verifyType() default VerifyTypeEnum.USUALLY;

    /**
     * 非空
     * 1、默认检查
     *
     * @return
     */
    boolean notEmpty() default true;

    /**
     * 自定义正则
     * 1、只在参数不为空的情况下检查
     *
     * @return
     */
    RegexEnum regex() default RegexEnum.NONE;

    /**
     * 最小长度
     * 1、默认为0
     * 2、0则不校验
     * 3、只在参数不为空的情况下检查
     *
     * @return
     */
    int minSize() default 0;

    /**
     * 最大长度
     * 1、默认为0
     * 2、0则不校验
     * 3、只在参数不为空的情况下检查
     *
     * @return
     */
    int maxSize() default 0;

    /**
     * 验证失败时的返回
     *
     * @return
     */
    String msg() default "param is vail fail";
}
