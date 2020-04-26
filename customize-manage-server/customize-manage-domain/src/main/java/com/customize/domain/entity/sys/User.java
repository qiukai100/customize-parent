package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 用户表 sys_user
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_user")
@ApiModel("用户实体模型")
public class User extends BaseEntity {

    /** 用户ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("用户ID")
    private String pkUserId;

    /** 用户代码 */
    @Column(name = "user_code")
    @ApiModelProperty("用户代码")
    private String userCode;
        /** 用户名称 */
    @Column(name = "user_name")
    @ApiModelProperty("用户名称")
    private String userName;
        /** 账号 */
    @Column(name = "account")
    @ApiModelProperty("账号")
    private String account;
        /** 密码 */
    @Column(name = "password")
    @ApiModelProperty("密码")
    private String password;
        /** 组织ID */
    @Column(name = "fk_organization_id")
    @ApiModelProperty("组织ID")
    private String fkOrganizationId;
        /** 用户英文名称 */
    @Column(name = "user_name_en")
    @ApiModelProperty("用户英文名称")
    private String userNameEn;
        /** 手机号 */
    @Column(name = "phone_number")
    @ApiModelProperty("手机号")
    private String phoneNumber;
        /** 邮箱 */
    @Column(name = "email")
    @ApiModelProperty("邮箱")
    private String email;
        /** 性别 */
    @Column(name = "sex")
    @ApiModelProperty("性别")
    private String sex;
        /** 排序规则 */
    @Column(name = "sort")
    @ApiModelProperty("排序规则")
    private Long sort;
        /** 备注 */
    @Column(name = "remark")
    @ApiModelProperty("备注")
    private String remark;
    
}
