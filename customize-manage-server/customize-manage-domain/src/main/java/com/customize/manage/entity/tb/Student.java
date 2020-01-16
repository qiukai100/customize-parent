package com.customize.manage.entity.tb;

import com.customize.common.annotations.CustVerify;
import com.customize.common.constants.VerifyTypeEnum;
import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Student extends BaseEntity {

    @CustVerify(minSize = 32, maxSize = 32)
    private String pkStuId;

    @CustVerify(minSize = 16, maxSize = 16)
    private String stuNo;

    @CustVerify(maxSize = 8)
    private String name;

    @CustVerify
    private Integer sex;

    private String picUrl;

    @CustVerify
    private Date bornDate;

    @CustVerify
    private Date enterSchoolDate;

    private Date leaveSchoolDate;

    @CustVerify(notEmpty = false, verifyType = VerifyTypeEnum.IDENTITY_CARD)
    private String idCard;

    private String homeAddress;

}