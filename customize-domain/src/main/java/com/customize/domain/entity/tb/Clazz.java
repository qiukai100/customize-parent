package com.customize.domain.entity.tb;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "tb_clazz")
@Table(appliesTo = "tb_clazz", comment = "班级")
public class Clazz extends BaseEntity {

    @Id
    @Column(name = "pk_clazz_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkClazzId;

    @Column(name = "clazz_name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '班级名称'")
    private String clazzName;

}
