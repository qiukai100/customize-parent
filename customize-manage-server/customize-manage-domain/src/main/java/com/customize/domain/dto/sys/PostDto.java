package com.customize.domain.dto.sys;

import com.customize.domain.entity.sys.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据交互模型
 * 岗位表 sys_post
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
public class PostDto extends Post {

}
