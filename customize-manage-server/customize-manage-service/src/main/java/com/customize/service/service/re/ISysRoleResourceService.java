package com.customize.service.service.re;

import com.customize.domain.dto.re.SysRoleResourceDto;
import com.customize.domain.entity.re.SysRoleResource;
import com.customize.domain.vo.re.SysRoleResourceVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 关联角色资源表 re_sys_role_resource
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface ISysRoleResourceService extends BaseService<SysRoleResource, String> {

    /**
     * 分页条件查询关联角色资源
     */
    Page<SysRoleResourceDto> querySysRoleResourcePage(SysRoleResourceVo sysRoleResourceVo);

    /**
     * 条件查询关联角色资源
     */
    List<SysRoleResourceDto> querySysRoleResourceList(SysRoleResourceVo sysRoleResourceVo);

    /**
     * 查询所有关联角色资源
     */
    List<SysRoleResourceDto> selectSysRoleResourceList();

    /**
     * 根据ID查询关联角色资源
     */
	SysRoleResourceDto findById(String pkReRoleResourceId);

    /**
     * 根据ID移除关联角色资源（逻辑删除）
     */
    int removeByPrimaryKey(String pkReRoleResourceId);

    /**
     * 批量移除关联角色资源（逻辑删除）
     */
    int removeSysRoleResourceBatch(String[] pkReRoleResourceIds);

    /**
     * 批量删除关联角色资源（物理删除）
     */
    int deleteSysRoleResourceBatch(String[] pkReRoleResourceIds);
}
