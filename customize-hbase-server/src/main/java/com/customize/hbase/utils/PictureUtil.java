package com.customize.hbase.utils;

import com.customize.hbase.constants.ColumnFamilyType;

public class PictureUtil {

    // 图片路径分割规则
    private final static String ID_BLOCK = "/";

    /**
     * 根据图片数据路径转换为图片自定义url
     * 1、表名/主键（行键）/image（列族）/列名
     *
     * @param tableName  表名
     * @param rowKey     行键
     * @param columnName 列名
     * @return
     */
    public static String pathToUrl(String tableName, String rowKey, String columnName) {
        return tableName.concat(ID_BLOCK).concat(rowKey).concat(ID_BLOCK).concat(ColumnFamilyType.IMAGE.name()).concat(ID_BLOCK).concat(columnName);
    }
}
