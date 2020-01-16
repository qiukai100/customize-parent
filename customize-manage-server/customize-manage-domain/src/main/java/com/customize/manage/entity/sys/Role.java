package com.customize.manage.entity.sys;

import com.customize.common.annotations.CustVerify;
import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Role extends BaseEntity {

    @CustVerify(minSize = 32, maxSize = 32)
    private String pkSysRoleId;

    @CustVerify(maxSize = 8)
    private String roleCode;

    @CustVerify(maxSize = 16)
    private String description;

    @CustVerify
    private Integer state;

    private List<Permission> permissionList;

    private List<User> userList;

}
