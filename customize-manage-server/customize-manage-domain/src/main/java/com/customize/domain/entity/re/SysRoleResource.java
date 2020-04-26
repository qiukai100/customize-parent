package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 关联角色资源表 re_sys_role_resource
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_role_resource")
@ApiModel("关联角色资源实体模型")
public class SysRoleResource extends BaseEntity {

    /** 关联角色资源ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("关联角色资源ID")
    private String pkReRoleResourceId;

    /** 角色ID */
    @Column(name = "fk_role_id")
    @ApiModelProperty("角色ID")
    private String fkRoleId;
        /** 资源ID */
    @Column(name = "fk_resource_id")
    @ApiModelProperty("资源ID")
    private String fkResourceId;
    
}
