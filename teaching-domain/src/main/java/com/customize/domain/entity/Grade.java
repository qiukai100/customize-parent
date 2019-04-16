package com.customize.domain.entity;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "tb_grade")
@Table(appliesTo = "tb_grade", comment = "年级")
public class Grade extends BaseEntity {

    @Id
    @Column(name = "pk_grade_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkGradeId;

    @Column(name = "grade_name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '年级名称'")
    private String gradeName;

    @Column(name = "level", nullable = false, unique = true, columnDefinition = "TINYINT(1) COMMENT '等级（等级越小，年级越小）'")
    private Integer level;

}
