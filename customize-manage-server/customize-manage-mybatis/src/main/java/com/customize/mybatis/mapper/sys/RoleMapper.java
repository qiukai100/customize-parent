package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.RoleDto;
import com.customize.domain.entity.sys.Role;
import com.customize.domain.vo.sys.RoleVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 角色表 sys_role
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 条件查询角色
     */
    List<RoleDto> queryRoleList(@Param("roleVo") RoleVo roleVo);

    /**
     * 查询所有角色
     */
    List<RoleDto> selectRoleList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询角色
     */
    RoleDto findById(@Param("pkRoleId") String pkRoleId, Integer isDelete);

    /**
     * 根据ID移除角色（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkRoleId") String pkRoleId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除角色（逻辑删除）
     */
    int removeRoleBatch(@Param("pkRoleIds") String[] pkRoleIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除角色（物理删除）
     */
    int deleteRoleBatch(@Param("pkRoleIds") String[] pkRoleIds);
}
