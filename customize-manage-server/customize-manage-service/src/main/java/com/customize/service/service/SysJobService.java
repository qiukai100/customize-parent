package com.customize.service.service;

import com.customize.service.core.BaseService;
import com.customize.domain.dto.SysJobDto;
import com.customize.domain.entity.sys.SysJob;
import com.github.pagehelper.Page;
import org.quartz.SchedulerException;

public interface SysJobService extends BaseService<SysJob, String> {

    Page<SysJob> queryJobPage(SysJob job, Integer pageNum, Integer pageSize);

    SysJob insertSelective(SysJob job) throws SchedulerException;

    SysJobDto findById(String id);

    int deleteByPrimaryKey(String id) throws Exception;

    void resumeJob(String id) throws Exception;

    void pauseJob(String id) throws Exception;
}
