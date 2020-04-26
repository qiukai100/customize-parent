package com.customize.domain.entity.re;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

                                                                                                                                    import java.util.Date;
                                                                                                                                                                                                                                                        
import javax.persistence.*;

/**
 * 实体模型
 * 关联用户岗位表 re_sys_user_post
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "re_sys_user_post")
public class SysUserPost extends BaseEntity {

    /** 关联用户岗位ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkReUserPostId;

        /** 用户ID */
    @Column(name = "fk_user_id")
    private String fkUserId;

            /** 岗位ID */
    @Column(name = "fk_post_id")
    private String fkPostId;

                                
}
