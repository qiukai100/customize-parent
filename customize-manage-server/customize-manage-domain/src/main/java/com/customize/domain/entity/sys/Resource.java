package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                                                                                                                                                                                                                                            import java.util.Date;
                                                                                                                                                                                                                                                                                                                                                                                                                                            
import javax.persistence.*;

/**
 * 实体模型
 * 资源表 sys_resource
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_resource")
public class Resource extends BaseEntity {

    /** 资源ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkResourceId;

        /** 资源类型 */
    @Column(name = "resource_type")
    private String resourceType;

            /** 资源名称 */
    @Column(name = "resource_name")
    private String resourceName;

            /** 资源路径 */
    @Column(name = "resource_path")
    private String resourcePath;

            /** 权限 */
    @Column(name = "permission")
    private String permission;

            /** 项目ID */
    @Column(name = "fk_project_id")
    private String fkProjectId;

            /** 上级资源ID */
    @Column(name = "sr_resource_id")
    private String srResourceId;

            /** 上级资源ID路径 */
    @Column(name = "sr_resource_id_path")
    private String srResourceIdPath;

            /** 是否顶级 - 0：否，1：是 */
    @Column(name = "is_top")
    private Integer isTop;

            /** 打开方式 - WINDOW:窗口,BOOKMARK:页签 */
    @Column(name = "open_type")
    private String openType;

            /** 资源ICON */
    @Column(name = "resource_icon")
    private String resourceIcon;

            /** 排序规则 */
    @Column(name = "sort")
    private Long sort;

                                
}
