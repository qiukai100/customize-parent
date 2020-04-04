package com.customize.domain.entity.tb;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 实体模型
 * 班级表 tb_clazz
 *
 * @author qiukai
 * @date 2020-04-02
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "tb_clazz")
public class Clazz extends BaseEntity {

    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkClazzId;

    /** 班级名称 */
    @Column(name = "clazz_name")
    private String clazzName;

}
