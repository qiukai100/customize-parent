package com.customize.generator.mapper;

import com.customize.generator.domain.gen.ColumnInfo;
import com.customize.generator.domain.gen.TableInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代码生成 数据层
 */
@Mapper
public interface GenMapper {
    /**
     * 查询ry数据库表信息
     *
     * @return 数据库表列表
     */
    List<TableInfo> selectTableList();

    /**
     * 根据表名称查询信息
     *
     * @param tableName 表名称
     * @return 表信息
     */
    TableInfo selectTableByName(@Param("tableName") String tableName);

    /**
     * 根据表名称查询列信息
     *
     * @param tableName 表名称
     * @return 列信息
     */
    List<ColumnInfo> selectTableColumnsByName(@Param("tableName") String tableName);
}
