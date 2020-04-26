package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                                            import java.util.Date;
                                                                                                                                                                                                                                                                            
import javax.persistence.*;

/**
 * 实体模型
 * 组织类型表 sys_organization_type
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_organization_type")
public class OrganizationType extends BaseEntity {

    /** 组织类型ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkOrganizationTypeId;

        /** 组织类型代码 */
    @Column(name = "organization_type_code")
    private String organizationTypeCode;

            /** 组织类型名称 */
    @Column(name = "organization_type_name")
    private String organizationTypeName;

            /** 组织类型英文名称 */
    @Column(name = "organization_type_name_en")
    private String organizationTypeNameEn;

                                
}
