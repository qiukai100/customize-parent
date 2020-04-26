package com.customize.domain.dto.sys;

import com.customize.domain.entity.sys.Organization;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据交互模型
 * 组织表 sys_organization
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
public class OrganizationDto extends Organization {

}
