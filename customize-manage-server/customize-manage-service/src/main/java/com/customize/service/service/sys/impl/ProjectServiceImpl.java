package com.customize.service.service.sys.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.ProjectDto;
import com.customize.domain.entity.sys.Project;
import com.customize.domain.vo.sys.ProjectVo;
import com.customize.mybatis.mapper.sys.ProjectMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.IProjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 项目表 sys_project
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project, String> implements IProjectService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        super(projectMapper);
        this.projectMapper = projectMapper;
    }

    @Override
    public Page<ProjectDto> queryProjectPage(ProjectVo projectVo) {
        return PageHelper.startPage(projectVo.getPageNum(), projectVo.getPageSize()).doSelectPage(() -> projectMapper.queryProjectList(projectVo));
    }

    @Override
    public List<ProjectDto> queryProjectList(ProjectVo projectVo) {
        return projectMapper.queryProjectList(projectVo);
    }

    @Override
    public List<ProjectDto> selectProjectList() {
        return projectMapper.selectProjectList(OptionEnum.YES.getVal());
    }

    @Override
    public ProjectDto findById(String pkProjectId) {
        return projectMapper.findById(pkProjectId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkProjectId) {
        return projectMapper.removeByPrimaryKey(pkProjectId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeProjectBatch(String[] pkProjectIds) {
        return projectMapper.removeProjectBatch(pkProjectIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteProjectBatch(String[] pkProjectIds) {
        return projectMapper.deleteProjectBatch(pkProjectIds);
    }
}
