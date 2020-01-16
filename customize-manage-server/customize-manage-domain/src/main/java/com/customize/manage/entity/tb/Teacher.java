package com.customize.manage.entity.tb;

import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 老师表
 */
@Getter
@Setter
public class Teacher extends BaseEntity {

    private String pkTeacherId;

    private String teacherNo;

    private String name;

    private Integer sex;

    private String picUrl;

    private Date bornDate;

    private Date startWorkDate;

    private Date enterSchoolDate;

    private Date leaveSchoolDate;

    private String idCard;

    private String homeAddress;

    private Integer mobilePhone;
}