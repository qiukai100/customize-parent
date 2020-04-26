package com.customize.service.service.sys.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.RoleDto;
import com.customize.domain.entity.sys.Role;
import com.customize.domain.vo.sys.RoleVo;
import com.customize.mybatis.mapper.sys.RoleMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.IRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 角色表 sys_role
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements IRoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        super(roleMapper);
        this.roleMapper = roleMapper;
    }

    @Override
    public Page<RoleDto> queryRolePage(RoleVo roleVo) {
        return PageHelper.startPage(roleVo.getPageNum(), roleVo.getPageSize()).doSelectPage(() -> roleMapper.queryRoleList(roleVo));
    }

    @Override
    public List<RoleDto> queryRoleList(RoleVo roleVo) {
        return roleMapper.queryRoleList(roleVo);
    }

    @Override
    public List<RoleDto> selectRoleList() {
        return roleMapper.selectRoleList(OptionEnum.YES.getVal());
    }

    @Override
    public RoleDto findById(String pkRoleId) {
        return roleMapper.findById(pkRoleId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkRoleId) {
        return roleMapper.removeByPrimaryKey(pkRoleId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeRoleBatch(String[] pkRoleIds) {
        return roleMapper.removeRoleBatch(pkRoleIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteRoleBatch(String[] pkRoleIds) {
        return roleMapper.deleteRoleBatch(pkRoleIds);
    }
}
