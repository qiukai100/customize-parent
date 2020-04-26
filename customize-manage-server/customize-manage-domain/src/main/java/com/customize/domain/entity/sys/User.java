package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                                                                                                                                                                                                                                            import java.util.Date;
                                                                                                                                                                                                                                                                                                                                                                                                                                            
import javax.persistence.*;

/**
 * 实体模型
 * 用户表 sys_user
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_user")
public class User extends BaseEntity {

    /** 用户ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkUserId;

        /** 用户代码 */
    @Column(name = "user_code")
    private String userCode;

            /** 用户名称 */
    @Column(name = "user_name")
    private String userName;

            /** 账号 */
    @Column(name = "account")
    private String account;

            /** 密码 */
    @Column(name = "password")
    private String password;

            /** 组织ID */
    @Column(name = "fk_organization_id")
    private String fkOrganizationId;

            /** 用户英文名称 */
    @Column(name = "user_name_en")
    private String userNameEn;

            /** 手机号 */
    @Column(name = "phone_number")
    private String phoneNumber;

            /** 邮箱 */
    @Column(name = "email")
    private String email;

            /** 性别 */
    @Column(name = "sex")
    private String sex;

            /** 排序规则 */
    @Column(name = "sort")
    private Long sort;

            /** 备注 */
    @Column(name = "remark")
    private String remark;

                                
}
