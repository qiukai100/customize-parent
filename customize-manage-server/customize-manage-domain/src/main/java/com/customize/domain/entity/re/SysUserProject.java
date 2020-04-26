package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 关联用户项目表 re_sys_user_project
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_user_project")
@ApiModel("关联用户项目实体模型")
public class SysUserProject extends BaseEntity {

    /** 关联用户项目ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("关联用户项目ID")
    private String pkReUserProjectId;

    /** 用户ID */
    @Column(name = "fk_user_id")
    @ApiModelProperty("用户ID")
    private String fkUserId;
        /** 项目ID */
    @Column(name = "fk_project_id")
    @ApiModelProperty("项目ID")
    private String fkProjectId;
    
}
