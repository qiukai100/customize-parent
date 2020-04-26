package com.customize.service.service.re.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.re.SysUserPostDto;
import com.customize.domain.entity.re.SysUserPost;
import com.customize.domain.vo.re.SysUserPostVo;
import com.customize.mybatis.mapper.re.SysUserPostMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.re.ISysUserPostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 关联用户岗位表 re_sys_user_post
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class SysUserPostServiceImpl extends BaseServiceImpl<SysUserPost, String> implements ISysUserPostService {

    private final SysUserPostMapper sysUserPostMapper;

    @Autowired
    public SysUserPostServiceImpl(SysUserPostMapper sysUserPostMapper) {
        super(sysUserPostMapper);
        this.sysUserPostMapper = sysUserPostMapper;
    }

    @Override
    public Page<SysUserPostDto> querySysUserPostPage(SysUserPostVo sysUserPostVo) {
        return PageHelper.startPage(sysUserPostVo.getPageNum(), sysUserPostVo.getPageSize()).doSelectPage(() -> sysUserPostMapper.querySysUserPostList(sysUserPostVo));
    }

    @Override
    public List<SysUserPostDto> querySysUserPostList(SysUserPostVo sysUserPostVo) {
        return sysUserPostMapper.querySysUserPostList(sysUserPostVo);
    }

    @Override
    public List<SysUserPostDto> selectSysUserPostList() {
        return sysUserPostMapper.selectSysUserPostList(OptionEnum.YES.getVal());
    }

    @Override
    public SysUserPostDto findById(String pkReUserPostId) {
        return sysUserPostMapper.findById(pkReUserPostId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkReUserPostId) {
        return sysUserPostMapper.removeByPrimaryKey(pkReUserPostId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeSysUserPostBatch(String[] pkReUserPostIds) {
        return sysUserPostMapper.removeSysUserPostBatch(pkReUserPostIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteSysUserPostBatch(String[] pkReUserPostIds) {
        return sysUserPostMapper.deleteSysUserPostBatch(pkReUserPostIds);
    }
}
