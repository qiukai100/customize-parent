package com.customize.service.service.tb.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.tb.ClazzDto;
import com.customize.domain.entity.tb.Clazz;
import com.customize.domain.vo.tb.ClazzVo;
import com.customize.mybatis.mapper.tb.ClazzMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.tb.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClazzServiceImpl extends BaseServiceImpl<Clazz, String> implements ClazzService {

    private final ClazzMapper clazzMapper;

    @Autowired
    public ClazzServiceImpl(ClazzMapper clazzMapper) {
        super(clazzMapper);
        this.clazzMapper = clazzMapper;
    }

    @Override
    public Page<ClazzDto> queryClazzPage(ClazzVo clazzVo) {
        return PageHelper.startPage(clazzVo.getPageNum(), clazzVo.getPageSize()).doSelectPage(() -> clazzMapper.queryClazzList(clazzVo));
    }

    @Override
    public List<ClazzDto> queryClazzList(ClazzVo clazzVo) {
        return clazzMapper.queryClazzList(clazzVo);
    }

    @Override
    public List<ClazzDto> selectClazzList() {
        return clazzMapper.selectClazzList(OptionEnum.YES.getVal());
    }

    @Override
    public ClazzDto findById(String pkClazzId) {
        return clazzMapper.findById(pkClazzId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkClazzId) {
        return clazzMapper.removeByPrimaryKey(pkClazzId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeClazzBatch(String[] pkClazzIds) {
        return clazzMapper.removeClazzBatch(pkClazzIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteClazzBatch(String[] pkClazzIds) {
        return clazzMapper.deleteClazzBatch(pkClazzIds);
    }
}
