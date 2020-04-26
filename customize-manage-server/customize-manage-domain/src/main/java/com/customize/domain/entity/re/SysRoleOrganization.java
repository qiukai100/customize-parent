package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                    import java.util.Date;
                                                                                                                                                                                                                                                        
import javax.persistence.*;

/**
 * 实体模型
 * 关联角色组织表 re_sys_role_organization
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_role_organization")
public class SysRoleOrganization extends BaseEntity {

    /** 关联角色组织ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkReRoleOrganizationId;

        /** 角色ID */
    @Column(name = "fk_role_id")
    private String fkRoleId;

            /** 组织ID */
    @Column(name = "fk_organization_id")
    private String fkOrganizationId;

                                
}
