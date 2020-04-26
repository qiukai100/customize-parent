package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 组织表 sys_organization
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_organization")
@ApiModel("组织实体模型")
public class Organization extends BaseEntity {

    /** 组织ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("组织ID")
    private String pkOrganizationId;

    /** 组织代码 */
    @Column(name = "organization_code")
    @ApiModelProperty("组织代码")
    private String organizationCode;
        /** 组织名称 */
    @Column(name = "organization_name")
    @ApiModelProperty("组织名称")
    private String organizationName;
        /** 组织英文名称 */
    @Column(name = "organization_name_en")
    @ApiModelProperty("组织英文名称")
    private String organizationNameEn;
        /** 排序规则 */
    @Column(name = "sort")
    @ApiModelProperty("排序规则")
    private Long sort;
        /** 公司ID */
    @Column(name = "fk_company_id")
    @ApiModelProperty("公司ID")
    private String fkCompanyId;
        /** 组织类型ID */
    @Column(name = "fk_organization_type_id")
    @ApiModelProperty("组织类型ID")
    private String fkOrganizationTypeId;
        /** 上级组织ID */
    @Column(name = "sr_organization_id")
    @ApiModelProperty("上级组织ID")
    private String srOrganizationId;
        /** 上级组织ID路径 */
    @Column(name = "sr_organization_id_path")
    @ApiModelProperty("上级组织ID路径")
    private String srOrganizationIdPath;
        /** 是否顶级 - 0：否，1：是 */
    @Column(name = "is_top")
    @ApiModelProperty("是否顶级 - 0：否，1：是")
    private Integer isTop;
    
}
