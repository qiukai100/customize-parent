package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 岗位表 sys_post
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_post")
@ApiModel("岗位实体模型")
public class Post extends BaseEntity {

    /** 岗位ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("岗位ID")
    private String pkPostId;

    /** 岗位代码 */
    @Column(name = "post_code")
    @ApiModelProperty("岗位代码")
    private String postCode;
        /** 岗位名称 */
    @Column(name = "post_name")
    @ApiModelProperty("岗位名称")
    private String postName;
        /** 岗位英文名称 */
    @Column(name = "post_name_en")
    @ApiModelProperty("岗位英文名称")
    private String postNameEn;
        /** 排序规则 */
    @Column(name = "sort")
    @ApiModelProperty("排序规则")
    private Long sort;
        /** 备注 */
    @Column(name = "remark")
    @ApiModelProperty("备注")
    private String remark;
    
}
