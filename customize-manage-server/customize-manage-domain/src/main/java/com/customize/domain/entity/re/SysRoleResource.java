package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                    import java.util.Date;
                                                                                                                                                                                                                                                        
import javax.persistence.*;

/**
 * 实体模型
 * 关联角色资源表 re_sys_role_resource
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_role_resource")
public class SysRoleResource extends BaseEntity {

    /** 关联角色资源ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkReRoleResourceId;

        /** 角色ID */
    @Column(name = "fk_role_id")
    private String fkRoleId;

            /** 资源ID */
    @Column(name = "fk_resource_id")
    private String fkResourceId;

                                
}
