package com.customize.mybatis.mapper.re;

import com.customize.domain.dto.re.SysUserRoleDto;
import com.customize.domain.entity.re.SysUserRole;
import com.customize.domain.vo.re.SysUserRoleVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 关联用户角色表 re_sys_user_role
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 条件查询关联用户角色
     */
    List<SysUserRoleDto> querySysUserRoleList(@Param("sysUserRoleVo") SysUserRoleVo sysUserRoleVo);

    /**
     * 查询所有关联用户角色
     */
    List<SysUserRoleDto> selectSysUserRoleList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询关联用户角色
     */
    SysUserRoleDto findById(@Param("pkReUserRoleId") String pkReUserRoleId, Integer isDelete);

    /**
     * 根据ID移除关联用户角色（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkReUserRoleId") String pkReUserRoleId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除关联用户角色（逻辑删除）
     */
    int removeSysUserRoleBatch(@Param("pkReUserRoleIds") String[] pkReUserRoleIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除关联用户角色（物理删除）
     */
    int deleteSysUserRoleBatch(@Param("pkReUserRoleIds") String[] pkReUserRoleIds);
}
