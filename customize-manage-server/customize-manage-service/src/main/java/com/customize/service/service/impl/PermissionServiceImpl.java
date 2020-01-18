package com.customize.service.service.impl;

import com.customize.domain.entity.sys.Permission;
import com.customize.mybatis.mapper.SysPermissionMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, String> implements PermissionService {

    private final SysPermissionMapper sysPermissionMapper;

    @Autowired
    public PermissionServiceImpl(SysPermissionMapper mapper) {
        super(mapper);
        this.sysPermissionMapper = mapper;
    }
}
