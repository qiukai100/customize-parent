package com.customize.domain.entity.sys;


import com.customize.common.annotations.CustVerify;
import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "sys_permission")
@Table(appliesTo = "sys_permission", comment = "系统权限")
public class Permission extends BaseEntity {

    @Id
    @CustVerify(minSize = 32, maxSize = 32)
    @Column(name = "pk_sys_permission_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkSysPermissionId;

    @CustVerify(maxSize = 8)
    @Column(name = "permission_name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '权限名称'")
    private String permissionName;

    @CustVerify
    @Column(name = "resource_type", nullable = false, columnDefinition = "enum('menu','button') COMMENT '资源类型 - menu：菜单，button：按钮'")
    private String resourceType;

    @Column(name = "url", columnDefinition = "VARCHAR(128) COMMENT '资源路径'")
    private String url;

    @CustVerify(maxSize = 16)
    @Column(name = "permission", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '权限'")
    private String permission;

    @CustVerify
    @Column(name = "parentId", nullable = false, columnDefinition = "VARCHAR(32) COMMENT '父编号'")
    private String parentId;

    @CustVerify
    @Column(name = "parentIds", nullable = false, columnDefinition = "VARCHAR(160) COMMENT '父编号集'")
    private String parentIds;

    @ManyToMany
    @JoinTable(name = "sys_role_permission", joinColumns = {@JoinColumn(name = "sys_permission_id")}, inverseJoinColumns = {@JoinColumn(name = "sys_role_id")})
    private List<Role> roleList;
}
