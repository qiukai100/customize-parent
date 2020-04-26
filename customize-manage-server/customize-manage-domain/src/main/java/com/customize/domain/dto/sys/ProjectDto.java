package com.customize.domain.dto.sys;

import com.customize.domain.entity.sys.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_project 表
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("项目数据交互模型")
public class ProjectDto extends Project {

}
