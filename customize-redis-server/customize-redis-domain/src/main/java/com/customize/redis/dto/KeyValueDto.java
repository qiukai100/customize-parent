package com.customize.redis.dto;

import com.customize.redis.entity.KeyValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyValueDto extends KeyValue {

    private Integer dbNo;

    public KeyValueDto(Object key, Object value) {
        super();
        setKey(key);
        setValue(value);
    }
}
