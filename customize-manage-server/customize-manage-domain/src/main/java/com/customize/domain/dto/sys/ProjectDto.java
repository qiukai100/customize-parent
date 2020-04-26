package com.customize.domain.dto.sys;

import com.customize.domain.entity.sys.Project;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据交互模型
 * 项目表 sys_project
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Getter
@Setter
@Accessors(chain = true)
public class ProjectDto extends Project {

}
