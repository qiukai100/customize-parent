package com.customize.mybatis.mapper.re;

import com.customize.domain.dto.re.SysUserProjectDto;
import com.customize.domain.entity.re.SysUserProject;
import com.customize.domain.vo.re.SysUserProjectVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 关联用户项目表 re_sys_user_project
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface SysUserProjectMapper extends BaseMapper<SysUserProject> {

    /**
     * 条件查询关联用户项目
     */
    List<SysUserProjectDto> querySysUserProjectList(@Param("sysUserProjectVo") SysUserProjectVo sysUserProjectVo);

    /**
     * 查询所有关联用户项目
     */
    List<SysUserProjectDto> selectSysUserProjectList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询关联用户项目
     */
    SysUserProjectDto findById(@Param("pkReUserProjectId") String pkReUserProjectId, Integer isDelete);

    /**
     * 根据ID移除关联用户项目（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkReUserProjectId") String pkReUserProjectId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除关联用户项目（逻辑删除）
     */
    int removeSysUserProjectBatch(@Param("pkReUserProjectIds") String[] pkReUserProjectIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除关联用户项目（物理删除）
     */
    int deleteSysUserProjectBatch(@Param("pkReUserProjectIds") String[] pkReUserProjectIds);
}
