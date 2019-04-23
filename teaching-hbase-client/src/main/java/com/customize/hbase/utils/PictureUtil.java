package com.customize.hbase.utils;

import com.customize.hbase.constants.ColumnFamilyType;
import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;

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


    /**
     * 文件流转byte
     * @param fileInputStream 文件流
     * @param length 长度
     * @return
     */
    public static String getFileByte(FileInputStream fileInputStream, int length) {
        String fileStr = "";
        try {
            byte[] bytes = new byte[length];
            int len = 0;
            while (len != -1) {
                len = fileInputStream.read(bytes);
            }
            BASE64Encoder be = new BASE64Encoder();
            fileStr = be.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fileInputStream);
        }
        return fileStr;
    }
}
