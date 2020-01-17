package com.customize.manage.service.impl;

import com.customize.manage.constants.MisfireEnum;
import com.customize.manage.core.BaseServiceImpl;
import com.customize.manage.domain.TaskSource;
import com.customize.manage.dto.SysJobDto;
import com.customize.manage.entity.sys.SysJob;
import com.customize.manage.entity.sys.SysJobType;
import com.customize.manage.mapper.SysJobMapper;
import com.customize.manage.mapper.SysJobTypeMapper;
import com.customize.manage.service.SysJobService;
import com.customize.manage.utils.QuartzUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysJobServiceImpl extends BaseServiceImpl<SysJob, String> implements SysJobService {

    @Resource
    private SysJobMapper sysJobMapper;
    @Resource
    private SysJobTypeMapper sysJobTypeMapper;

    @Override
    public Page<SysJob> queryJobPage(SysJob job, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> sysJobMapper.selectJobList(job));
    }

    @Override
    public SysJob insertSelective(SysJob job) throws SchedulerException {
        sysJobMapper.insertSelective(job);
        TaskSource source = buildTaskSource(job);
        QuartzUtils.createJob(source);
        return job;
    }

    @Override
    public SysJobDto findById(String id) {
        return sysJobMapper.findById(id);
    }

    private TaskSource buildTaskSource(SysJob job) {
        SysJobType jobType = sysJobTypeMapper.selectByPrimaryKey(job.getJobTypeId());
        TaskSource source = new TaskSource();
        source.setJobName(job.getJobName());
        source.setJobGroup("系统任务组");
        source.setTriggerName(jobType.getJobTypeName());
        source.setTriggerGroup("系统任务组");
        source.setConcurrent(false);
        source.setMisfirePolicy(MisfireEnum.MISFIRE_DEFAULT.name());
        source.setCronExpression(job.getCronExpressions());
        source.setBeanName(jobType.getManagerClass());
        source.setMethodName(jobType.getFunction());
        source.setMethodParams(null);
        source.setKeys(null);
        return source;
    }
}
