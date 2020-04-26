package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                    import java.util.Date;
                                                                                                                                                                                                                                                        
import javax.persistence.*;

/**
 * 实体模型
 * 关联用户角色表 re_sys_user_role
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_user_role")
public class SysUserRole extends BaseEntity {

    /** 关联用户角色ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkReUserRoleId;

        /** 用户ID */
    @Column(name = "fk_user_id")
    private String fkUserId;

            /** 角色ID */
    @Column(name = "fk_role_id")
    private String fkRoleId;

                                
}
