package com.customize.service.service.tb;

import com.customize.domain.dto.tb.ClazzDto;
import com.customize.domain.entity.tb.Clazz;
import com.customize.domain.vo.tb.ClazzVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

public interface ClazzService extends BaseService<Clazz, String> {

    /**
     * 分页条件查询
     */
    Page<ClazzDto> queryClazzPage(ClazzVo clazzVo);

    /**
     * 条件查询
     */
    List<ClazzDto> queryClazzList(ClazzVo clazzVo);

    /**
     * 查询所有
     */
    List<ClazzDto> selectClazzList();

    /**
     * 根据ID查询
     */
    ClazzDto findById(String pkClazzId);

    /**
     * 根据ID移除（逻辑删除）
     */
    int removeByPrimaryKey(String pkClazzId);

    /**
     * 批量移除（逻辑删除）
     */
    int removeClazzBatch(String[] pkClazzIds);

    /**
     * 批量删除（物理删除）
     */
    int deleteClazzBatch(String[] pkClazzIds);
}
