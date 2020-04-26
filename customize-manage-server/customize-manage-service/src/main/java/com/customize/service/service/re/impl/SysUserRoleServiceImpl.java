package com.customize.service.service.re.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.re.SysUserRoleDto;
import com.customize.domain.entity.re.SysUserRole;
import com.customize.domain.vo.re.SysUserRoleVo;
import com.customize.mybatis.mapper.re.SysUserRoleMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.re.ISysUserRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 关联用户角色表 re_sys_user_role
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole, String> implements ISysUserRoleService {

    private final SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    public SysUserRoleServiceImpl(SysUserRoleMapper sysUserRoleMapper) {
        super(sysUserRoleMapper);
        this.sysUserRoleMapper = sysUserRoleMapper;
    }

    @Override
    public Page<SysUserRoleDto> querySysUserRolePage(SysUserRoleVo sysUserRoleVo) {
        return PageHelper.startPage(sysUserRoleVo.getPageNum(), sysUserRoleVo.getPageSize()).doSelectPage(() -> sysUserRoleMapper.querySysUserRoleList(sysUserRoleVo));
    }

    @Override
    public List<SysUserRoleDto> querySysUserRoleList(SysUserRoleVo sysUserRoleVo) {
        return sysUserRoleMapper.querySysUserRoleList(sysUserRoleVo);
    }

    @Override
    public List<SysUserRoleDto> selectSysUserRoleList() {
        return sysUserRoleMapper.selectSysUserRoleList(OptionEnum.YES.getVal());
    }

    @Override
    public SysUserRoleDto findById(String pkReUserRoleId) {
        return sysUserRoleMapper.findById(pkReUserRoleId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkReUserRoleId) {
        return sysUserRoleMapper.removeByPrimaryKey(pkReUserRoleId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeSysUserRoleBatch(String[] pkReUserRoleIds) {
        return sysUserRoleMapper.removeSysUserRoleBatch(pkReUserRoleIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteSysUserRoleBatch(String[] pkReUserRoleIds) {
        return sysUserRoleMapper.deleteSysUserRoleBatch(pkReUserRoleIds);
    }
}
