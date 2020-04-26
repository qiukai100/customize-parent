package com.customize.service.service.sys;

import com.customize.domain.dto.sys.PostDto;
import com.customize.domain.entity.sys.Post;
import com.customize.domain.vo.sys.PostVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 岗位表 sys_post
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface IPostService extends BaseService<Post, String> {

    /**
     * 分页条件查询岗位
     */
    Page<PostDto> queryPostPage(PostVo postVo);

    /**
     * 条件查询岗位
     */
    List<PostDto> queryPostList(PostVo postVo);

    /**
     * 查询所有岗位
     */
    List<PostDto> selectPostList();

    /**
     * 根据ID查询岗位
     */
	PostDto findById(String pkPostId);

    /**
     * 根据ID移除岗位（逻辑删除）
     */
    int removeByPrimaryKey(String pkPostId);

    /**
     * 批量移除岗位（逻辑删除）
     */
    int removePostBatch(String[] pkPostIds);

    /**
     * 批量删除岗位（物理删除）
     */
    int deletePostBatch(String[] pkPostIds);
}
