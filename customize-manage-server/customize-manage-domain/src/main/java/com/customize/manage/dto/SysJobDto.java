package com.customize.manage.dto;

import com.customize.manage.entity.sys.SysJob;
import com.customize.manage.entity.sys.SysJobType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysJobDto extends SysJob {

    private SysJobType sysJobType;
}
