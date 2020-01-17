package com.customize.manage.job;

import com.customize.manage.domain.TaskSource;
import com.customize.manage.job.core.AbstractJob;
import com.customize.manage.utils.JobInvokeUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/**
 * 不允许并发执行的JOB类
 */
@DisallowConcurrentExecution
public class DisallowConcurrentJob extends AbstractJob {

    @Override
    protected void doExecute(JobExecutionContext context, TaskSource source) throws Exception {
        JobInvokeUtils.invokeMethod(source);
    }
}
