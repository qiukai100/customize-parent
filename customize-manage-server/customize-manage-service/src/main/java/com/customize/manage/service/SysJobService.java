package com.customize.manage.service;

import com.customize.manage.core.BaseService;
import com.customize.manage.dto.SysJobDto;
import com.customize.manage.entity.sys.SysJob;
import com.github.pagehelper.Page;

public interface SysJobService extends BaseService<SysJob, String> {

    Page<SysJob> queryJobPage(SysJob job, Integer pageNum, Integer pageSize);

    SysJob insertSelective(SysJob job);

    SysJobDto findById(String id);
}
