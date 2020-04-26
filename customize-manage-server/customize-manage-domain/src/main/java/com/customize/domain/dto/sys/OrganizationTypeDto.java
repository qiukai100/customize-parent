package com.customize.domain.dto.sys;

import com.customize.domain.entity.sys.OrganizationType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_organization_type 表
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("组织类型数据交互模型")
public class OrganizationTypeDto extends OrganizationType {

}
