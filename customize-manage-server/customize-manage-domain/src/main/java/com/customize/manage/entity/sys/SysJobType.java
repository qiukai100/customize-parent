package com.customize.manage.entity.sys;

import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_job_type")
public class SysJobType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private String pkJobTypeId;

    private String jobTypeName;

    private String managerClass;

    private String function;

    private String parameter;

}
