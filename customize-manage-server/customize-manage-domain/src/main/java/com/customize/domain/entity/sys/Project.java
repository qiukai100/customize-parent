package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                    import java.util.Date;
                                                                                                                                                                                                                                                        
import javax.persistence.*;

/**
 * 实体模型
 * 项目表 sys_project
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_project")
public class Project extends BaseEntity {

    /** 项目ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkProjectId;

        /** 项目代码 */
    @Column(name = "project_code")
    private String projectCode;

            /** 项目名称 */
    @Column(name = "project_name")
    private String projectName;

                                
}
