package com.customize.domain.dto.sys;

import com.customize.domain.entity.sys.Company;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据交互模型
 * 公司表 sys_company
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
public class CompanyDto extends Company {

}
