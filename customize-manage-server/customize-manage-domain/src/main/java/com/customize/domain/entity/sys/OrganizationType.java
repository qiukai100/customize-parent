package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 组织类型表 sys_organization_type
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_organization_type")
@ApiModel("组织类型实体模型")
public class OrganizationType extends BaseEntity {

    /** 组织类型ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("组织类型ID")
    private String pkOrganizationTypeId;

    /** 组织类型代码 */
    @Column(name = "organization_type_code")
    @ApiModelProperty("组织类型代码")
    private String organizationTypeCode;
        /** 组织类型名称 */
    @Column(name = "organization_type_name")
    @ApiModelProperty("组织类型名称")
    private String organizationTypeName;
        /** 组织类型英文名称 */
    @Column(name = "organization_type_name_en")
    @ApiModelProperty("组织类型英文名称")
    private String organizationTypeNameEn;
    
}
