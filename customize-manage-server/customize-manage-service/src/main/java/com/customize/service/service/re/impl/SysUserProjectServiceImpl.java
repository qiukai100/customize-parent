package com.customize.service.service.re.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.re.SysUserProjectDto;
import com.customize.domain.entity.re.SysUserProject;
import com.customize.domain.vo.re.SysUserProjectVo;
import com.customize.mybatis.mapper.re.SysUserProjectMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.re.ISysUserProjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 关联用户项目表 re_sys_user_project
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@Service
public class SysUserProjectServiceImpl extends BaseServiceImpl<SysUserProject, String> implements ISysUserProjectService {

    private final SysUserProjectMapper sysUserProjectMapper;

    @Autowired
    public SysUserProjectServiceImpl(SysUserProjectMapper sysUserProjectMapper) {
        super(sysUserProjectMapper);
        this.sysUserProjectMapper = sysUserProjectMapper;
    }

    @Override
    public Page<SysUserProjectDto> querySysUserProjectPage(SysUserProjectVo sysUserProjectVo) {
        return PageHelper.startPage(sysUserProjectVo.getPageNum(), sysUserProjectVo.getPageSize()).doSelectPage(() -> sysUserProjectMapper.querySysUserProjectList(sysUserProjectVo));
    }

    @Override
    public List<SysUserProjectDto> querySysUserProjectList(SysUserProjectVo sysUserProjectVo) {
        return sysUserProjectMapper.querySysUserProjectList(sysUserProjectVo);
    }

    @Override
    public List<SysUserProjectDto> selectSysUserProjectList() {
        return sysUserProjectMapper.selectSysUserProjectList(OptionEnum.YES.getVal());
    }

    @Override
    public SysUserProjectDto findById(String pkReUserProjectId) {
        return sysUserProjectMapper.findById(pkReUserProjectId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkReUserProjectId) {
        return sysUserProjectMapper.removeByPrimaryKey(pkReUserProjectId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeSysUserProjectBatch(String[] pkReUserProjectIds) {
        return sysUserProjectMapper.removeSysUserProjectBatch(pkReUserProjectIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteSysUserProjectBatch(String[] pkReUserProjectIds) {
        return sysUserProjectMapper.deleteSysUserProjectBatch(pkReUserProjectIds);
    }
}
