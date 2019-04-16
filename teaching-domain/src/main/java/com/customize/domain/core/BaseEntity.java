package com.customize.domain.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "create_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createTime;

    @Column(name = "create_id", nullable = false, columnDefinition = "VARCHAR(32) COMMENT '创建人'")
    private String createId;

    @Column(name = "update_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'")
    private Date updateTime;

    @Column(name = "update_id", nullable = false, columnDefinition = "VARCHAR(32) COMMENT '修改人'")
    private String updateId;

    @Column(name = "is_delete", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0 COMMENT '是否删除 - 0：否，1：是'")
    private Integer isDelete;

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
