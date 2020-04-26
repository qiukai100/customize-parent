package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 公司表 sys_company
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_company")
@ApiModel("公司实体模型")
public class Company extends BaseEntity {

    /** 公司ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("公司ID")
    private String pkCompanyId;

    /** 公司代码 */
    @Column(name = "company_code")
    @ApiModelProperty("公司代码")
    private String companyCode;
        /** 公司名称 */
    @Column(name = "company_name")
    @ApiModelProperty("公司名称")
    private String companyName;
        /** 公司英文名称 */
    @Column(name = "company_name_en")
    @ApiModelProperty("公司英文名称")
    private String companyNameEn;
        /** 联系人 */
    @Column(name = "contact_person")
    @ApiModelProperty("联系人")
    private String contactPerson;
        /** 联系电话 */
    @Column(name = "contact_number")
    @ApiModelProperty("联系电话")
    private String contactNumber;
        /** 联系邮箱 */
    @Column(name = "contact_email")
    @ApiModelProperty("联系邮箱")
    private String contactEmail;
        /** 排序规则 */
    @Column(name = "sort")
    @ApiModelProperty("排序规则")
    private Long sort;
    
}
