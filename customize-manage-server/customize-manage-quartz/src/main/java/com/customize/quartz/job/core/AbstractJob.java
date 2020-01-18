package com.customize.quartz.job.core;

import com.customize.common.utils.ExceptionUtils;
import com.customize.common.utils.StringUtils;
import com.customize.quartz.domain.TaskSource;
import com.customize.quartz.constants.ScheduleEnum;
import com.customize.quartz.domain.TaskLog;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 任务抽象类，可重写执行方法和执行前、执行后的方法
 */
@Slf4j
public abstract class AbstractJob implements Job {

    private static ThreadLocal<TaskLog> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) {
        TaskSource source = new TaskSource();
        BeanUtils.copyProperties(source, context.getMergedJobDataMap().get(ScheduleEnum.TASK_SOURCE_KEY.code()));
        before(context);
        Exception exception = null;
        try {
            assert !source.isEmpty() : "未找到任务源，无法执行任务！";
            doExecute(context, source);
        } catch (Exception e) {
            log.error("任务执行异常 - ：", e);
            exception = e;
        }
        after(context, source, exception);
    }

    protected void before(JobExecutionContext context) {
        final TaskLog taskLog = new TaskLog();
        taskLog.setStartTime(new Date());
        threadLocal.set(taskLog);
    }

    protected void after(JobExecutionContext context, TaskSource taskSource, Exception exception) {
        final TaskLog taskLog = threadLocal.get();
        threadLocal.remove();
        if (taskSource.isEmpty()) taskSource.setJobName("");
        taskLog.setTaskSource(taskSource).setEndTime(new Date());
        long runMsg = taskLog.getEndTime().getTime() - taskLog.getStartTime().getTime();
        taskLog.setJobMessage(taskLog.getTaskSource().getJobName() + " 总共耗时：" + runMsg + "毫秒");
        if (exception != null) {
            taskLog.setStatus(ScheduleEnum.TASK_RUN_FAIL.code());
            String errorMsg = StringUtils.substring(ExceptionUtils.getExceptionMessage(exception), 0, 2000);
            taskLog.setExceptionInfo(errorMsg);
        } else {
            taskLog.setStatus(ScheduleEnum.TASK_RUN_SUCCESS.code());
        }
        log.info("job execution end. log is {}", taskLog.toString());
    }

    protected abstract void doExecute(JobExecutionContext context, TaskSource source) throws Exception;
}
