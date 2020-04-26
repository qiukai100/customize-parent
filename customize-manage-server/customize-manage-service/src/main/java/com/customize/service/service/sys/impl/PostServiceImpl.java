package com.customize.service.service.sys.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.PostDto;
import com.customize.domain.entity.sys.Post;
import com.customize.domain.vo.sys.PostVo;
import com.customize.mybatis.mapper.sys.PostMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.IPostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 岗位表 sys_post
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class PostServiceImpl extends BaseServiceImpl<Post, String> implements IPostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        super(postMapper);
        this.postMapper = postMapper;
    }

    @Override
    public Page<PostDto> queryPostPage(PostVo postVo) {
        return PageHelper.startPage(postVo.getPageNum(), postVo.getPageSize()).doSelectPage(() -> postMapper.queryPostList(postVo));
    }

    @Override
    public List<PostDto> queryPostList(PostVo postVo) {
        return postMapper.queryPostList(postVo);
    }

    @Override
    public List<PostDto> selectPostList() {
        return postMapper.selectPostList(OptionEnum.YES.getVal());
    }

    @Override
    public PostDto findById(String pkPostId) {
        return postMapper.findById(pkPostId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkPostId) {
        return postMapper.removeByPrimaryKey(pkPostId, OptionEnum.YES.getVal());
    }

    @Override
    public int removePostBatch(String[] pkPostIds) {
        return postMapper.removePostBatch(pkPostIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deletePostBatch(String[] pkPostIds) {
        return postMapper.deletePostBatch(pkPostIds);
    }
}
