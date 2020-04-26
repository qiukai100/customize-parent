package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 关联角色组织表 re_sys_role_organization
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_role_organization")
@ApiModel("关联角色组织实体模型")
public class SysRoleOrganization extends BaseEntity {

    /** 关联角色组织ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("关联角色组织ID")
    private String pkReRoleOrganizationId;

    /** 角色ID */
    @Column(name = "fk_role_id")
    @ApiModelProperty("角色ID")
    private String fkRoleId;
        /** 组织ID */
    @Column(name = "fk_organization_id")
    @ApiModelProperty("组织ID")
    private String fkOrganizationId;
    
}
