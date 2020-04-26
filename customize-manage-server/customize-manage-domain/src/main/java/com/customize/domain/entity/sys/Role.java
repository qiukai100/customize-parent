package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                                                                                                                                            import java.util.Date;
                                                                                                                                                                                                                                                                                                                                                            
import javax.persistence.*;

/**
 * 实体模型
 * 角色表 sys_role
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_role")
public class Role extends BaseEntity {

    /** 角色ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkRoleId;

        /** 角色代码 */
    @Column(name = "role_code")
    private String roleCode;

            /** 角色名称 */
    @Column(name = "role_name")
    private String roleName;

            /** 角色英文名称 */
    @Column(name = "role_name_en")
    private String roleNameEn;

            /** 排序规则 */
    @Column(name = "sort")
    private Long sort;

            /** 备注 */
    @Column(name = "remark")
    private String remark;

            /** 数据权限类型 */
    @Column(name = "data_auth_type")
    private String dataAuthType;

            /** 资源权限类型 */
    @Column(name = "resource_auth_type")
    private String resourceAuthType;

                                
}
