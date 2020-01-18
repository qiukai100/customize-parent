package com.customize.quartz.job;

import com.customize.quartz.domain.TaskSource;
import com.customize.quartz.job.core.AbstractJob;
import com.customize.quartz.utils.JobInvokeUtils;
import org.quartz.JobExecutionContext;

/**
 * 允许并发执行的JOB类
 */
public class ConcurrentJob extends AbstractJob {

    @Override
    protected void doExecute(JobExecutionContext context, TaskSource source) throws Exception {
        JobInvokeUtils.invokeMethod(source);
    }
}
