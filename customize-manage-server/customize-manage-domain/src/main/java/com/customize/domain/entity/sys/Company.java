package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                                                                                                                                            import java.util.Date;
                                                                                                                                                                                                                                                                                                                                                            
import javax.persistence.*;

/**
 * 实体模型
 * 公司表 sys_company
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_company")
public class Company extends BaseEntity {

    /** 公司ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkCompanyId;

        /** 公司代码 */
    @Column(name = "company_code")
    private String companyCode;

            /** 公司名称 */
    @Column(name = "company_name")
    private String companyName;

            /** 公司英文名称 */
    @Column(name = "company_name_en")
    private String companyNameEn;

            /** 联系人 */
    @Column(name = "contact_person")
    private String contactPerson;

            /** 联系电话 */
    @Column(name = "contact_number")
    private String contactNumber;

            /** 联系邮箱 */
    @Column(name = "contact_email")
    private String contactEmail;

            /** 排序规则 */
    @Column(name = "sort")
    private Long sort;

                                
}
