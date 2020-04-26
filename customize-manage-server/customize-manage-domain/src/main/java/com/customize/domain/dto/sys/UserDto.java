package com.customize.domain.dto.sys;

import com.customize.domain.entity.sys.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据交互模型
 * 用户表 sys_user
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserDto extends User {

}
