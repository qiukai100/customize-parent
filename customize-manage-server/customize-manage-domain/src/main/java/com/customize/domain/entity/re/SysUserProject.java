package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                    import java.util.Date;
                                                                                                                                                                                                                                                        
import javax.persistence.*;

/**
 * 实体模型
 * 关联用户项目表 re_sys_user_project
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_user_project")
public class SysUserProject extends BaseEntity {

    /** 关联用户项目ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkReUserProjectId;

        /** 用户ID */
    @Column(name = "fk_user_id")
    private String fkUserId;

            /** 项目ID */
    @Column(name = "fk_project_id")
    private String fkProjectId;

                                
}
