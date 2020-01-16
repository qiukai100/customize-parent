package com.customize.manage.entity.sys;


import com.customize.common.annotations.CustVerify;
import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Permission extends BaseEntity {

    @CustVerify(minSize = 32, maxSize = 32)
    private String pkSysPermissionId;

    @CustVerify(maxSize = 8)
    private String permissionName;

    @CustVerify
    private String resourceType;

    private String url;

    @CustVerify(maxSize = 16)
    private String permission;

    @CustVerify
    private String parentId;

    @CustVerify
    private String parentIds;

    private List<Role> roleList;
}
