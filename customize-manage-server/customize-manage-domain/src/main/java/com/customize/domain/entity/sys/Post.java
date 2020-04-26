package com.customize.domain.entity.sys;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                                                                                            import java.util.Date;
                                                                                                                                                                                                                                                                                                                    
import javax.persistence.*;

/**
 * 实体模型
 * 岗位表 sys_post
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_post")
public class Post extends BaseEntity {

    /** 岗位ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkPostId;

        /** 岗位代码 */
    @Column(name = "post_code")
    private String postCode;

            /** 岗位名称 */
    @Column(name = "post_name")
    private String postName;

            /** 岗位英文名称 */
    @Column(name = "post_name_en")
    private String postNameEn;

            /** 排序规则 */
    @Column(name = "sort")
    private Long sort;

            /** 备注 */
    @Column(name = "remark")
    private String remark;

                                
}
