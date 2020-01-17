package com.customize.manage.entity.sys;

import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_job")
public class SysJob extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkJobId;

    private String jobName;

    private String jobTypeId;

    private String cronExpressions;

}
