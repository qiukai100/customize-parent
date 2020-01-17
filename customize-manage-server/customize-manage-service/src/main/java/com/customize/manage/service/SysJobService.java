package com.customize.manage.service;

import com.customize.manage.core.BaseService;
import com.customize.manage.dto.SysJobDto;
import com.customize.manage.entity.sys.SysJob;
import com.github.pagehelper.Page;
import org.quartz.SchedulerException;

public interface SysJobService extends BaseService<SysJob, String> {

    Page<SysJob> queryJobPage(SysJob job, Integer pageNum, Integer pageSize);

    SysJob insertSelective(SysJob job) throws SchedulerException;

    SysJobDto findById(String id);
}
