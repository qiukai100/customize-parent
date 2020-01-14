package com.customize.domain.entity.tb;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity(name = "tb_school")
@Table(appliesTo = "tb_school", comment = "学校")
public class School extends BaseEntity {

    @Id
    @Column(name = "pk_school_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkSchoolId;

    @Column(name = "school_name", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '学校名称'")
    private String schoolName;

    @Column(name = "address", nullable = false, columnDefinition = "VARCHAR(128) COMMENT '学校地址'")
    private String address;

    @Column(name = "pic_url", nullable = false, columnDefinition = "VARCHAR(128) COMMENT '照片路径'")
    private String picUrl;

    @Column(name = "build_date", nullable = false, columnDefinition = "DATETIME COMMENT '建校日期'")
    private Date buildDate;

    @Column(name = "charge_person_name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '负责人姓名'")
    private String chargePersonName;

    @Column(name = "charge_person_phone", nullable = false, columnDefinition = "INTEGER(11) COMMENT '负责人手机号'")
    private Integer chargePersonPhone;
}
