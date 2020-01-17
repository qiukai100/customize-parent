package com.customize.manage.mapper;

import com.customize.manage.core.BaseMapper;
import com.customize.manage.entity.sys.SysJob;

public interface SysJobMapper extends BaseMapper<SysJob, String> {

    /**
     * 新增所有
     *
     * @param record 记录项
     * @return 受影响的行数
     */
    int insert(SysJob record);

    /**
     * 新增非空值
     *
     * @param record 记录项
     * @return 受影响的行数
     */
    int insertSelective(SysJob record);

    /**
     * 主键查询
     *
     * @param id 主键
     * @return 记录项
     */
    SysJob selectByPrimaryKey(String id);

    /**
     * 修改非空值
     *
     * @param record 记录项
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SysJob record);

    /**
     * 修改所有
     *
     * @param record 记录项
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SysJob record);
}