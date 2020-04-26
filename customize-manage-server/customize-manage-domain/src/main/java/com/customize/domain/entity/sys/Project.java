package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 项目表 sys_project
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_project")
@ApiModel("项目实体模型")
public class Project extends BaseEntity {

    /** 项目ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("项目ID")
    private String pkProjectId;

    /** 项目代码 */
    @Column(name = "project_code")
    @ApiModelProperty("项目代码")
    private String projectCode;
        /** 项目名称 */
    @Column(name = "project_name")
    @ApiModelProperty("项目名称")
    private String projectName;
    
}
