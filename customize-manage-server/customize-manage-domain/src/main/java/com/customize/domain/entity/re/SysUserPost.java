package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * 关联用户岗位表 re_sys_user_post
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_user_post")
@ApiModel("关联用户岗位实体模型")
public class SysUserPost extends BaseEntity {

    /** 关联用户岗位ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @ApiModelProperty("关联用户岗位ID")
    private String pkReUserPostId;

    /** 用户ID */
    @Column(name = "fk_user_id")
    @ApiModelProperty("用户ID")
    private String fkUserId;
        /** 岗位ID */
    @Column(name = "fk_post_id")
    @ApiModelProperty("岗位ID")
    private String fkPostId;
    
}
