package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 资源表 sys_resource
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_resource")
@ApiModel("资源实体模型")
public class Resource extends BaseEntity {

    /** 资源ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("资源ID")
    private String pkResourceId;

    /** 资源类型 */
    @Column(name = "resource_type")
    @ApiModelProperty("资源类型")
    private String resourceType;
        /** 资源名称 */
    @Column(name = "resource_name")
    @ApiModelProperty("资源名称")
    private String resourceName;
        /** 资源路径 */
    @Column(name = "resource_path")
    @ApiModelProperty("资源路径")
    private String resourcePath;
        /** 权限 */
    @Column(name = "permission")
    @ApiModelProperty("权限")
    private String permission;
        /** 项目ID */
    @Column(name = "fk_project_id")
    @ApiModelProperty("项目ID")
    private String fkProjectId;
        /** 上级资源ID */
    @Column(name = "sr_resource_id")
    @ApiModelProperty("上级资源ID")
    private String srResourceId;
        /** 上级资源ID路径 */
    @Column(name = "sr_resource_id_path")
    @ApiModelProperty("上级资源ID路径")
    private String srResourceIdPath;
        /** 是否顶级 - 0：否，1：是 */
    @Column(name = "is_top")
    @ApiModelProperty("是否顶级 - 0：否，1：是")
    private Integer isTop;
        /** 打开方式 - WINDOW:窗口,BOOKMARK:页签 */
    @Column(name = "open_type")
    @ApiModelProperty("打开方式 - WINDOW:窗口,BOOKMARK:页签")
    private String openType;
        /** 资源ICON */
    @Column(name = "resource_icon")
    @ApiModelProperty("资源ICON")
    private String resourceIcon;
        /** 排序规则 */
    @Column(name = "sort")
    @ApiModelProperty("排序规则")
    private Long sort;
    
}
