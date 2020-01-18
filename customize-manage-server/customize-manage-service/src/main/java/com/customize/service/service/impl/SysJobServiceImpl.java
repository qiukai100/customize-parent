package com.customize.service.service.impl;

import com.customize.common.utils.system.UUIDUtil;
import com.customize.quartz.constants.MisfireEnum;
import com.customize.service.core.BaseServiceImpl;
import com.customize.quartz.domain.TaskSource;
import com.customize.domain.dto.SysJobDto;
import com.customize.domain.entity.sys.SysJob;
import com.customize.domain.entity.sys.SysJobType;
import com.customize.mybatis.mapper.SysJobMapper;
import com.customize.mybatis.mapper.SysJobTypeMapper;
import com.customize.service.service.SysJobService;
import com.customize.quartz.utils.QuartzUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysJobServiceImpl extends BaseServiceImpl<SysJob, String> implements SysJobService {

    private final SysJobMapper sysJobMapper;
    private final SysJobTypeMapper sysJobTypeMapper;

    @Autowired
    public SysJobServiceImpl(SysJobMapper sysJobMapper, SysJobTypeMapper sysJobTypeMapper) {
        super(sysJobMapper);
        this.sysJobMapper = sysJobMapper;
        this.sysJobTypeMapper = sysJobTypeMapper;
    }

    @Override
    public Page<SysJob> queryJobPage(SysJob job, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> sysJobMapper.selectJobList(job));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysJob insertSelective(SysJob job) throws SchedulerException {
        job.setPkJobId(UUIDUtil.randomUUID());
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
