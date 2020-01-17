package com.customize.manage.utils;

import org.quartz.CronExpression;

import java.text.ParseException;
import java.util.Date;

/**
 * cron表达式工具类
 */
public class CronUtils {

    /**
     * 验证表达式的有效性
     *
     * @param cronExpression 表达式
     * @return true 为有效
     */
    public static boolean isValid(String cronExpression) {
        return CronExpression.isValidExpression(cronExpression);
    }

    /**
     * 获取该表达式下一次执行的时间
     *
     * @param cronExpression 表达式
     * @return 下一次执行时间
     */
    public static Date getNextExecution(String cronExpression) {
        try {
            CronExpression cron = new CronExpression(cronExpression);
            return cron.getNextValidTimeAfter(new Date(System.currentTimeMillis()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
