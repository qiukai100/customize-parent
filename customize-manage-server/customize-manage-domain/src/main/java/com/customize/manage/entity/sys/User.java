package com.customize.manage.entity.sys;

import com.customize.common.annotations.CustVerify;
import com.customize.common.constants.VerifyTypeEnum;
import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User extends BaseEntity {

    @CustVerify(minSize = 32, maxSize = 32)
    private String pkSysUserId;

    @CustVerify(minSize = 6, maxSize = 8)
    private String account;

    @CustVerify(minSize = 6, maxSize = 16)
    private String password;

    @CustVerify(maxSize = 8)
    private String userName;

    @CustVerify(maxSize = 8)
    private String nickName;

    @CustVerify
    private String salt;

    @CustVerify(verifyType = VerifyTypeEnum.EMAIL)
    private String email;

    @CustVerify(verifyType = VerifyTypeEnum.MOBILE_PHONE)
    private Integer phone;

    @CustVerify
    private Integer sex;

    private Date lastLoginTime;

    @CustVerify
    private Integer state;

    private List<Role> roleList;
}
