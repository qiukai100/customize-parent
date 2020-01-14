package com.customize.domain.entity.tb;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 老师表
 */
@Getter
@Setter
@Entity(name = "tb_teacher")
@Table(appliesTo = "tb_teacher", comment = "老师")
public class Teacher extends BaseEntity {

    @Id
    @Column(name = "pk_teacher_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkTeacherId;

    @Column(name = "teacher_no", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '编号（yyMMddHHmmssSSS1）'")
    private String teacherNo;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '姓名'")
    private String name;

    @Column(name = "sex", nullable = false, columnDefinition = "TINYINT(1) COMMENT '性别 - 1：男，2：女'")
    private Integer sex;

    @Column(name = "pic_url", nullable = false, columnDefinition = "VARCHAR(128) COMMENT '照片路径'")
    private String picUrl;

    @Column(name = "born_date", nullable = false, columnDefinition = "DATETIME COMMENT '出生日期'")
    private Date bornDate;

    @Column(name = "start_work_date", nullable = false, columnDefinition = "DATETIME COMMENT '开始工作日期'")
    private Date startWorkDate;

    @Column(name = "enter_school_date", nullable = false, columnDefinition = "DATETIME COMMENT '入校日期'")
    private Date enterSchoolDate;

    @Column(name = "leave_school_date", nullable = false, columnDefinition = "DATETIME COMMENT '离校日期'")
    private Date leaveSchoolDate;

    @Column(name = "id_card", nullable = false, columnDefinition = "VARCHAR(32) COMMENT '身份证号'")
    private String idCard;

    @Column(name = "home_address", columnDefinition = "VARCHAR(128) COMMENT '家庭住址'")
    private String homeAddress;

    @Column(name = "mobile_phone", nullable = false, columnDefinition = "INTEGER(11) COMMENT '手机号'")
    private Integer mobilePhone;
}
