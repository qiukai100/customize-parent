package com.customize.service.service.sys;

import com.customize.domain.dto.sys.RoleDto;
import com.customize.domain.entity.sys.Role;
import com.customize.domain.vo.sys.RoleVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 角色表 sys_role
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface IRoleService extends BaseService<Role, String> {

    /**
     * 分页条件查询角色
     */
    Page<RoleDto> queryRolePage(RoleVo roleVo);

    /**
     * 条件查询角色
     */
    List<RoleDto> queryRoleList(RoleVo roleVo);

    /**
     * 查询所有角色
     */
    List<RoleDto> selectRoleList();

    /**
     * 根据ID查询角色
     */
	RoleDto findById(String pkRoleId);

    /**
     * 根据ID移除角色（逻辑删除）
     */
    int removeByPrimaryKey(String pkRoleId);

    /**
     * 批量移除角色（逻辑删除）
     */
    int removeRoleBatch(String[] pkRoleIds);

    /**
     * 批量删除角色（物理删除）
     */
    int deleteRoleBatch(String[] pkRoleIds);
}
