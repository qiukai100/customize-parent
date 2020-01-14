package com.customize.domain.entity.tb;

import com.customize.common.annotations.CustVerify;
import com.customize.common.constants.VerifyTypeEnum;
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
@Entity(name = "tb_student")
@Table(appliesTo = "tb_student", comment = "学生")
public class Student extends BaseEntity {

    @Id
    @CustVerify(minSize = 32, maxSize = 32)
    @Column(name = "pk_stu_id", columnDefinition = "VARCHAR(32) COMMENT '主键'")
    private String pkStuId;

    @CustVerify(minSize = 16, maxSize = 16)
    @Column(name = "stu_no", nullable = false, columnDefinition = "VARCHAR(16) COMMENT '编号（yyMMddHHmmssSSS0）'")
    private String stuNo;

    @CustVerify(maxSize = 8)
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '姓名'")
    private String name;

    @CustVerify
    @Column(name = "sex", nullable = false, columnDefinition = "TINYINT(1) COMMENT '性别 - 1：男，2：女'")
    private Integer sex;

    @Column(name = "pic_url", nullable = false, columnDefinition = "VARCHAR(128) COMMENT '照片路径'")
    private String picUrl;

    @CustVerify
    @Column(name = "born_date", nullable = false, columnDefinition = "DATETIME COMMENT '出生日期'")
    private Date bornDate;

    @CustVerify
    @Column(name = "enter_school_date", nullable = false, columnDefinition = "DATETIME COMMENT '入学日期'")
    private Date enterSchoolDate;

    @Column(name = "leave_school_date", columnDefinition = "DATETIME COMMENT '毕业（开除）日期'")
    private Date leaveSchoolDate;

    @CustVerify(notEmpty = false, verifyType = VerifyTypeEnum.IDENTITY_CARD)
    @Column(name = "id_card", columnDefinition = "VARCHAR(32) COMMENT '身份证号'")
    private String idCard;

    @Column(name = "home_address", columnDefinition = "VARCHAR(128) COMMENT '家庭住址'")
    private String homeAddress;

}