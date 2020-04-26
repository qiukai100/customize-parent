package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                                                                                                                                                                                            import java.util.Date;
                                                                                                                                                                                                                                                                                                                                                                                                    
import javax.persistence.*;

/**
 * 实体模型
 * 组织表 sys_organization
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_organization")
public class Organization extends BaseEntity {

    /** 组织ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkOrganizationId;

        /** 组织代码 */
    @Column(name = "organization_code")
    private String organizationCode;

            /** 组织名称 */
    @Column(name = "organization_name")
    private String organizationName;

            /** 组织英文名称 */
    @Column(name = "organization_name_en")
    private String organizationNameEn;

            /** 排序规则 */
    @Column(name = "sort")
    private Long sort;

            /** 公司ID */
    @Column(name = "fk_company_id")
    private String fkCompanyId;

            /** 组织类型ID */
    @Column(name = "fk_organization_type_id")
    private String fkOrganizationTypeId;

            /** 上级组织ID */
    @Column(name = "sr_organization_id")
    private String srOrganizationId;

            /** 上级组织ID路径 */
    @Column(name = "sr_organization_id_path")
    private String srOrganizationIdPath;

            /** 是否顶级 - 0：否，1：是 */
    @Column(name = "is_top")
    private Integer isTop;

                                
}
