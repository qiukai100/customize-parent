package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 关联用户角色表 re_sys_user_role
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_user_role")
@ApiModel("关联用户角色实体模型")
public class SysUserRole extends BaseEntity {

    /** 关联用户角色ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("关联用户角色ID")
    private String pkReUserRoleId;

    /** 用户ID */
    @Column(name = "fk_user_id")
    @ApiModelProperty("用户ID")
    private String fkUserId;
        /** 角色ID */
    @Column(name = "fk_role_id")
    @ApiModelProperty("角色ID")
    private String fkRoleId;
    
}
