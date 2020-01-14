package com.customize.generator.domain;

import com.customize.generator.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 数据库表
 */
@Getter
@Setter
public class TableInfo extends BaseEntity {

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 表的主键列信息
     */
    private ColumnInfo primaryKey;

    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnInfo> columns;

    /**
     * 类名(第一个字母大写)
     */
    private String className;

    /**
     * 类名(第一个字母小写)
     */
    private String classname;

    public ColumnInfo getColumnsLast() {
        ColumnInfo columnInfo = null;
        if (columns != null && columns.size() > 0) {
            columnInfo = columns.get(0);
        }
        return columnInfo;
    }
}
