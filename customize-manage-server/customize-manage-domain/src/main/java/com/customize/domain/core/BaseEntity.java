package com.customize.domain.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date createTime;

    private String createId;

    private Date updateTime;

    private String updateId;

    private Integer isDelete;

    private Integer version;

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
