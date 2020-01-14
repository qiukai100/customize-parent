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
@Entity(name = "sys_role")
@Table(appliesTo = "sys_role", comment = "系统角色")
public class Role extends BaseEntity {

    @Id
    @CustVerify(minSize = 32, maxSize = 32)
    @Column(name = "pk_sys_role_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkSysRoleId;

    @CustVerify(maxSize = 8)
    @Column(name = "role_code", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '角色编码'")
    private String roleCode;

    @CustVerify(maxSize = 16)
    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '角色描述'")
    private String description;

    @CustVerify
    @Column(name = "state", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0 COMMENT '角色状态 - 0：正常，1：禁用'")
    private Integer state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_permission", joinColumns = {@JoinColumn(name = "sys_role_id")}, inverseJoinColumns = {@JoinColumn(name = "sys_permission_id")})
    private List<Permission> permissionList;

    @ManyToMany
    @JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "sys_role_id")}, inverseJoinColumns = {@JoinColumn(name = "sys_user_id")})
    private List<User> userList;

}
