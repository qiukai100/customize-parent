package com.customize.service.service.impl;

import com.customize.domain.entity.sys.Permission;
import com.customize.jpa.repository.PermissionRepository;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, String> implements PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        super(permissionRepository);
        this.permissionRepository = permissionRepository;
    }


}
