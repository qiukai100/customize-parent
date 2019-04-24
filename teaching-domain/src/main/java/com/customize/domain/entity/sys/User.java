package com.customize.domain.entity.sys;

import com.customize.common.annotations.CustVerify;
import com.customize.common.constants.VerifyTypeEnum;
import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "sys_user")
@Table(appliesTo = "sys_user", comment = "系统用户")
public class User extends BaseEntity {

    @Id
    @CustVerify(minSize = 32, maxSize = 32)
    @Column(name = "pk_sys_user_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkSysUserId;

    @CustVerify(minSize = 6, maxSize = 8)
    @Column(name = "account", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '账号'")
    private String account;

    @CustVerify(minSize = 6, maxSize = 16)
    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '密码'")
    private String password;

    @CustVerify(maxSize = 8)
    @Column(name = "user_name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '真实姓名'")
    private String userName;

    @CustVerify(maxSize = 8)
    @Column(name = "nick_name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '昵称'")
    private String nickName;

    @CustVerify
    @Column(name = "salt", nullable = false, columnDefinition = "VARCHAR(32) COMMENT '密码加密盐值'")
    private String salt;

    @CustVerify(verifyType = VerifyTypeEnum.EMAIL)
    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '邮箱'")
    private String email;

    @CustVerify(verifyType = VerifyTypeEnum.MOBILE_PHONE)
    @Column(name = "phone", nullable = false, columnDefinition = "INTEGER(11) COMMENT '联系电话'")
    private Integer phone;

    @CustVerify
    @Column(name = "sex", nullable = false, columnDefinition = "TINYINT(1) COMMENT '性别 - 1：男，2：女'")
    private Integer sex;

    @Column(name = "lastLoginTime", columnDefinition = "DATETIME COMMENT '最后一次登录时间'")
    private Date lastLoginTime;

    @CustVerify
    @Column(name = "state", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0 COMMENT '用户状态 - 0：正常，1：禁用，2：锁定'")
    private Integer state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "sys_user_id")}, inverseJoinColumns = {@JoinColumn(name = "sys_role_id")})
    private List<Role> roleList;
}
