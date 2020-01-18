package com.customize.quartz.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.customize.common.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class TaskSource {

    /**
     * 任务名
     */
    private String jobName;

    /**
     * 任务组名
     */
    private String jobGroup;

    /**
     * 触发器名
     */
    private String triggerName;

    /**
     * 触发器组
     */
    private String triggerGroup;

    /**
     * 是否允许并发执行
     */
    private Boolean concurrent = Boolean.FALSE;

    /**
     * 定时策略类型
     */
    private String misfirePolicy;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * 类名
     */
    private String beanName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 方法参数
     * 传入规则：Object[]为两位长度，0下标是参数类型的class，1下标为参数的值
     * 例如：[["String.class", "demo"], ["Integer.class", 0]]
     */
    private List<Object[]> methodParams;

    /**
     * 任务标识（附带属性）
     */
    private String[] keys;

    public boolean isEmpty() {
        return StringUtils.isExistEmpty(jobName, jobGroup, triggerName, triggerGroup, cronExpression, beanName, methodName);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,
                // 日期时间 毫秒 -> "yyyy-MM-dd HH:mm:ss"
                SerializerFeature.WriteDateUseDateFormat,
                // 输出值为null的字段
                SerializerFeature.WriteMapNullValue,
                // 消除对同一对象循环引用
                SerializerFeature.DisableCircularReferenceDetect);
    }
}
