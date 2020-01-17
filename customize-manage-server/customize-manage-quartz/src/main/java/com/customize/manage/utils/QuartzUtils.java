package com.customize.manage.utils;

import com.customize.common.exception.CustomException;
import com.customize.manage.constants.MisfireEnum;
import com.customize.manage.constants.ScheduleEnum;
import com.customize.manage.domain.TaskSource;
import com.customize.manage.job.ConcurrentJob;
import com.customize.manage.job.DisallowConcurrentJob;
import com.customize.manage.job.core.AbstractJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Scheduler 工具类（单例）
 */
@Slf4j
public class QuartzUtils {

    private static Scheduler scheduler;

    static {
        SchedulerFactory factory = new StdSchedulerFactory();
        try {
            scheduler = factory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.error("Scheduler 初始化失败！");
        }
    }

    /**
     * 创建任务
     *
     * @param source 任务源
     */
    public static void createJob(TaskSource source) throws SchedulerException {
        if (source.isEmpty()) throw new CustomException("缺少任务源信息！");
        if (CronUtils.isValid(source.getCronExpression())) throw new CustomException("cron表达式错误！");
        JobKey jobKey = getJobKey(source.getJobName(), source.getJobGroup());

        JobDetail jobDetail;
        boolean existsJob = scheduler.checkExists(jobKey);
        jobDetail = existsJob ? getJobDetail(jobKey) : JobBuilder.newJob(getQuartzJobClass(source.getConcurrent())).withIdentity(jobKey).build();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(source.getCronExpression());
        cronScheduleBuilder = handleCronScheduleMisfirePolicy(source.getMisfirePolicy(), cronScheduleBuilder);

        if (checkTriggerExists(source.getTriggerName(), source.getTriggerGroup())) throw new CustomException("触发器已存在");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(source.getTriggerName(), source.getTriggerGroup()))
                .withSchedule(cronScheduleBuilder).build();
        trigger.getJobDataMap().put(ScheduleEnum.TASK_SOURCE_KEY.code(), source);

        if (existsJob) scheduler.scheduleJob(trigger);
        else scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 立即执行一次无参任务（必须是已存在的任务）
     *
     * @param jobName 任务名
     * @param jobGroup 任务组
     */
    public static void triggerJob(String jobName, String jobGroup) throws SchedulerException {
        if (!checkJobExists(jobName, jobGroup)) throw new CustomException("任务不存在");
        scheduler.triggerJob(getJobKey(jobName, jobGroup));
    }

    /**
     * 立即执行一次有参任务（必须是已存在的任务）
     *
     * @param source 任务源
     */
    public static void triggerJob(TaskSource source) throws SchedulerException {
        if (!checkJobExists(source.getJobName(), source.getJobGroup())) throw new CustomException("任务不存在");
        JobDataMap dataMap = new JobDataMap();
        dataMap.put(ScheduleEnum.TASK_SOURCE_KEY.code(), source);
        scheduler.triggerJob(getJobKey(source.getJobName(), source.getJobGroup()), dataMap);
    }

    /**
     * 任务是否存在
     *
     * @param jobName 任务名
     * @param jobGroup 任务分组
     */
    private static boolean checkJobExists(String jobName, String jobGroup) throws SchedulerException {
        return scheduler.checkExists(getJobKey(jobName, jobGroup));
    }

    /**
     * 触发器是否存在
     *
     * @param triggerName 触发器名
     * @param triggerGroup 触发器组
     */
    private static boolean checkTriggerExists(String triggerName, String triggerGroup) throws SchedulerException {
        return scheduler.checkExists(getTriggerKey(triggerName, triggerGroup));
    }

    /**
     * 暂停任务
     *
     * @param jobName  任务名
     * @param jobGroup 任务组
     */
    public static void pauseJob(String jobName, String jobGroup) throws SchedulerException {
        scheduler.pauseJob(getJobKey(jobName, jobGroup));
    }

    /**
     * 暂停触发器
     *
     * @param triggerName  触发器名
     * @param triggerGroup 触发器组
     */
    public static void pauseTrigger(String triggerName, String triggerGroup) throws SchedulerException {
        scheduler.pauseTrigger(getTriggerKey(triggerName, triggerGroup));
    }

    /**
     * 恢复任务
     *
     * @param jobName  任务名
     * @param jobGroup 任务组
     */
    public static void resumeJob(String jobName, String jobGroup) throws SchedulerException {
        scheduler.resumeJob(getJobKey(jobName, jobGroup));
    }

    /**
     * 恢复触发器
     *
     * @param triggerName  触发器名
     * @param triggerGroup 触发器组
     */
    public static void resumeTrigger(String triggerName, String triggerGroup) throws SchedulerException {
        scheduler.resumeTrigger(getTriggerKey(triggerName, triggerGroup));
    }

    /**
     * 删除任务
     *
     * @param jobName  任务名
     * @param jobGroup 任务分组
     */
    public static boolean deleteJob(String jobName, String jobGroup) throws SchedulerException {
        return scheduler.deleteJob(getJobKey(jobName, jobGroup));
    }

    /**
     * 删除触发器
     *
     * @param triggerName  触发器名
     * @param triggerGroup 触发器分组
     */
    public static boolean deleteTrigger(String triggerName, String triggerGroup) throws SchedulerException {
        return scheduler.unscheduleJob(getTriggerKey(triggerName, triggerGroup));
    }


    /**
     * -------------------------------------------------------以下方法不需要公开-------------------------------------------------------------
     * /
     * <p>
     * /**
     * 获取定时任务类
     *
     * @param concurrent 是否允许并发执行
     * @return true 时执行ConcurrentJob，false 时执行DisallowConcurrentJob
     */
    private static Class<? extends AbstractJob> getQuartzJobClass(boolean concurrent) {
        return concurrent ? ConcurrentJob.class : DisallowConcurrentJob.class;
    }

    private static JobDetail getJobDetail(JobKey jobKey) throws SchedulerException {
        return scheduler.getJobDetail(jobKey);
    }

    private static TriggerKey getTriggerKey(String triggerName, String triggerGroup) {
        return TriggerKey.triggerKey(triggerName, triggerGroup);
    }

    private static JobKey getJobKey(String jobName, String jobGroup) {
        return JobKey.jobKey(jobName, jobGroup);
    }

    /**
     * 设置定时策略
     *
     * @param misfirePolicy       定时策略类型
     * @param cronScheduleBuilder 表达式生成规则
     */
    private static CronScheduleBuilder handleCronScheduleMisfirePolicy(String misfirePolicy, CronScheduleBuilder cronScheduleBuilder) {
        if (StringUtils.isBlank(misfirePolicy)) return cronScheduleBuilder;
        switch (MisfireEnum.valueOf(misfirePolicy)) {
            case MISFIRE_DEFAULT:
                return cronScheduleBuilder;
            case MISFIRE_IGNORE_MISFIRES:
                return cronScheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires();
            case MISFIRE_FIRE_AND_PROCEED:
                return cronScheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
            case MISFIRE_DO_NOTHING:
                return cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();
            default:
                throw new CustomException("未知的定时策略！");
        }
    }
}
