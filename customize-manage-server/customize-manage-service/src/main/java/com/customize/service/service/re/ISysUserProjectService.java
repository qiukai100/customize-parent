package com.customize.service.service.re;

import com.customize.domain.dto.re.SysUserProjectDto;
import com.customize.domain.entity.re.SysUserProject;
import com.customize.domain.vo.re.SysUserProjectVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 关联用户项目表 re_sys_user_project
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface ISysUserProjectService extends BaseService<SysUserProject, String> {

    /**
     * 分页条件查询关联用户项目
     */
    Page<SysUserProjectDto> querySysUserProjectPage(SysUserProjectVo sysUserProjectVo);

    /**
     * 条件查询关联用户项目
     */
    List<SysUserProjectDto> querySysUserProjectList(SysUserProjectVo sysUserProjectVo);

    /**
     * 查询所有关联用户项目
     */
    List<SysUserProjectDto> selectSysUserProjectList();

    /**
     * 根据ID查询关联用户项目
     */
	SysUserProjectDto findById(String pkReUserProjectId);

    /**
     * 根据ID移除关联用户项目（逻辑删除）
     */
    int removeByPrimaryKey(String pkReUserProjectId);

    /**
     * 批量移除关联用户项目（逻辑删除）
     */
    int removeSysUserProjectBatch(String[] pkReUserProjectIds);

    /**
     * 批量删除关联用户项目（物理删除）
     */
    int deleteSysUserProjectBatch(String[] pkReUserProjectIds);
}
