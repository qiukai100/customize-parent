package com.customize.service.service.re;

import com.customize.domain.dto.re.SysUserRoleDto;
import com.customize.domain.entity.re.SysUserRole;
import com.customize.domain.vo.re.SysUserRoleVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 关联用户角色表 re_sys_user_role
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface ISysUserRoleService extends BaseService<SysUserRole, String> {

    /**
     * 分页条件查询关联用户角色
     */
    Page<SysUserRoleDto> querySysUserRolePage(SysUserRoleVo sysUserRoleVo);

    /**
     * 条件查询关联用户角色
     */
    List<SysUserRoleDto> querySysUserRoleList(SysUserRoleVo sysUserRoleVo);

    /**
     * 查询所有关联用户角色
     */
    List<SysUserRoleDto> selectSysUserRoleList();

    /**
     * 根据ID查询关联用户角色
     */
	SysUserRoleDto findById(String pkReUserRoleId);

    /**
     * 根据ID移除关联用户角色（逻辑删除）
     */
    int removeByPrimaryKey(String pkReUserRoleId);

    /**
     * 批量移除关联用户角色（逻辑删除）
     */
    int removeSysUserRoleBatch(String[] pkReUserRoleIds);

    /**
     * 批量删除关联用户角色（物理删除）
     */
    int deleteSysUserRoleBatch(String[] pkReUserRoleIds);
}
