package com.customize.manage.entity.tb;

import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class School extends BaseEntity {

    private String pkSchoolId;

    private String schoolName;

    private String address;

    private String picUrl;

    private Date buildDate;

    private String chargePersonName;

    private Integer chargePersonPhone;
}
