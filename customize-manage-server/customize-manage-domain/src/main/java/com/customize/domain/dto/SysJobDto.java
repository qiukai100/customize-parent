package com.customize.domain.dto;

import com.customize.domain.entity.sys.SysJob;
import com.customize.domain.entity.sys.SysJobType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SysJobDto extends SysJob {

    private SysJobType sysJobType;
}
