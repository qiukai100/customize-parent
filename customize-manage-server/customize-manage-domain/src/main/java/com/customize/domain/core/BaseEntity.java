package com.customize.domain.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 创建时间 */
    @Column(name = "create_time")
    private Date createTime;

    /** 创建人ID */
    @Column(name = "create_id")
    private String createId;

    /** 修改时间 */
    @Column(name = "update_time")
    private Date updateTime;

    /** 修改人ID */
    @Column(name = "update_id")
    private String updateId;

    /** 是否删除 - 0：否，1：是 */
    @Column(name = "is_delete")
    private Integer isDelete;

    /** 版本（乐观锁） */
    @Column(name = "version")
    private Integer version;

    /** 数据状态 - Enable:启用,Disable:禁用 */
    @Column(name = "data_status")
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
