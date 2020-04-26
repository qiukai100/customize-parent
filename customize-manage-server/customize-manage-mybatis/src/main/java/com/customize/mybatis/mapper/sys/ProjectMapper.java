package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.ProjectDto;
import com.customize.domain.entity.sys.Project;
import com.customize.domain.vo.sys.ProjectVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 项目表 sys_project
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface ProjectMapper extends BaseMapper<Project> {

    /**
     * 条件查询项目
     */
    List<ProjectDto> queryProjectList(@Param("projectVo") ProjectVo projectVo);

    /**
     * 查询所有项目
     */
    List<ProjectDto> selectProjectList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询项目
     */
    ProjectDto findById(@Param("pkProjectId") String pkProjectId, Integer isDelete);

    /**
     * 根据ID移除项目（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkProjectId") String pkProjectId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除项目（逻辑删除）
     */
    int removeProjectBatch(@Param("pkProjectIds") String[] pkProjectIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除项目（物理删除）
     */
    int deleteProjectBatch(@Param("pkProjectIds") String[] pkProjectIds);
}
