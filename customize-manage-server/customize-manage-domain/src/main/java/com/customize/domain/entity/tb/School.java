package com.customize.domain.entity.tb;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class School extends BaseEntity {

    private String pkSchoolId;

    private String schoolName;

    private String address;

    private String picUrl;

    private Date buildDate;

    private String chargePersonName;

    private Integer chargePersonPhone;
}
