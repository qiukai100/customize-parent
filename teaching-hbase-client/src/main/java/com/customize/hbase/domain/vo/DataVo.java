package com.customize.hbase.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataVo {

    private String tableName;

    private String rowKey;

    private String columnFamily;

    private String columnName;

}
