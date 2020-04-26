package com.customize.domain.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.customize.common.constants.OptionEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("当前页码")
    private Integer pageNum = 0;

    @ApiModelProperty("每页行数")
    private Integer pageSize = 20;

    private Integer isDelete = OptionEnum.NO.getVal();

    @ApiModelProperty(value = "数据状态", example="Enable")
    private String dataStatus;

    @Override
    public String toString() {
        return JSON.toJSONString(this,
                // 日期时间 毫秒 -> "yyyy-MM-dd HH:mm:ss"
                SerializerFeature.WriteDateUseDateFormat,
                // 输出值为null的字段
                SerializerFeature.WriteMapNullValue,
                // 消除对同一对象循环引用
                SerializerFeature.DisableCircularReferenceDetect);
    }
}
