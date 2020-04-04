package com.customize.mybatis.mapper.tb;

import com.customize.domain.dto.tb.ClazzDto;
import com.customize.domain.entity.tb.Clazz;
import com.customize.domain.vo.tb.ClazzVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazzMapper extends BaseMapper<Clazz> {

    List<ClazzDto> queryClazzList(@Param("clazzVo") ClazzVo clazzVo);

    List<ClazzDto> selectClazzList(@Param("isDelete") Integer isDelete);

    ClazzDto findById(@Param("pkClazzId") String pkClazzId, Integer isDelete);

    int removeByPrimaryKey(@Param("pkClazzId") String pkClazzId, @Param("isDelete") Integer isDelete);

    int removeClazzBatch(@Param("pkClazzIds") String[] pkClazzIds, @Param("isDelete") Integer isDelete);

    int deleteClazzBatch(@Param("pkClazzIds") String[] pkClazzIds);
}
