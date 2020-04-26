package com.customize.service.service.sys;

import com.customize.domain.dto.sys.ProjectDto;
import com.customize.domain.entity.sys.Project;
import com.customize.domain.vo.sys.ProjectVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 项目表 sys_project
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface IProjectService extends BaseService<Project, String> {

    /**
     * 分页条件查询项目
     */
    Page<ProjectDto> queryProjectPage(ProjectVo projectVo);

    /**
     * 条件查询项目
     */
    List<ProjectDto> queryProjectList(ProjectVo projectVo);

    /**
     * 查询所有项目
     */
    List<ProjectDto> selectProjectList();

    /**
     * 根据ID查询项目
     */
	ProjectDto findById(String pkProjectId);

    /**
     * 根据ID移除项目（逻辑删除）
     */
    int removeByPrimaryKey(String pkProjectId);

    /**
     * 批量移除项目（逻辑删除）
     */
    int removeProjectBatch(String[] pkProjectIds);

    /**
     * 批量删除项目（物理删除）
     */
    int deleteProjectBatch(String[] pkProjectIds);
}
