package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 角色表 sys_role
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_role")
@ApiModel("角色实体模型")
public class Role extends BaseEntity {

    /** 角色ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("角色ID")
    private String pkRoleId;

    /** 角色代码 */
    @Column(name = "role_code")
    @ApiModelProperty("角色代码")
    private String roleCode;
        /** 角色名称 */
    @Column(name = "role_name")
    @ApiModelProperty("角色名称")
    private String roleName;
        /** 角色英文名称 */
    @Column(name = "role_name_en")
    @ApiModelProperty("角色英文名称")
    private String roleNameEn;
        /** 排序规则 */
    @Column(name = "sort")
    @ApiModelProperty("排序规则")
    private Long sort;
        /** 备注 */
    @Column(name = "remark")
    @ApiModelProperty("备注")
    private String remark;
        /** 数据权限类型 */
    @Column(name = "data_auth_type")
    @ApiModelProperty("数据权限类型")
    private String dataAuthType;
        /** 资源权限类型 */
    @Column(name = "resource_auth_type")
    @ApiModelProperty("资源权限类型")
    private String resourceAuthType;
    
}
